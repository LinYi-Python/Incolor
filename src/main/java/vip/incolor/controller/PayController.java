package vip.incolor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import vip.incolor.dto.ReceiverInfo;
import vip.incolor.exception.NotPayException;
import vip.incolor.exception.ServerInternalException;
import vip.incolor.service.AliPayService;
import vip.incolor.service.UnionPayService;
import vip.incolor.service.WeChatPayService;
import vip.incolor.utils.Base64Util;
import vip.incolor.utils.GsonUtil;
//import vip.incolor.utils.unionpay.SDKConstants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Base64;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author LiYizhan
 * @email 1062585732@qq.com
 * @description 该Controller下需要做登录拦截认证
 * @date 2018/4/9
 * @time 16:56
 */

@Controller
@RequestMapping("pay")
public class PayController {
    private WeChatPayService weChatPayService;
    private AliPayService aliPayService;
    private UnionPayService unionPayService;

//    @Autowired
//    public PayController(WeChatPayService weChatPayService,AliPayService aliPayService,UnionPayService unionPayService) {
//        super();
//        this.weChatPayService=weChatPayService;
//        this.aliPayService=aliPayService;
////        this.unionPayService=unionPayService;
//    }
//    银联来了再启用

    @Autowired
    public PayController(WeChatPayService weChatPayService,AliPayService aliPayService) {
        super();
        this.weChatPayService=weChatPayService;
        this.aliPayService=aliPayService;
    }



    @RequestMapping(value = "/getWeChatQRCode")
    @ResponseBody
    public String getWeChatQRCode(@RequestBody ReceiverInfo info, HttpServletResponse response){
        try{
            response.setContentType("image/png");
            byte[] qrcode=weChatPayService.getQRCode(info);
            /*OutputStream os=response.getOutputStream();
            os.write(qrcode);
            os.flush();
            os.close();*/
            String base64= Base64Util.byte2String(qrcode);
            /*return GsonUtil.getSuccessJson();*/
            return GsonUtil.getSuccessJson(base64);
        }catch (/*IOException |*/ ServerInternalException e){
            return GsonUtil.getErrorJson("Fail to get qrcode");
        }
    }

    @RequestMapping(value = "/consultWeChatPayStatus")
    @ResponseBody
    public String consultWeChatPayStatus(HttpSession session){
        try {
            weChatPayService.consultPayStatus(session);
            return GsonUtil.getSuccessJson();
        } catch (NotPayException e) {
            return GsonUtil.getErrorJson("not pay");
        } catch (ServerInternalException e){
            return GsonUtil.getErrorJson("order not found");
        }
    }

    @RequestMapping(value = "/onCallWeChatPay")
    @ResponseBody
    public String onCallWeChatPay(@RequestBody String notifyXml){
        try {
            weChatPayService.onNotify(notifyXml);
            return "<xml><return_code><![CDATA[SUCCESS]]></return_code>" +
                    "<return_msg><![CDATA[OK]]></return_msg>" +
                    "</xml>";
        } catch (Exception e) {
            return "fail";
        }
    }

    @RequestMapping(value = "/consultAliPayStatus")
    @ResponseBody
    public String consultAliPayStatus(HttpSession session){
        try {
            aliPayService.consultPayStatus(session);
            return GsonUtil.getSuccessJson();
        } catch (NotPayException e) {
            return GsonUtil.getErrorJson("not pay");
        } catch (ServerInternalException e){
            return GsonUtil.getErrorJson("order not found");
        }
    }

    @RequestMapping(value = "/consultUnionPayStatus")
    @ResponseBody
    public String consultUnionPayStatus(HttpSession session){
        try {
            unionPayService.consultPayStatus(session);
            return GsonUtil.getSuccessJson();
        } catch (NotPayException e) {
            return GsonUtil.getErrorJson("not pay");
        } catch (ServerInternalException e){
            return GsonUtil.getErrorJson("order not found");
        }
    }

    @RequestMapping(value = "/onCallAliPay")
    @ResponseBody
    public String onCallAliPay(HttpServletRequest request){
        try {
            Enumeration<String> enu=request.getParameterNames();
            Map<String,String> resp=new HashMap<>();
            while(enu.hasMoreElements()){
                String key=enu.nextElement();
                String value=request.getParameter(key);
                resp.put(key,value);
            }
            aliPayService.notifyUrl(resp);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "failure";
        }
    }

//    @RequestMapping(value = "/onCallUnionPay")
//    @ResponseBody
//    public String onCallUnionPay(HttpServletRequest request){
//        try {
//            Enumeration<String> enu=request.getParameterNames();
//            Map<String,String> resp=new HashMap<>();
//            while(enu.hasMoreElements()){
//                String key=enu.nextElement();
//                String value=request.getParameter(key);
//                resp.put(key,value);
//            }
//            unionPayService.notifyUrl(resp,request.getParameter(SDKConstants.param_encoding));
//            return "success";
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "failure";
//        }
//    }

    @RequestMapping(value = "/alipayOrder")
    @ResponseBody
    public String alipayOrder(@RequestBody ReceiverInfo receiverInfo,HttpServletResponse response){
        try {
            String form=aliPayService.order(receiverInfo,response);
            return form;
            /*return GsonUtil.getSuccessJson(form);*/
        } catch (Exception e) {
            e.printStackTrace();
            return GsonUtil.getErrorJson("下单失败");
        }
    }

    @RequestMapping(value = "/unionpayOrder")
    @ResponseBody
    public String unionpayOrder(@RequestBody ReceiverInfo receiverInfo,HttpServletResponse response){
        try{
            return unionPayService.order(receiverInfo,response);
        } catch (Exception e){
            e.printStackTrace();
            return GsonUtil.getErrorJson("下单失败");
        }
    }
}
