package vip.incolor.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import vip.incolor.entity.Classify;
import vip.incolor.entity.ClassifyExample;
@Mapper
@Repository
public interface ClassifyMapper {
    int deleteByPrimaryKey(Integer class_id);

    int insert(Classify record);

    int insertSelective(Classify record);

    List<Classify> selectByExample(ClassifyExample example);

    Classify selectByPrimaryKey(Integer class_id);

    int updateByPrimaryKeySelective(Classify record);

    int updateByPrimaryKey(Classify record);


    /**
     * 查询所有的类目
     *
     * @return
     */
    List<Classify> selectAllTopClassify();

    /**
     * 查询所有的类目
     *
     * @return
     */
    List<Classify> selectSecondaryClassifyById(Integer classId);

    /**
     * 真正查询所有类目的方法
     * @return
     */
    List<Classify> list();
}
