package vip.incolor.entity;

import java.util.Date;

/**
 * @author: JimLin
 * @description:
 * @email leafyunjim@gmail.com
 * @date: 2018-05-17
 * @time: 22:56
 */
public class ForgotPasswordConfirm {

    private Integer forgotPasswordConfirmId;

    private String email;

    private String verifyCode;

    private boolean status;

    private Integer times;

    private Date createTime;

    private Date updateTime;

    public ForgotPasswordConfirm() {
    }

    public Integer getForgotPasswordConfirmId() {
        return forgotPasswordConfirmId;
    }

    public void setForgotPasswordConfirmId(Integer forgotPasswordConfirmId) {
        this.forgotPasswordConfirmId = forgotPasswordConfirmId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "ForgotPasswordConfirm{" +
                "forgotPasswordConfirmId=" + forgotPasswordConfirmId +
                ", email='" + email + '\'' +
                ", verifyCode='" + verifyCode + '\'' +
                ", status='" + status + '\'' +
                ", times=" + times +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
