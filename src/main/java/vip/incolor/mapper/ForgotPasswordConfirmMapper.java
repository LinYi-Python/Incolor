package vip.incolor.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import vip.incolor.entity.ForgotPasswordConfirm;

/**
 * @author: JimLin
 * @description:
 * @email leafyunjim@gmail.com
 * @date: 2018-05-17
 * @time: 22:57
 */
@Mapper
@Repository
public interface ForgotPasswordConfirmMapper {
    int insert(ForgotPasswordConfirm record);

    ForgotPasswordConfirm selectByEmail(String email);

    int updateVerifyCodeByEmail(@Param("email") String email, @Param("verifyCode") String verifyCode);

    int updateTimes(@Param("email") String email, @Param("times") int times);

    int updateStatus(String email);

    void truncate();

}
