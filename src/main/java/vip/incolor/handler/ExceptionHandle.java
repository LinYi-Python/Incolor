package vip.incolor.handler;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import vip.incolor.exception.AccessException;
import vip.incolor.utils.GsonUtil;


/**
 * 全局登录异常处理类
 *
 * @author JimLin
 * @version V1.0.0
 * @date 2017/9/19
 * Email:lzhabc@163.com
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    // 声明捕获哪个异常类，这里捕获访问异常
    @ExceptionHandler(value = AccessException.class)
    @ResponseBody
    public String handle(AccessException e) {
        e.printStackTrace();
        return GsonUtil.getErrorJson("user did not login or session has been invalidated!");
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public String handle(Exception e) {
        e.printStackTrace();
        return GsonUtil.getErrorJson("网络异常");
    }
}
