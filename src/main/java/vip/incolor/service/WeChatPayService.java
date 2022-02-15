package vip.incolor.service;

import vip.incolor.dto.ReceiverInfo;

import javax.servlet.http.HttpSession;

/**
 * @author LiYizhan
 * @email 1062585732@qq.com
 * @description
 * @date 2018/4/9
 * @time 16:22
 */
public interface WeChatPayService {
    byte[] getQRCode(ReceiverInfo info);
    void onNotify(String notifyXml);
    void consultPayStatus(HttpSession session);
}
