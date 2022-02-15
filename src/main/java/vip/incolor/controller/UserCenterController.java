package vip.incolor.controller;

import com.alibaba.fastjson.JSONArray;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import vip.incolor.dto.FrontOrder;
import vip.incolor.dto.MultiInvoices;
import vip.incolor.entity.Address;
import vip.incolor.entity.Order;
import vip.incolor.entity.User;
import vip.incolor.exception.PasswordWrongException;
import vip.incolor.exception.ServerInternalException;
import vip.incolor.exception.WrongInputException;
import vip.incolor.service.AddressService;
import vip.incolor.service.InvoicesService;
import vip.incolor.service.OrderService;
import vip.incolor.service.UserService;
import vip.incolor.utils.GsonUtil;
import vip.incolor.vo.PropertyVO;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("usercenter")
public class UserCenterController {

    private UserService userService;
    private AddressService addressService;
    private InvoicesService invoicesService;
    private OrderService orderService;

    @Autowired
    public UserCenterController(UserService userService,
                                AddressService addressService,
                                InvoicesService invoicesService,
                                OrderService orderService) {
        this.userService = userService;
        this.addressService = addressService;
        this.invoicesService = invoicesService;
        this.orderService = orderService;
    }

    @RequestMapping("/getMyUser")
    @ResponseBody
    public String getMyUser(HttpSession session) {  //ok
        try {
            int userId = (Integer) session.getAttribute("user_id");
            User user = userService.getUser(userId);
            return GsonUtil.getSuccessJson(user);
        } catch (WrongInputException e) {
            return GsonUtil.getErrorJson("wrong input");
        } catch (ServerInternalException e) {
            return GsonUtil.getErrorJson("server internal error");
        }
    }

    @RequestMapping("/modifyMyUser") //ok
    @ResponseBody
    public String modifyMyUser(@RequestParam(required = false) String familyName, @RequestParam(required = false) String givenName, @RequestParam(required = false) Boolean gender, String phone, HttpSession session) {
        try {
            userService.modifyUser(familyName, givenName, gender, phone, session);
            return GsonUtil.getSuccessJson();
        } catch (WrongInputException e) {
            e.printStackTrace();
            return GsonUtil.getErrorJson("wrong input");
        } catch (ServerInternalException e) {
            e.printStackTrace();
            return GsonUtil.getErrorJson("server internal error");
        }
    }

    @RequestMapping("/getMyAddress")     //ok
    @ResponseBody
    public String getMyAddress(HttpSession session) {
        int userId = (Integer) session.getAttribute("user_id");   //TODO:校验下session-key字段
        List<Address> addresses = addressService.getAddress(userId);
        return GsonUtil.getSuccessJson(addresses);
    }

    @RequestMapping("/addMyAddress")     //ok
    @ResponseBody
    public String addMyAddress(HttpSession session, Address address) {
        try {
            // List<PropertyVO> propertyVOs = JSONArray.parseArray(body, PropertyVO.class);
            addressService.addAddress(session, address);
            return GsonUtil.getSuccessJson();
        } catch (WrongInputException e) {
            e.printStackTrace();
            return GsonUtil.getErrorJson("wrong input");
        } catch (ServerInternalException e) {
            e.printStackTrace();
            return GsonUtil.getErrorJson("server internal error");
        }
    }

    @RequestMapping(value = "/modifyMyAddress", method = RequestMethod.POST)     //ok
    @ResponseBody
    public String modifyMyAddress(Address address, HttpSession session) {
        try {
//            System.out.println("test");
//            System.out.println("test1" + address);
            addressService.modifyAddress(address, session);
            return GsonUtil.getSuccessJson();
        } catch (WrongInputException e) {
            e.printStackTrace();
            return GsonUtil.getErrorJson("wrong input");
        } catch (ServerInternalException e) {
            e.printStackTrace();
            return GsonUtil.getErrorJson("server internal error");
        }
    }

    @RequestMapping("/deleteMyAddress")
    @ResponseBody
    public String deleteMyAddress(HttpSession session, Integer addressId) {
        try {
            addressService.deleteAddress(session, addressId);
            return GsonUtil.getSuccessJson();
        } catch (ServerInternalException e) {
            e.printStackTrace();
            return GsonUtil.getErrorJson("server internal error");
        }
    }

    @RequestMapping("/getMyInvoices")
    @ResponseBody
    public String getMyInvoices(HttpSession session) {
        MultiInvoices multiInvoices = invoicesService.getInvoices(session);
        if (multiInvoices == null) {
            return GsonUtil.getErrorJson("no invoices");
        } else {
            return GsonUtil.getSuccessJson(multiInvoices);
        }
    }

