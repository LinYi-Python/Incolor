package vip.incolor.utils;

/**
 * @author LiYizhan
 * @email 1062585732@qq.com
 * @description
 * @date 2018/4/9
 * @time 19:44
 */
public class StringUtil {
    public static String to32BitStr(String origin){
        char[] newValue=new char[32];
        char[] oldValue=origin.toCharArray();
        for(int i=31,j=oldValue.length-1;i>=0;i++){
            if(j>=0){
                newValue[i]=oldValue[j];
                j--;
            }else{
                newValue[i]='0';
            }
        }
        return new String(newValue);
    }
}
