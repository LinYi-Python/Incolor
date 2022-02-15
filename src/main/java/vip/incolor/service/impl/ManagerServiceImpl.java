package vip.incolor.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import org.springframework.web.util.HtmlUtils;
import vip.incolor.constant.Constants;
import vip.incolor.entity.Manager;
import vip.incolor.exception.ServerInternalException;
import vip.incolor.exception.WrongInputException;
import vip.incolor.mapper.ManagerMapper;
import vip.incolor.service.ManagerService;
import vip.incolor.utils.Checker;
import vip.incolor.utils.PasswordUtil;

import java.util.List;

/**
 * @author LiYizhan
 * @email 1062585732@qq.com
 * @description
 * @date 2018/3/29
 * @time 22:10
 */
@Service
public class ManagerServiceImpl implements ManagerService {

    private ManagerMapper managerMapper;

    @Autowired
    public ManagerServiceImpl(ManagerMapper managerMapper) {
        super();
        this.managerMapper = managerMapper;
    }


    @Override
    @Transactional(rollbackFor = {WrongInputException.class, ServerInternalException.class, Exception.class})
    public void addAdmin(String account, byte level, String password) {
        try {
            Manager manager = new Manager();
            if (!Checker.isIncolorAdminAccount(account)) {
                throw new WrongInputException();
            }
            if (!Checker.isIncolorAdminLevel(level)) {
                throw new WrongInputException();
            }
            if (!Checker.isIncolorAdminPassword(password)) {
                throw new WrongInputException();
            }
            account = HtmlUtils.htmlEscape(account);
            password = HtmlUtils.htmlEscape(password);
            String passwordMd5 = DigestUtils.md5DigestAsHex((password + Constants.STATIC_SALT).getBytes());
            //自动生成密码
//            String password = PasswordUtil.randomPassword();
            manager.setManager_account(account);
            manager.setManager_level(level);
            manager.setManager_password(passwordMd5);
            if (managerMapper.insert(manager) < 1) {
                throw new ServerInternalException();
            }
        } catch (WrongInputException | ServerInternalException e) {
            throw e;
        } catch (Exception e) {
            throw new ServerInternalException(e.getMessage());
        }
    }

    @Override
    public void deleteAdmin(int id) {
        try {
            managerMapper.deleteByPrimaryKey(id);

        } catch (WrongInputException e) {
            throw e;
        } catch (Exception e) {
            throw new ServerInternalException(e.getMessage());
        }
    }
    @Override
    public Page<Manager> checkManager(Integer pageNum, Integer pageSize) {
        Page<Manager> list = PageHelper.startPage(pageNum, pageSize);
        List<Manager> managers = managerMapper.list();
        return list;
    }
}
