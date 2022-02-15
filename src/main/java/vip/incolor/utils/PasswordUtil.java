package vip.incolor.utils;

import java.util.Random;

/**
 * @author LiYizhan
 * @email 1062585732@qq.com
 * @description
 * @date 2018/3/31
 * @time 20:49
 */
public class PasswordUtil {
    /**
     * 生成10-15位的随机密码
     *
     * @return
     */
    public static String randomPassword() {
        Random random = new Random();
        int length = random.nextInt(6) + 10;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char ascii = (char) (random.nextInt(94) + 33);
            sb.append(ascii);
        }
        return sb.toString();
    }
}
