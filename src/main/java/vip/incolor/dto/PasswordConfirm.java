package vip.incolor.dto;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;

/**
 * @author: JimLin
 * @description:
 * @email leafyunjim@gmail.com
 * @date: 2018-05-18
 * @time: 0:05
 */
public class PasswordConfirm {
    /**
     * 用户密码
     */
    @NotBlank(message = "{NotBlank.password}")
    @Pattern(regexp = "^\\w{8,16}$", message = "{Pattern.password}")
    private String newPassword;
    /**
     * 用户确认密码
     */
    @NotBlank(message = "{NotBlank.confirmPassword}")
    private String confirmPassword;
    /**
     * 用户邮箱
     */
    @NotBlank(message = "{NotBlank.email}")
    @Pattern(regexp = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$", message = "{Pattern.email}")
    private String email;

    public PasswordConfirm() {
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "PasswordConfirm{" +
                "newPassword='" + newPassword + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