    @RequestMapping("/addMyInvoices")
    @ResponseBody
    public String addMyInvoices(HttpSession session, MultiInvoices multiInvoices) {
        try {
            invoicesService.addInvoices(session, multiInvoices);
            return GsonUtil.getSuccessJson();
        } catch (WrongInputException e) {
            e.printStackTrace();
            return GsonUtil.getErrorJson("wrong input");
        } catch (ServerInternalException e) {
            e.printStackTrace();
            return GsonUtil.getErrorJson("server internal error");
        }
    }

    @RequestMapping("/modifyMyInvoices")
    @ResponseBody
    public String modifyMyInvoices(HttpSession session, MultiInvoices multiInvoices) {
        try {
            invoicesService.modifyInvoices(session, multiInvoices);
            return GsonUtil.getSuccessJson();
        } catch (WrongInputException e) {
            e.printStackTrace();
            return GsonUtil.getErrorJson("wrong input");
        } catch (ServerInternalException e) {
            e.printStackTrace();
            return GsonUtil.getErrorJson("server internal error");
        }
    }

    @RequestMapping("/getMyOrder")
    @ResponseBody
    public String getMyOrder(HttpSession session) { //,Boolean isPayed
        try {
            List<FrontOrder> list = orderService.getMyHistoryOrder(session);
            return GsonUtil.getSuccessJson(list);
        } catch (ServerInternalException e) {
            e.printStackTrace();
            return GsonUtil.getErrorJson();
        }
    }

    @RequestMapping(value = "/modifyMyPassword", method = RequestMethod.POST)
    @ResponseBody
    public String modifyMyPassword(@RequestParam String oldPassword,
                                   @RequestParam String newPassword,
                                   HttpSession session) {
        try {
            userService.modifyPassword(oldPassword, newPassword, session);
            return GsonUtil.getSuccessJson();
        } catch (PasswordWrongException e) {
            e.printStackTrace();
            return GsonUtil.getErrorJson("password wrong");
        } catch (ServerInternalException e) {
            e.printStackTrace();
            return GsonUtil.getErrorJson("server internal error");
        }
    }

    @RequestMapping("/modifyMyEmail")   //ok
    @ResponseBody
    public String modifyMyEmail(@RequestParam String email, @RequestParam String password, HttpSession session) {
        try {
            userService.modifyEmail(email, password, session);
            return GsonUtil.getSuccessJson();
        } catch (PasswordWrongException e) {
            e.printStackTrace();
            return GsonUtil.getErrorJson("password wrong");
        } catch (ServerInternalException e) {
            e.printStackTrace();
            return GsonUtil.getErrorJson("server internal error");
        }
    }

    @RequestMapping("/getMyExpress")
    @ResponseBody
    public String getMyExpress(Integer orderId) {
        try {
            String expressResult=userService.getExpress(orderId);
            return expressResult;
            //return GsonUtil.getSuccessJson(expressResult);
        } catch (PasswordWrongException e) {
            e.printStackTrace();
            return GsonUtil.getErrorJson("password wrong");
        } catch (ServerInternalException e) {
            e.printStackTrace();
            return GsonUtil.getErrorJson("server internal error");
        }

    }

//    @RequestMapping("/getMyOrderIdFromOrderInfo")
//    @ResponseBody
//    public String getMyOrderIdFromOrderInfo(Integer userId) {
//        try {
//            userService.getOrderIdFromOrderImfo(userId);
//            return GsonUtil.getSuccessJson();
//        } catch (PasswordWrongException e) {
//            e.printStackTrace();
//            return GsonUtil.getErrorJson("password wrong");
//        } catch (ServerInternalException e) {
//            e.printStackTrace();
//            return GsonUtil.getErrorJson("server internal error");
//        }
//    }

    @RequestMapping("/listMyOrder")
    @ResponseBody
    public String listMyOrder(HttpSession session){
        Integer userId=(Integer)session.getAttribute("user_id");
        if(userId==null){
            return GsonUtil.getErrorJson("请先登录");
        }
        List<Order> orders=orderService.list(userId);
        if(orders.isEmpty()){
            return GsonUtil.getErrorJson("没有数据");
        }else{
            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd HH:mm:ss")
                    .create();
            return GsonUtil.getSuccessJson(gson,orders);
        }
    }

    @RequestMapping("/viewMyOrderDetail")
    @ResponseBody
    public String viewMyOrderDetail(HttpSession session,Integer orderId){
        List<HashMap<String, Object>> result = orderService.getPayedShoppingCart((Integer) session.getAttribute("user_id"),orderId);
        if (result.isEmpty()) {
            return GsonUtil.getErrorJson("没有数据");
        }
        return GsonUtil.getSuccessJson(result);
    }
}
