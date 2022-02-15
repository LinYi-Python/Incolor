package vip.incolor.exception;

/**
 * @author LiYizhan
 * @email 1062585732@qq.com
 * @description
 * @date 2018/4/9
 * @time 20:27
 */
public class QRCodeInvalidException extends RuntimeException {
    public QRCodeInvalidException() {
        super();
    }

    public QRCodeInvalidException(String message) {
        super(message);
    }
}
