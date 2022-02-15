package vip.incolor.exception;

/**
 * @author LiYizhan
 * @email 1062585732@qq.com
 * @description
 * @date 2018/4/22
 * @time 10:59
 */
public class NotPayException extends RuntimeException {
    public NotPayException() {
        super();
    }

    public NotPayException(String message) {
        super(message);
    }
}
