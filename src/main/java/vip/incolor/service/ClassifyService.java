package vip.incolor.service;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import vip.incolor.dto.RequestResult;
import vip.incolor.entity.ProductPicture;
import vip.incolor.entity.ProductStyle;

import java.util.HashMap;
import java.util.List;

/**
 * @author: JimLin
 * @description:
 * @email leafyunjim@gmail.com
 * @date: 2018-04-12
 * @time: 14:55
 */
public interface ClassifyService {

    /**
     * 首页得到所有类目
     *
     * @return
     */
    List<ProductStyle> getAllClassify();

    /**
     * 后台管理系统得到所有类目
     *
     * @return
     */
    List<ProductStyle> getAllManagerClassify();

    /**
     * 首页搜索
     *
     * @param searchContent 搜索内容
     */
    HashMap indexSearch(String searchContent);

    /**
     * 首页鼠标触碰某一级类目
     *
     * @param classId 产品类型 Id
     * @return
     */
    List<ProductStyle> getSecondaryClassify(Integer classId);


    /**
     * 首页点击某二级类目
     *
     * @param classId 产品类型 Id
     * @return
     */
    HashMap<String, Object> getProduct(Integer classId);

    /**
     * 添加一级类目
     *
     * @param classifyName
     * @param img
     */
    void addTopClassify(String classifyName, MultipartFile img);

    void onLine(Integer classifyId);

    void underLine(Integer classifyId);

    void addSecondClassify(String classifyName, Integer classifyId, MultipartFile img);

    List<ProductPicture> getNewProduct();

    void delete(Integer classId);

    List<ProductStyle> getManagerSecondaryClassify(Integer classId);
}
