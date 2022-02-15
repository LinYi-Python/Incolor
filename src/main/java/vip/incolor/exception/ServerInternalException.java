package vip.incolor.exception;

/**
 * @author LiYizhan
 * @email 1062585732@qq.com
 * @description
 * @date 2018/3/20
 * @time 18:02
 */
public class ServerInternalException extends RuntimeException {
    public ServerInternalException() {
        super();
    }

    public ServerInternalException(String message) {
        super(message);
    }
}
