package vip.incolor.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import vip.incolor.entity.UserGivenEmail;
import vip.incolor.entity.UserGivenEmailExample;

@Mapper
@Repository
public interface UserGivenEmailMapper {
    int deleteByPrimaryKey(Integer user_given_email_id);

    int insert(UserGivenEmail record);

    int insertSelective(UserGivenEmail record);

    List<UserGivenEmail> selectByExample(UserGivenEmailExample example);

    UserGivenEmail selectByPrimaryKey(Integer user_given_email_id);

    int updateByPrimaryKeySelective(UserGivenEmail record);

    int updateByPrimaryKey(UserGivenEmail record);

    UserGivenEmail selectByEmail(String email);

    List<UserGivenEmail> selectDistinctSignUpEmail();

}
