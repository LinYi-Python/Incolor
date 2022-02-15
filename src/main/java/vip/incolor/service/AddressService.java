package vip.incolor.service;

import vip.incolor.entity.Address;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author LiYizhan
 * @email 1062585732@qq.com
 * @description
 * @date 2018/4/23
 * @time 19:02
 */
public interface AddressService {
    List<Address> getAddress(int userId);
    void addAddress(HttpSession session,Address address);
    void modifyAddress(Address address, HttpSession session);
    void deleteAddress(HttpSession session,int addressId);
}
