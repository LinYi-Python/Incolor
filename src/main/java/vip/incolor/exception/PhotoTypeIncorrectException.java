package vip.incolor.exception;

/**
 * @author LiYizhan
 * @email 1062585732@qq.com
 * @description
 * @date 2018/4/2
 * @time 22:09
 */
public class PhotoTypeIncorrectException extends RuntimeException {
    public PhotoTypeIncorrectException() {
        super();
    }

    public PhotoTypeIncorrectException(String message) {
        super(message);
    }
}
