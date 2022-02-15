package vip.incolor.exception;

/**
 * @author LiYizhan
 * @email 1062585732@qq.com
 * @description
 * @date 2018/5/9
 * @time 22:50
 */
public class DeleteRemoteFileException extends RuntimeException {
    public DeleteRemoteFileException() {
        super();
    }

    public DeleteRemoteFileException(String message) {
        super(message);
    }

    public DeleteRemoteFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeleteRemoteFileException(Throwable cause) {
        super(cause);
    }

    protected DeleteRemoteFileException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
