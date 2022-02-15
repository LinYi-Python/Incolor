package vip.incolor.service;

import vip.incolor.dto.ReceiverInfo;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author LiYizhan
 * @email 1062585732@qq.com
 * @description
 * @date 2018/6/1
 * @time 19:48
 */
public interface UnionPayService {
    String order(ReceiverInfo info, HttpServletResponse response);
    void notifyUrl(Map<String,String> resp,String encoding);
    void consultPayStatus(HttpSession session);
}
