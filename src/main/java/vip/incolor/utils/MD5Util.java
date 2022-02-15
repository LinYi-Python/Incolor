package vip.incolor.utils;

import vip.incolor.exception.ServerInternalException;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author LiYizhan
 * @email 1062585732@qq.com
 * @description 不用这个md5加密了，用Spring自带的加密，写出来只是给你学习的！
 * @date 2018/3/29
 * @time 22:40
 */
public class MD5Util {
    private static final char[] HEX_DIGITS={'0','1','2','3','4','5','6','7','8','9'
            ,'A','B','C','D','E','F'};

    public static String md5(String original){
        try {
            MessageDigest messageDigest=MessageDigest.getInstance("MD5");
            byte[] digest=messageDigest.digest(original.getBytes("utf-8"));
            char[] value=new char[digest.length*2];
            for(int i=0,j=0;i<digest.length;i++){
                value[j++]=HEX_DIGITS[(digest[i] >> 4) & 0x0f];
                value[j++]=HEX_DIGITS[digest[i] & 0x0f];
            }
            return new String(value);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            throw new ServerInternalException(e.getMessage());
        }
    }

}
