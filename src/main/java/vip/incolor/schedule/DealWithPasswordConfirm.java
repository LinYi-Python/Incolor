package vip.incolor.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import vip.incolor.mapper.ForgotPasswordConfirmMapper;

/**
 * @author: JimLin
 * @description: 处理密码验证时间任务类
 * @email leafyunjim@gmail.com
 * @date: 2018-07-12
 * @time: 10:59
 */
@Component
public class DealWithPasswordConfirm {

    @Autowired
    private ForgotPasswordConfirmMapper forgotPasswordConfirmMapper;

    @Scheduled(cron = "0 50 23 * * ?")
    private void deal() {
        forgotPasswordConfirmMapper.truncate();
    }
}
