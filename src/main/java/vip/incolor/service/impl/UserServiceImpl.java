package vip.incolor.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import org.springframework.web.util.HtmlUtils;
import vip.incolor.constant.Constants;
import vip.incolor.dto.RequestResult;
import vip.incolor.dto.SearchCondition;
import vip.incolor.entity.*;
import vip.incolor.exception.PasswordWrongException;
import vip.incolor.exception.ServerInternalException;
import vip.incolor.exception.WrongInputException;
import vip.incolor.mapper.OrderInformationMapper;
import vip.incolor.mapper.UserGivenEmailMapper;
import vip.incolor.mapper.UserMapper;
import vip.incolor.service.UserService;
import vip.incolor.utils.Checker;
import vip.incolor.utils.IncolorResultUtil;
import vip.incolor.service.ExpressService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author JimLin
 * @email leafyunjim@gmail.com
 * @description
 * @date 2018-03-31
 * @time 21:10
 */
@Service
public class  UserServiceImpl implements UserService {

    private UserMapper userMapper;
    private OrderInformationMapper orderInformationMapper;
    private UserGivenEmailMapper userGivenEmailMapper;

    //    @Autowired
//    private ExpressService expressService;
    @Autowired
    public ExpressService expressService;

    @Autowired
    public UserServiceImpl(UserMapper userMapper, OrderInformationMapper orderInformationMapper, UserGivenEmailMapper userGivenEmailMapper) {
        this.userMapper = userMapper;
        this.orderInformationMapper = orderInformationMapper;
        this.userGivenEmailMapper = userGivenEmailMapper;
    }


    /**
     * 查看所有用户
     *
     * @param pageNum 页数
     * @return
     */
    @Override
    public Page<User> checkUser(Integer pageNum) {
        Page<User> list = PageHelper.startPage(pageNum, 5);
        List<User> users = userMapper.selectUser();
        return list;
    }

    /**
     * 冻结帐号
     *
     * @param userId 用户编号
     * @return
     */
    @Override
    public int freezeUser(Integer userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        if (user == null) {
            return -1;
        }
        return userMapper.freezeUser(userId);
    }

    @Override
    public int unfreezeUser(Integer userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        if (user == null) {
            return -1;
        }
        return userMapper.unfreezeUser(userId);
    }

    @Override
    public Page<User> searchUser(SearchCondition con, Integer pageNum) {
        Page<User> list = PageHelper.startPage(pageNum, 5);
        userMapper.selectUserByCondition(con);
        return list;
    }

    @Override
    public int signUpEmail(String email) {
        UserGivenEmail givenEmail = userGivenEmailMapper.selectByEmail(email);
        if (givenEmail != null) {
            return -1;
        }
        if (!Checker.isEmail(email)) {
            return -1;
        }
        UserGivenEmail record = new UserGivenEmail();
        record.setUser_given_email(email);
        return userGivenEmailMapper.insert(record);
    }

    @Override
    public User getUser(Integer orderId) {
        UserExample example = new UserExample();
        example.createCriteria().andUser_idEqualTo(orderId);
        List<User> users = userMapper.selectByExample(example);
        if (!users.isEmpty()) {
            return users.get(0);
        } else {
            return null;
        }
    }

    @Transactional
    @Override
    public void modifyUser(String familyName, String givenName, Boolean gender, String phone, HttpSession session) {
        try {
            int userId = (Integer) session.getAttribute("user_id");
            //int userId=1;
            User user = userMapper.selectByPrimaryKey(userId);

            if (familyName != null) {
                familyName = HtmlUtils.htmlEscape(familyName);
                user.setUser_family_name(familyName);
            }
            if (givenName != null) {
                givenName = HtmlUtils.htmlEscape(givenName);
                user.setUser_given_name(givenName);
            }
            if (gender != null) {
                user.setUser_gender(gender);
            }
            if (phone != null) {
                if (!Checker.isHomePhone(phone) && !Checker.isChinaMobilePhone(phone)) {
                    throw new WrongInputException();
                }
                user.setUser_phone(phone);
            }

            userMapper.updateByPrimaryKeySelective(user);
        } catch (WrongInputException e) {
            throw e;
        } catch (Exception e) {
            throw new ServerInternalException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public void modifyPassword(String oldPassword, String newPassword, HttpSession session) {
        try {
            String oldMd5 = DigestUtils.md5DigestAsHex((oldPassword + Constants.STATIC_SALT).getBytes());
            System.out.println("oldMd5: " + oldMd5);
            int userId = (Integer) session.getAttribute("user_id");
            System.out.println("user_id: " + userId);
            User user = userMapper.getByIdAndPassword(userId, oldMd5);
            System.out.println("user: " + user);
            if (user == null) {
                throw new PasswordWrongException();
            } else {
                String newMd5 = DigestUtils.md5DigestAsHex((newPassword + Constants.STATIC_SALT).getBytes());
                user.setUser_password(newMd5);
                userMapper.updateByPrimaryKeySelective(user);
            }
        } catch (PasswordWrongException e) {
            throw e;
        } catch (Exception e) {
            throw new ServerInternalException(e.getMessage());
        }
    }

    @Override   //改
    @Transactional
    public void modifyEmail(String email, String password, HttpSession session) {
        try {
            int userId = (Integer) session.getAttribute("user_id");
            System.out.println("userId: " + userId);
            User user2 = userMapper.selectByPrimaryKey(userId);
            String passwordMd5 = DigestUtils.md5DigestAsHex((password + Constants.STATIC_SALT).getBytes());
            User user1 = userMapper.getByIdAndPassword(userId, passwordMd5);
            System.out.println("user1: " + user1);
            if (user1 == null) {
                throw new PasswordWrongException();
            } else {

                //String newEmail = email;
//                    newEmail = HtmlUtils.htmlEscape(newEmail);
                if (!Checker.isEmail(email)) {
                    throw new WrongInputException();
                }
                user1.setUser_mail(email);
                userMapper.updateByPrimaryKeySelective(user1);
            }
        } catch (PasswordWrongException e) {
            throw e;
        } catch (Exception e) {
            throw new ServerInternalException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public String getExpress(Integer orderId) {
        try {
//            Integer userId = (Integer) session.getAttribute("user_id");
            //ExpressServicelmpl expressServicelmpl = new ExpressServicelmpl();
            String expressNumber = expressService.getMyExpressNumber(orderId);
            String result = expressService.postMyExpress(expressNumber);
            return result;
        } catch (WrongInputException e) {
            throw e;
        } catch (Exception e) {
            throw new ServerInternalException(e.getMessage());
        }
    }

    @Override
    public List<UserGivenEmail> getSignUpEmail() {
        return userGivenEmailMapper.selectDistinctSignUpEmail();
    }

}


//    @Override
//    public Integer getOrderIdFromOrderInfo(Integer userId) {
//        OrderInformationExample example = new OrderInformationExample();
//        example.createCriteria().andUser_idEqualTo(userId);
//        List<OrderInformation> list = orderInformationMapper.selectByExample(example);
//        if (!list.isEmpty()) {
//            return list.get(0).getOrder_id();
//        }
//        return null;
//    }
//}
