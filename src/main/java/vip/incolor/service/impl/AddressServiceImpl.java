package vip.incolor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;
import vip.incolor.entity.Address;
import vip.incolor.entity.AddressExample;
import vip.incolor.exception.ServerInternalException;
import vip.incolor.exception.WrongInputException;
import vip.incolor.mapper.AddressMapper;
import vip.incolor.service.AddressService;
import vip.incolor.utils.Checker;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author LiYizhan
 * @email 1062585732@qq.com
 * @description
 * @date 2018/4/23
 * @time 19:03
 */
@Service
public class AddressServiceImpl implements AddressService {

    private AddressMapper addressMapper;

    @Autowired
    public AddressServiceImpl(AddressMapper addressMapper) {
        super();
        this.addressMapper=addressMapper;
    }

    @Override
    public List<Address> getAddress(int userId) {
        AddressExample example=new AddressExample();
        example.createCriteria().andUser_idEqualTo(userId);
        example.setOrderByClause("is_default_address asc");
        return addressMapper.selectByExample(example);
    }

    @Override
    @Transactional
    public void addAddress(HttpSession session,Address address) {
        try {
            handleAddress(address);
            int userId=(Integer) session.getAttribute("user_id");
            checkDefault(address,userId);
            address.setUser_id(userId);     //改了
            addressMapper.insert(address);
        } catch (WrongInputException e){
            throw e;
        }catch (Exception e) {
            throw new ServerInternalException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public void modifyAddress(Address address, HttpSession session) {    //ok
        try {
            System.out.println("test2"+address);
            handleAddress(address);
            int userId=(Integer)session.getAttribute("user_id");    //改了
            checkDefault(address,userId);
            addressMapper.updateByPrimaryKeySelective(address);
        } catch (WrongInputException e){
            throw e;
        }catch (Exception e) {
            throw new ServerInternalException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public void deleteAddress(HttpSession session,int addressId) {      //ok
        Address address=addressMapper.selectByPrimaryKey(addressId);
        if(address!=null){
            boolean isDefaultAddress=address.getIs_default_address();
            addressMapper.deleteByPrimaryKey(addressId);
            if(isDefaultAddress){
                AddressExample example=new AddressExample();
                int userId=(Integer)session.getAttribute("user_id");
                example.createCriteria().andUser_idEqualTo(userId);
                example.setOrderByClause("address_create_time desc");
                List<Address> addresses=addressMapper.selectByExample(example);
                if(!addresses.isEmpty()){
                    Address newDefaultAddress=addresses.get(0);
                    newDefaultAddress.setIs_default_address(true);
                    addressMapper.updateByPrimaryKeySelective(newDefaultAddress);
                }
            }
        }
    }

    private void handleAddress(Address address){
        String phone=address.getOrder_phone();
        if(!Checker.isChinaMobilePhone(phone)&&!Checker.isHomePhone(phone)){
            throw new WrongInputException();
        }
        String familyName= HtmlUtils.htmlEscape(address.getOrder_fmaily_name());
        String givenName=HtmlUtils.htmlEscape(address.getOrder_given_name());
        String detailAddress=HtmlUtils.htmlEscape(address.getDetailed_address());
        address.setOrder_fmaily_name(familyName);
        address.setOrder_given_name(givenName);
        address.setDetailed_address(detailAddress);
    }

    private void checkDefault(Address address,int userId){
        boolean isDefaultAddress=address.getIs_default_address();
        if(isDefaultAddress){
            AddressExample example=new AddressExample();
            example.createCriteria().
                    andUser_idEqualTo(userId).
                    andIs_default_addressEqualTo(true);
            List<Address> addresses=addressMapper.selectByExample(example);
            for(Address oldAddress:addresses){
                oldAddress.setIs_default_address(false);
                addressMapper.updateByPrimaryKeySelective(oldAddress);
            }
        }
    }
}
