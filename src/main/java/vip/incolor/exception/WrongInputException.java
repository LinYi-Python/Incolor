package vip.incolor.exception;

/**
 * @author LiYizhan
 * @email 1062585732@qq.com
 * @description 表单提交时字段验证错误抛出此异常
 * @date 2018/3/20
 * @time 17:34
 */
public class WrongInputException extends RuntimeException {
    public WrongInputException() {
        super();
    }

    public WrongInputException(String message) {
        super(message);
    }
}
