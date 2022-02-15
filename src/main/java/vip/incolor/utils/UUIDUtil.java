package vip.incolor.utils;

import java.util.UUID;

/**
 * @author JimLin
 * @email leafyunjim@gmail.com
 * @description  生成主键 UUID
 * @date 2018-03-18
 * @time 14:26
 */
public class UUIDUtil {

    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static String getLongUUID() {
        return UUID.randomUUID().toString();
    }

}
