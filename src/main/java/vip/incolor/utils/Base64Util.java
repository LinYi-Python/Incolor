package vip.incolor.utils;

import java.util.Base64;

public class Base64Util {
    private static final Base64.Decoder decoder=Base64.getDecoder();
    private static final Base64.Encoder encoder=Base64.getEncoder();

    public static byte[] string2Byte(String base64Str){
        if(base64Str.startsWith("data:image/jpeg;base64,")){
            base64Str=base64Str.replace("data:image/jpeg;base64,","");
        }
        return decoder.decode(base64Str);
    }

    public static String byte2String(byte[] base64Byte){
        return encoder.encodeToString(base64Byte);
    }

}
