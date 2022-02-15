package vip.incolor.service;

import java.util.HashMap;
import java.util.List;

import com.github.pagehelper.Page;
import org.springframework.web.multipart.MultipartFile;
import vip.incolor.dto.*;
import vip.incolor.entity.*;

import javax.validation.constraints.NotNull;


/**
 * @author LinPython
 * @email ly546654542@gmail.com
 * @description
 * @date 2018/5/6
 * @time 21:51
 */
public interface ProductManagerService {
    //-------------------------------------得到信息区----------------------------------------------------------

    /**
     * 返回商品分类信息
     *
     * @param productId 商品Id
     * @return 键值对
     */
    List<HashMap<String, Object>> getClassifyList(@NotNull Integer productId);

    /**
     * 返回商品表信息
     *
     * @param productId 商品Id
     * @return 键值对
     */
    List<HashMap<String, Object>> getProductList(@NotNull Integer productId);

    /**
     * 返回商品图片表信息
     *
     * @param productId 商品Id
     * @return 键值对
     */
    List<HashMap<String, Object>> getProductPictureList(@NotNull Integer productId);

    /**
     * 返回商品分类表信息
     *
     * @param productId 商品Id
     * @return 键值对
     */
    List<HashMap<String, Object>> getProductStyleList(@NotNull Integer productId);

    List<HashMap<String, Object>> listProduct(Integer pageNum, Integer pageSize);

    List<HashMap<String, Object>> ListProductItem(Integer pageNum, Integer pageSize);

    HashMap<String,Object> checkProductItem(Integer pageNum, Integer pageSize);

    //-------------------------------------得到信息区----------------------------------------------------------


    //-------------------------------------修改区--------------------------------------------------------------

    /**
     * 更新表格分类表信息
     *
     * @param
     */
    void updateClassifyByProductId(@NotNull Classify classify);

    /**
     * 更新产品表信息
     *
     * @param
     */
    void updateProductByProductId(@NotNull Product product);

    /**
     * 更新产品图片表信息
     *
     * @param
     */
    void updateProductPictureByProductId(@NotNull ProductPicture productPicture);

    /**
     * 更新产品类型表信息
     *
     * @param
     */
    void updateProductStyleByProductId(@NotNull ProductStyle productStyle);

    void updateProductByProductIds(@NotNull ProductItemss productItemss);

    //-------------------------------------修改区--------------------------------------------------------------

    //-------------------------------------删除区--------------------------------------------------------------

    /**
     * 删除商品
     *
     * @param productId 商品Id
     */
    void deleteProduct(@NotNull Integer productId);

    //-------------------------------------删除区--------------------------------------------------------------
//
//    /**
//     * 管理员点击页面获得商品详情
//     */
//    HashMap getProductDetail(Integer productId);
//
//    /**
//     *加入一个新的产品，获得一个新的管理页面，参数选择第一步
//     */
//    List<ManagerProduct> addProductManagerFirst(Product product);
//
//    /**
//     * 参数选择第二部,添加商品属性
//     */
//    void addProductManagerSecond(Product product, List<ManagerProduct> managerProducts);
//
//    /**
//     * 参数选择最后一步
//     */
//    void addProductManagerLast(Product product, List<ManagerProduct> managerProducts);
//
//    /**
//     * 放弃商品添加第一步
//     */
//    void giveUpProductManagerFirst(Integer productId);
//
//    /**
//     * 放弃商品添加第二步
//     */
//    void giveUpProductManagerSecond(Integer productId);
//    /**
//     * 得到商品尺码
//     */
//    String getProductSize(Integer productId);


    //-------------------------------------图片修改区----------------------------------------------------------

    /**
     * 添加图片
     *
     * @param multipartFile 图片文件
     * @param isThumbnail   是否为缩略图
     * @param productId     商品id
     */
    void uploadPic(MultipartFile multipartFile, @NotNull Integer productId, boolean isThumbnail);


    /**
     * 添加尺码图
     *
     * @param multipartFile 图片文件
     * @param productId     商品id
     */
    void uploadProductSizePic(MultipartFile multipartFile, @NotNull Integer productId);

    /**
     * 删除图片
     *
     * @param picId 图片id
     */
    void deletePic(@NotNull Integer picId, @NotNull String picPath);

    void deleteProductPicture(@NotNull Integer productId);
    //-------------------------------------添加区-------------------------------------------------------------

    void addClassify(@NotNull Classify classify);

    void addProduct(@NotNull Product product);

    void addProductPicture(@NotNull ProductPicture productPicture);

    void addProductStyle(@NotNull ProductStyle productStyle);

    void addProductItem(ProductItemss productItemss);

    List<HashMap<String, Object>> getMainProductInformation(@NotNull Integer productId);

    HashMap<String,Object> getMainNewProductInformation(@NotNull Integer productId);

    List<HashMap<String, Object>> getAllProductStyleName();

    List<HashMap<String, Object>> getAllProductTag();

    List<HashMap<String, Object>> getAllClassifyName();
}


