package vip.incolor.service;

import com.github.pagehelper.Page;
import vip.incolor.entity.Manager;

import java.util.List;

/**
 * @author LiYizhan
 * @email 1062585732@qq.com
 * @description
 * @date 2018/3/29
 * @time 22:09
 */
public interface ManagerService {
    byte SUPER = 0;
    byte BOSS = 1;
    byte NORMAL = 2;

    void addAdmin(String account, byte level,String password);

    void deleteAdmin(int id);

    Page<Manager> checkManager(Integer pageNum, Integer pageSize);
}
