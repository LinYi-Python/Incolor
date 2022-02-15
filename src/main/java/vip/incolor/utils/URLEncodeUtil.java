package vip.incolor.utils;

import java.io.UnsupportedEncodingException;

/**
 * @author: JimLin
 * @description:
 * @email leafyunjim@gmail.com
 * @date: 2018-04-20
 * @time: 20:18
 */
public class URLEncodeUtil {

    private final static String ENCODE = "UTF-8";

    /**
     * URL 解码
     */
    public static String getURLDecoderString(String str) {
        String result = "";
        if (null == str) {
            return "";
        }
        try {
            result = java.net.URLDecoder.decode(str, ENCODE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * URL 转码
     */
    public static String getURLEncoderString(String str) {
        String result = "";
        if (null == str) {
            return "";
        }
        try {
            result = java.net.URLEncoder.encode(str, ENCODE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

}
