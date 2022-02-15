package vip.incolor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import vip.incolor.service.ExpressService;
import vip.incolor.exception.ServerInternalException;
import vip.incolor.exception.WrongInputException;
import vip.incolor.utils.GsonUtil;

import java.util.Map;

/**
 * @author LinPython
 * @email ly546654542@gmail.com
 * @description
 * @date 2018/4/29
 * @time 15:21
 */
@RestController
@RequestMapping("express")
public class ExpressController {

    private ExpressService expressService;

    @Autowired
    public ExpressController(ExpressService expressService){
        this.expressService = expressService;
    }

    @RequestMapping("/getMyExpressNumber")
    @ResponseBody
    public String getMyExpressNumber(Integer orderId){
        String expressNumber = expressService.getMyExpressNumber(orderId);
        return GsonUtil.getSuccessJson(expressNumber);

    }


    @RequestMapping("/modifyMyExpressNumber")
    @ResponseBody
    public String modifyMyExpressNumber(Integer orderId, String ExpressNumber){
        try{
            expressService.modifyMyExpressNumber(orderId, ExpressNumber);
            return GsonUtil.getSuccessJson();
        }catch (WrongInputException e){
            return GsonUtil.getErrorJson("wrong input");
        }catch (ServerInternalException e){
            return GsonUtil.getErrorJson("server internal error");
        }
    }

    @RequestMapping("/deleteMyExpressNumber")
    @ResponseBody
    public String deleteMyExpressNumber(Integer orderId){
        try{
            expressService.deleteMyExpressNumber(orderId);
            return GsonUtil.getSuccessJson();
        } catch (ServerInternalException e){
            return GsonUtil.getErrorJson("server internal error");
        }
    }

    @RequestMapping("/postMyExpress")
    @ResponseBody
    public String postMyExpress(String expressNumber) {
        try {
            expressService.postMyExpress(expressNumber);
            return GsonUtil.getSuccessJson();
        }catch (WrongInputException e){
            return GsonUtil.getErrorJson("wrong input");
        }catch (ServerInternalException e){
            return GsonUtil.getErrorJson("server internal error");
        }
    }

    /*@RequestMapping("getMyExpress")
    @ResponseBody
    public String getMyExpress(Integer orderId){
        try {
            expressService.getMyExpress(orderId);
            return GsonUtil.getSuccessJson();
        }catch (WrongInputException e){
            return GsonUtil.getErrorJson("wrong input");
        }catch (ServerInternalException e){
            return GsonUtil.getErrorJson("server internal error");
        }
    }*/



}
