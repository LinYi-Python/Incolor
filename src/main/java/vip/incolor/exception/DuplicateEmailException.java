package vip.incolor.exception;

/**
 * @author LiYizhan
 * @email 1062585732@qq.com
 * @description 数据库存在重复邮箱
 * @date 2018/3/20
 * @time 17:52
 */
public class DuplicateEmailException extends RuntimeException {
    public DuplicateEmailException() {
        super();
    }

    public DuplicateEmailException(String message) {
        super(message);
    }
}
