package vip.incolor.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.incolor.utils.GsonUtil;

import javax.servlet.http.HttpSession;

/**
 * @author LiYizhan
 * @email 1062585732@qq.com
 * @description
 * @date 2018/4/30
 * @time 17:46
 */
@RestController
@RequestMapping("testtesttest")
public class TestController {

    @RequestMapping("/userLogin")
    public String userLogin(int userId, HttpSession session){
        session.setAttribute("user_id",userId);
        return GsonUtil.getSuccessJson();
    }

    @RequestMapping("/getExpressInfo")
    public String express(){
        String url = "https://api.apishop.net/common/express/getExpressInfo";
        String apiKey = "9TftJ5Pa38991ca4153e693d319c8b0544cc469d4c3c1c4";
        String expressType = "";
        String expressNumber = "880631878171";
        String parameters =url +"?apiKey="+ apiKey +"&expressNumber="+ expressNumber + "&expressType="+ expressType;
        return parameters;
    }
}

