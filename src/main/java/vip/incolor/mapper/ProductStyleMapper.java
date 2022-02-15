package vip.incolor.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import vip.incolor.dto.ProductItems;
import vip.incolor.dto.ProductItemss;
import vip.incolor.entity.Classify;
import vip.incolor.entity.ProductStyle;
import vip.incolor.entity.ProductStyleExample;

@Mapper
@Repository
public interface ProductStyleMapper {
    int deleteByPrimaryKey(Integer product_style_id);

    int insert(ProductStyle record);

    int insertSelective(ProductStyle record);

    List<ProductStyle> selectByExample(ProductStyleExample example);

    ProductStyle selectByPrimaryKey(Integer product_style_id);

    int updateByPrimaryKeySelective(ProductStyle record);

    int updateByPrimaryKey(ProductStyle record);


    /**
     * 查询所有上线的一级类目
     *
     * @return
     */
    List<ProductStyle> selectAllTopClassifyOnLine();


    /**
     * 查询所有的类目
     *
     * @return
     */
    List<ProductStyle> selectAllTopClassify();

    /**
     * 查询所有的类目
     *
     * @return
     */
    List<ProductStyle> selectSecondaryClassifyById(Integer classId);

    String selectProductStyle(Integer productId);

    int updateClassifyOnline(@Param("classId") Integer classId, @Param("version") Integer version);

    int updateClassifyUnderLine(@Param("classId") Integer classId, @Param("version") Integer version);

    /**
     * 查询所有的类目
     *
     * @return
     */
    List<ProductStyle> selectManagerSecondaryClassifyById(Integer classId);

    void insertProductStyle(ProductItemss productItemss);

}
