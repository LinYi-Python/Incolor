package vip.incolor.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import vip.incolor.dto.RequestResult;
import vip.incolor.entity.Manager;
import vip.incolor.exception.ServerInternalException;
import vip.incolor.exception.WrongInputException;
import vip.incolor.service.ManagerService;
import vip.incolor.utils.GsonUtil;
import vip.incolor.utils.IncolorResultUtil;

import java.util.HashMap;

/**
 * @author LiYizhan
 * @email 1062585732@qq.com
 * @description
 * @date 2018/3/29
 * @time 22:01
 */

@Controller
@RequestMapping("manager")
public class AdminManagerController {
    private ManagerService managerService;

    @Autowired
    public AdminManagerController(ManagerService managerService) {
        super();
        this.managerService = managerService;
    }


    @RequestMapping(value = "/addAdmin")
    @ResponseBody
    public String addAdmin(@RequestParam("account") String account,
                           @RequestParam("level") byte level, @RequestParam("password") String password) {
        try {
            managerService.addAdmin(account, level,password);
            return GsonUtil.getSuccessJson(password);
        } catch (WrongInputException e) {
            return GsonUtil.getErrorJson("Wrong input.");
        } catch (ServerInternalException e) {
            return GsonUtil.getErrorJson("Server internal error.");
        }
    }

    @RequestMapping(value = "/deleteAdmin")
    @ResponseBody
    public String deleteAdmin(@RequestParam("id") int id) {
        managerService.deleteAdmin(id);
        return GsonUtil.getSuccessJson();
    }

    @RequestMapping(value = "/queryAdmin")
    @ResponseBody
    public RequestResult queryAdmin(@RequestParam("pageNum") Integer pageNum,
                                    @RequestParam("pageSize") Integer pageSize) {
        Page<Manager> list = managerService.checkManager(pageNum, pageSize);
        if (list.getTotal() > 0) {
            return IncolorResultUtil.success(list, list.getPages(), list.getTotal());
        } else {
            return IncolorResultUtil.error("没有数据");
        }
    }
}
