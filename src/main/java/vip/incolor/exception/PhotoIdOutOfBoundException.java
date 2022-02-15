package vip.incolor.exception;

/**
 * @author LiYizhan
 * @email 1062585732@qq.com
 * @description
 * @date 2018/4/2
 * @time 22:52
 */
public class PhotoIdOutOfBoundException extends RuntimeException {
    public PhotoIdOutOfBoundException() {
        super();
    }

    public PhotoIdOutOfBoundException(String message) {
        super(message);
    }
}
