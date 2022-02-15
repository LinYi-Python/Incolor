package vip.incolor.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import vip.incolor.entity.Article;
import vip.incolor.entity.ProductPicture;
import vip.incolor.entity.ProductStyle;
import vip.incolor.exception.ServerInternalException;
import vip.incolor.exception.UploadFileException;
import vip.incolor.mapper.ArticleMapper;
import vip.incolor.mapper.ClassifyMapper;
import vip.incolor.mapper.ProductMapper;
import vip.incolor.mapper.ProductStyleMapper;
import vip.incolor.service.ClassifyService;
import vip.incolor.utils.QiniuUtil;
import vip.incolor.vo.ProductVO;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author: JimLin
 * @description:
 * @email leafyunjim@gmail.com
 * @date: 2018-04-12
 * @time: 14:56
 */
@Service
public class ClassifyServiceImpl implements ClassifyService {

    private ClassifyMapper classifyMapper;

    private ProductMapper productMapper;

    private ArticleMapper articleMapper;

    private ProductStyleMapper productStyleMapper;

    @Autowired
    public ClassifyServiceImpl(ClassifyMapper classifyMapper, ProductMapper productMapper, ArticleMapper articleMapper, ProductStyleMapper productStyleMapper) {
        super();
        this.classifyMapper = classifyMapper;
        this.productMapper = productMapper;
        this.articleMapper = articleMapper;
        this.productStyleMapper = productStyleMapper;
    }

    /**
     * 首页得到所有类目
     *
     * @return
     */
    @Override
    public List<ProductStyle> getAllClassify() {
        PageHelper.startPage(0, 8);
        return productStyleMapper.selectAllTopClassifyOnLine();
    }

    @Override
    public List<ProductStyle> getAllManagerClassify() {
        return productStyleMapper.selectAllTopClassify();
    }

    /**
     * 首页搜索
     *
     * @param searchContent 搜索内容
     * @return
     */
    @Override
    public HashMap indexSearch(String searchContent) {
        // 根据关键字搜索出对应产品
        List<ProductVO> products = productMapper.selectProductByName(searchContent);
        // 搜索出创意图文的标题
        List<Article> articles = articleMapper.selectArticleByName(searchContent);
        HashMap<String, Object> map = new HashMap<>();
        map.put("products", products);
        map.put("articles", articles);
        return map;
    }

    /**
     * 首页鼠标触碰某一级类目
     *
     * @param classId 产品类型 Id
     * @return
     */
    @Override
    public List<ProductStyle> getSecondaryClassify(Integer classId) {
        return productStyleMapper.selectSecondaryClassifyById(classId);
    }

    /**
     * 首页点击某二级类目
     *
     * @param classId 产品类型 Id
     * @return
     */
    @Override
    public HashMap<String, Object> getProduct(Integer classId) {
        List<ProductPicture> list = productMapper.selectByClassId(classId);
        for (ProductPicture picture : list) {
            System.out.println("11: " + picture.getProduct_picture_path());
            // 给出第一张图片
            picture.setProduct_picture_path(picture.getProduct_picture_path().substring(0, picture.getProduct_picture_path().indexOf("+")));
        }
        HashMap<String, Object> map = new HashMap<String, Object>();
        ProductStyle style = productStyleMapper.selectByPrimaryKey(classId);
        map.put("style", style);
        map.put("list", list);
        return map;
    }

    /**
     * 添加一级类目
     *
     * @param classifyName
     * @param img
     */
    @Override
    public void addTopClassify(String classifyName, MultipartFile img) {
        try {
            String result = QiniuUtil.uploadFile(img);
            ProductStyle style = new ProductStyle();
            style.setIs_parent(true);
            style.setVersion(0);
            style.setParent_id(-1);
            style.setProduct_style_name(classifyName);
            style.setProduct_style_picture(result);
            style.setProduct_style_create_time(new Date());
            style.setProduct_style_update_time(new Date());
            int i = productStyleMapper.insert(style);
            if (i < 0) {
                throw new ServerInternalException();
            }
        } catch (UploadFileException | ServerInternalException e) {
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServerInternalException();
        }
    }

    @Override
    public void onLine(Integer classifyId) {
        ProductStyle style = productStyleMapper.selectByPrimaryKey(classifyId);
        int i = productStyleMapper.updateClassifyOnline(classifyId, style.getVersion());
        if (i < 0) {
            throw new ServerInternalException();
        }
    }

    @Override
    public void underLine(Integer classifyId) {
        ProductStyle style = productStyleMapper.selectByPrimaryKey(classifyId);
        int i = productStyleMapper.updateClassifyUnderLine(classifyId, style.getVersion());
        if (i < 0) {
            throw new ServerInternalException();
        }
    }

    @Override
    public void addSecondClassify(String classifyName, Integer classifyId, MultipartFile img) {
        try {
            String result = QiniuUtil.uploadFile(img);
            ProductStyle style = new ProductStyle();
            style.setIs_parent(false);
            style.setParent_id(classifyId);
            style.setProduct_style_name(classifyName);
            style.setVersion(0);
            style.setProduct_style_picture(result);
            style.setProduct_style_create_time(new Date());
            style.setProduct_style_update_time(new Date());
            int i = productStyleMapper.insert(style);
            if (i < 0) {
                throw new ServerInternalException();
            }
        } catch (UploadFileException | ServerInternalException e) {
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServerInternalException();
        }
    }

    @Override
    public List<ProductPicture> getNewProduct() {
        List<ProductPicture> list = productMapper.selectNewProduct();
        for (ProductPicture picture : list) {
            System.out.println("11: " + picture.getProduct_picture_path());
            // 得到地址
            String path = picture.getProduct_picture_path();
            if (!path.equals("") && path.contains("+")) {
                // 给出第一张图片
                picture.setProduct_picture_path(path.substring(0, path.indexOf("+")));
            }
        }
        return list;
    }

    @Override
    public void delete(Integer classId) {
        int i = productStyleMapper.deleteByPrimaryKey(classId);
        if (i < 0) {
            throw new ServerInternalException();
        }
    }

    @Override
    public List<ProductStyle> getManagerSecondaryClassify(Integer classId) {
        return productStyleMapper.selectManagerSecondaryClassifyById(classId);
    }


}
