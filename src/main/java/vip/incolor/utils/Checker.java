package vip.incolor.utils;

import java.util.regex.Pattern;

public class Checker {
    private static final String OPEN_ID_PATTERN = "^[0-9a-zA_Z]{1,28}$";
    private static final String CHINESE_NAME_PATTERN = "^[\\u4e00-\\u9fa5]{2,20}$";
    private static final String STUDENT_NUMBER_PATTERN = "^[0-9]{10}$";
    private static final String YYYY_MM_DD =
            "^(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)";
    private static final Pattern CHINA_MOBILE_PHONE = Pattern.compile("^((1[3,5,8][0-9])|(14[5,7])|(17[0,6,7,8])|(19[7]))\\d{8}$");
    private static final String EMAIL = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
    private static final String MORE_EMAIL = "/^(\\w)+(\\.\\w+)*@(\\w)+((\\.\\w{2,3}){1,3})$/";
    private static final Pattern HOME_PHONE=Pattern.compile("^(0[0-9]{2,3}/-)?([2-9][0-9]{6,7})+(/-[0-9]{1,4})?$");
    private static final Pattern POSTAL_CODE=Pattern.compile("^[0-9]{6}$");
    private static final Pattern EXPRESS_NUMBER=Pattern.compile("^[0-9A-Za-z]{15,18}$");
    /**
     * 账户密码必须为数字、字母、字符构成，12-30位
     */
    private static final String INCOLOR_ADMIN_ACCOUNT = "^[!-~]{12,30}$";
    private static final String INCOLOR_ADMIN_PASSWORD = "^[!-~]{12,30}$";



    public static boolean isOpenId(String input) {
        return Pattern.matches(OPEN_ID_PATTERN, input);
    }

    public static boolean isChineseName(String input) {
        return Pattern.matches(CHINESE_NAME_PATTERN, input);
    }

    public static boolean isStudentNumber(String input) {
        return Pattern.matches(STUDENT_NUMBER_PATTERN, input);
    }

    public static boolean isYYYY_MM_DD(String input) {
        return Pattern.matches(YYYY_MM_DD, input);
    }

    public static boolean isChinaMobilePhone(String input) {
        return CHINA_MOBILE_PHONE.matcher(input).matches();
    }

    public static boolean isEmail(String input) {
        return Pattern.matches(EMAIL, input);
    }

    public static boolean isIncolorAdminAccount(String input) {
        return Pattern.matches(INCOLOR_ADMIN_ACCOUNT, input);
    }

    public static boolean isIncolorAdminPassword(String input) {
        return Pattern.matches(INCOLOR_ADMIN_PASSWORD, input);
    }

    public static boolean isIncolorAdminLevel(byte level) {
        return (level >= 0 && level <= 2);
    }

    public static boolean isHomePhone(String input){
        return HOME_PHONE.matcher(input).matches();
    }

    /**
     * 请以后的开发者看到这里根据实际情况改一下可能的年级范围
     *
     * @param yearTime
     * @return
     */
    public static boolean isYearTime(int yearTime) {
        return (yearTime >= 14 && yearTime <= 20);
    }

    public static boolean isPostalCode(String input){
        return POSTAL_CODE.matcher(input).matches();
    }

    public static boolean isMoreEmail(String input){return Pattern.matches(MORE_EMAIL, input);}

    public static boolean isExpressNumber(String input){return EXPRESS_NUMBER.matcher(input).matches();}
}
