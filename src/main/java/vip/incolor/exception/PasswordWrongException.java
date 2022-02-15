package vip.incolor.exception;

/**
 * @author LiYizhan
 * @email 1062585732@qq.com
 * @description
 * @date 2018/4/24
 * @time 20:50
 */
public class PasswordWrongException extends RuntimeException {

    public PasswordWrongException() {
        super();
    }

    public PasswordWrongException(String message) {
        super(message);
    }
}
