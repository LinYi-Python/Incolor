package vip.incolor.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import vip.incolor.dto.*;
import vip.incolor.dto.Property;
import vip.incolor.entity.*;
import vip.incolor.vo.ProductVO;

@Mapper
@Repository
public interface ProductMapper {
    int deleteByPrimaryKey(Integer product_id);

    int insert(Product record);

    int insertSelective(Product record);

    List<Product> selectByExample(ProductExample example);

    List<Product> selectByExamples(ProductExample example);

    Product selectByPrimaryKey(Integer product_id);

//    Product selectByPrimaryKeys(Integer product_id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    /**
     * 根据关键字搜索产品
     *
     * @param searchContent 搜索内容
     * @return
     */
    List<ProductVO> selectProductByName(String searchContent);

    List<ProductAndOrderDetail> getProductByOrderId(int orderId);

    /**
     * 根据关键字搜索产品
     *
     * @param classId 产品类型 Id
     * @return
     */
    List<ProductPicture> selectByClassId(Integer classId);


    /**
     * 根据关键字搜索产品
     *
     * @param productId 产品类型 Id
     * @return
     */
    ProductVO selectByProductId(Integer productId);

    /**
     * 查询所有配件
     *
     * @param productId 产品类型 Id
     * @return
     */
    List<ProductVO> selectPartsByProductId(Integer productId);


    /**
     * 查询车架配件
     *
     * @param productId 产品类型 Id
     * @return
     */
    ProductVO selectFramePartByProductId(Integer productId);


    /**
     * 查询车架配件
     *
     * @param productId 产品类型 Id
     * @return
     */
    List<ProductVO> selectOtherPartByProductId(Integer productId);


    List<ProductAndShopping> getMyShoppingCartProducts(Integer userId);

    List<ProductAndOrderDetail> getOrderProduct(Integer orderId);

    List<Property> getMainProductProperty(int shoppingId);

    List<Property> getSubProductProperty(int shoppingId);

    String selectProductSizeById(Integer productId);

    List<ProductPicture> selectNewProduct();

    List<Classify> getClassifyByProductId(Integer productId);

    List<Product> getProductByProductId(Integer productId);

    List<ProductPicture> getProductPictureByProductId(Integer productId);

    List<ProductStyle> getProductStyleByProductId(Integer productId);

    void updateClassifyByProductId(Integer productId);

    void updateProductByProductId(Integer productId);

    void updateProductPictureByProductId(Integer productId);

    void updateProductStyleByProductId(Integer productId);

    void deleteClassifyByProductId(Integer productId);

    void deleteProductPictureByProductId(Integer productId);

    void deleteProductStyleByProductId(Integer productId);

    List<Product> selectProductInformation();

    List<Product> getMainProductInformation(Integer productId);

    List<Product> selectProductByProductTag(String productTag);

    List<ProductStyle> getProductStyleName();

    List<Classify> getClassifyName();

    List<Product> getProductTag();

    void insertProduct(ProductItemss productItemss);

    void updateProduct(ProductItemss productItemss);

    int updateProductSizePic(@Param("productId") Integer productId, @Param("path") String path);

    List<Product> selectProductDesc();


}
