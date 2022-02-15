package vip.incolor.exception;


/**
 * 访问异常
 * Created by JimLin on 2017/8/4
 * Email:lzhabc@163.com
 */
public class NoSuchUserException extends RuntimeException {
    public NoSuchUserException() {
        super();
    }

    public NoSuchUserException(String message) {
        super(message);
    }

}