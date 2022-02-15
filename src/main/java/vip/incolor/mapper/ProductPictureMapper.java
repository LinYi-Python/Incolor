package vip.incolor.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import vip.incolor.entity.ProductPicture;
import vip.incolor.entity.ProductPictureExample;

@Mapper
@Repository
public interface ProductPictureMapper {
    int deleteByPrimaryKey(Integer product_picture_id);

    int insert(ProductPicture record);

    int insertSelective(ProductPicture record);

    List<ProductPicture> selectByExample(ProductPictureExample example);

    ProductPicture selectByPrimaryKey(Integer product_picture_id);

    int updateByPrimaryKeySelective(ProductPicture record);

    int updateByPrimaryKey(ProductPicture record);

    ProductPicture selectPictureByProductId(Integer productId);

    ProductPicture selectProductPictureIdByProductId(Integer productId);

    int updatePictureByProductId(@Param("productId") Integer productId, @Param("path") String path);

    void deletePictureByProductId(Integer productId);



}
