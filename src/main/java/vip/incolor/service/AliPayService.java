package vip.incolor.service;

import com.alipay.api.AlipayApiException;
import vip.incolor.dto.ReceiverInfo;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author LiYizhan
 * @email 1062585732@qq.com
 * @description
 * @date 2018/4/22
 * @time 17:31
 */
public interface AliPayService {
    String  order(ReceiverInfo info, HttpServletResponse response);
    void notifyUrl(Map<String,String> resp) throws AlipayApiException;
    void consultPayStatus(HttpSession session);
}
