package vip.incolor.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import vip.incolor.dto.*;
import vip.incolor.entity.Product;
import vip.incolor.entity.ProductPicture;
import vip.incolor.exception.ServerInternalException;
import vip.incolor.exception.WrongInputException;
import vip.incolor.mapper.ClassifyMapper;
import vip.incolor.mapper.ProductMapper;
import vip.incolor.mapper.ProductPictureMapper;
import vip.incolor.mapper.ProductStyleMapper;
import vip.incolor.mapper.PropertyMapper;
import vip.incolor.mapper.PropertyValueMapper;
import vip.incolor.service.ProductManagerService;
import vip.incolor.utils.QiniuUtil;
import vip.incolor.entity.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.lang.reflect.Field;
import java.util.*;

/**
 * @author LinPython
 * @email ly546654542@gmail.com
 * @description 商品管理
 * @date 2018/5/6
 * @time 21:49
 */


//
//                            _ooOoo_
//                           o8888888o
//                           88" . "88
//                           (| -_- |)
//                           O\  =  /O
//                        ____/`---'\____
//                      .'  \\|     |//  `.
//                     /  \\|||  :  |||//  \
//                    /  _||||| -:- |||||-  \
//                    |   | \\\  -  /// |   |
//                    | \_|  ''\---/''  |   |
//                    \  .-\__  `-`  ___/-. /
//                  ___`. .'  /--.--\  `. . __
//               ."" '<  `.___\_<|>_/___.'  >'"".
//              | | :  `- \`.;`\ _ /`;.`/ - ` : | |
//              \  \ `-.   \_ __\ /__ _/   .-` /  /
//         ======`-.____`-.___\_____/___.-`____.-'======
//                            `=---='
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
//                      Buddha Bless, No Bug !
@Service
public class ProdcutManagerServicelImpl implements ProductManagerService {

    private ClassifyMapper classifyMapper;
    private ProductStyleMapper productStyleMapper;
    private ProductPictureMapper productPictureMapper;
    private ProductMapper productMapper;

    @Autowired
    public ProdcutManagerServicelImpl(ClassifyMapper classifyMapper, ProductStyleMapper productStyleMapper, ProductPictureMapper productPictureMapper,
                                      ProductMapper productMapper) {
        this.classifyMapper = classifyMapper;
        this.productStyleMapper = productStyleMapper;
        this.productPictureMapper = productPictureMapper;
        this.productMapper = productMapper;
    }

    @Override
    public List<HashMap<String, Object>> getClassifyList(Integer productId) {
        List<HashMap<String, Object>> resp = new ArrayList<>();
        ProductExample productExample = new ProductExample();
        productExample.createCriteria().andProduct_idEqualTo(productId);
        List<Classify> classifies = productMapper.getClassifyByProductId(productId);
        for (Classify classify : classifies) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("class_name", classify.getClass_name());
            map.put("is_parent", classify.getIs_parent());
            map.put("parent_Id", classify.getParent_id());
            resp.add(map);
        }
        return resp;

    }

    @Override
    public List<HashMap<String, Object>> getProductList(Integer productId) {
        List<HashMap<String, Object>> resp = new ArrayList<>();
        ProductExample productExample = new ProductExample();
        productExample.createCriteria().andProduct_idEqualTo(productId);
        List<Product> products = productMapper.getProductByProductId(productId);
        for (Product product : products) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("product_size", product.getProduct_size());
            map.put("Product_name", product.getProduct_name());
            map.put("product_price", product.getProduct_price());
            map.put("product_estimate_price", product.getProduct_estimate_price());
            map.put("product_estimate_deliver_time", product.getProduct_estimate_deliver_time());
            map.put("product_marketable", product.getProduct_marketable());
            map.put("product_number", product.getProduct_number());
            map.put("product_tag", product.getProduct_tag());
            resp.add(map);
        }
        return resp;
    }

    @Override
    public List<HashMap<String, Object>> getProductPictureList(Integer productId) {
        List<HashMap<String, Object>> resp = new ArrayList<>();
        ProductExample productExample = new ProductExample();
        productExample.createCriteria().andProduct_idEqualTo(productId);
        List<ProductPicture> productPictures = productMapper.getProductPictureByProductId(productId);
        for (ProductPicture productPicture : productPictures) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("product_picture_type", productPicture.getProduct_picture_type());
            map.put("product_picture_path", productPicture.getProduct_picture_path());
            resp.add(map);
        }
        return resp;
    }

    public List<HashMap<String, Object>> getProductStyleList(Integer productId) {
        List<HashMap<String, Object>> resp = new ArrayList<>();
        ProductExample productExample = new ProductExample();
        productExample.createCriteria().andProduct_idEqualTo(productId);
        List<ProductStyle> productStyles = productMapper.getProductStyleByProductId(productId);
        for (ProductStyle productStyle : productStyles) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("product_style_name", productStyle.getProduct_style_name());
            map.put("is_on_line ", productStyle.getIs_on_line());
            map.put("product_style_picture", productStyle.getProduct_style_picture());
            resp.add(map);
        }
        return resp;
    }

    //
    public void updateClassifyByProductId(Classify classify) {
//         ManagerClassify managerClassify1 = new ManagerClassify();
        classifyMapper.updateByPrimaryKeySelective(classify);
//         productMapper.updateClassifyByProductId(productId,Classify);
//    List<Class ify> classify = productMapper.getClassifyByProductId(productId);
        if (classify == null) {
            throw new WrongInputException();
        }
//        managerClassify.setClassifyId(classify.getClass_id());
//        managerClassify.setClassifyName(classify.getClass_name());
//        managerClassify.setParent(classify.getIs_parent());
//        managerClassify.setParentId(classify.getParent_id());


    }

    public void updateProductByProductId(Product product) {
//    ManagerProduct managerProduct = new ManagerProduct();
        productMapper.updateByPrimaryKeySelective(product);
//    Product product = new Product();
//    productMapper.updateProductByProductId(productId);
        if (product == null) {
            throw new WrongInputException();
        }
//    managerProduct.setProductId(product.getProduct_id());
//    managerProduct.setProductAttachId(product.getProduct_attach_id());
//    managerProduct.setProductDeliverTime(product.getProduct_estimate_deliver_time());
//    managerProduct.setProductIsNew(product.getProduct_is_new());
//    managerProduct.setProductEstimatePrice(product.getProduct_estimate_price());
//    managerProduct.setProductMarketable(product.getProduct_marketable());
//    managerProduct.setProductName(product.getProduct_name());
//    managerProduct.setProductPrice(product.getProduct_price());
//    managerProduct.setProductSize(product.getProduct_size());
    }

    public void updateProductPictureByProductId(ProductPicture productPicture) {
//    ManagerProductPicture managerProductPicture = new ManagerProductPicture();
//    ProductPicture productPicture = new ProductPicture();
//    productMapper.updateProductPictureByProductId(productId);
//    managerProductPicture.setPicturePath(productPicture.getProduct_picture_path());
//    managerProductPicture.setProductPictureId(productPicture.getProduct_picture_id());
//    managerProductPicture.setType(productPicture.getProduct_picture_type());
        productPictureMapper.updateByPrimaryKeySelective(productPicture);
        if (productPicture == null) {
            throw new WrongInputException();
        }
    }

    public void updateProductStyleByProductId(ProductStyle productStyle) {
//        ManagerProductStyle managerProductStyle = new ManagerProductStyle();
//        ProductStyle productStyle = new ProductStyle();
//        productMapper.updateProductStyleByProductId(productId);
//        managerProductStyle.setProductStyleId(productStyle.getProduct_style_id());
//        managerProductStyle.setProductStyleName(productStyle.getProduct_style_name());
//        managerProductStyle.setProduct_style_picture(productStyle.getProduct_style_picture());
//        managerProductStyle.setIs_on_line(productStyle.getIs_on_line());
        productStyleMapper.updateByPrimaryKeySelective(productStyle);
        if (productStyle == null) {
            throw new WrongInputException();
        }
    }

    public void updateProductByProductIds(ProductItemss productItemss) {
        try {
            productMapper.updateProduct(productItemss);
            if (productItemss == null) {
                throw new WrongInputException();
            }
        } catch (Exception e) {
            throw new ServerInternalException(e.getMessage());
        }
    }

    public void deleteProduct(Integer productId) {
        try {
            productMapper.deleteClassifyByProductId(productId);
            productMapper.deleteProductPictureByProductId(productId);
            productMapper.deleteProductStyleByProductId(productId);
            productMapper.deleteByPrimaryKey(productId);
        } catch (Exception e) {
            throw new ServerInternalException(e.getMessage());
        }
    }

    @Transactional
    @Override
    public void addClassify(Classify classify) {
        try {
            classifyMapper.insert(classify);
        } catch (Exception e) {
            throw new ServerInternalException(e.getMessage());
        }
    }

    @Transactional
    @Override
    public void addProduct(Product product) {
        try {
            productMapper.insert(product);
        } catch (Exception e) {
            throw new ServerInternalException(e.getMessage());
        }
    }

    @Transactional
    @Override
    public void addProductPicture(ProductPicture productPicture) {
        try {
            productPictureMapper.insert(productPicture);
        } catch (Exception e) {
            throw new ServerInternalException(e.getMessage());
        }
    }

    @Transactional
    @Override
    public void addProductStyle(ProductStyle productStyle) {
        try {
            productStyleMapper.insert(productStyle);
        } catch (Exception e) {
            throw new ServerInternalException(e.getMessage());
        }
    }

    @Transactional
    @Override
    public void addProductItem(ProductItemss productItemss) {
        try {
            productMapper.insertProduct(productItemss);
//            productStyleMapper.insertProductStyle(productItemss);
        } catch (Exception e) {
            throw new ServerInternalException(e.getMessage());
        }
    }

    @Transactional
    @Override
    public void uploadPic(MultipartFile multipartFile, Integer productId, boolean isThumbnail) {
        try {
            Product product = productMapper.selectByPrimaryKey(productId);
            if (product == null) {
                throw new Exception("产品不存在");
            }
            if (multipartFile.isEmpty()) {
                throw new Exception("上传的文件有误");
            }
            String path = QiniuUtil.uploadFile(multipartFile);
            ProductPicture picture = productPictureMapper.selectPictureByProductId(productId);
            // 如果之前没插入图片
            if (picture == null) {
                ProductPicture productPicture = new ProductPicture();
                productPicture.setProduct_id(productId);
                productPicture.setProduct_picture_type(!isThumbnail);   //数据库中0代表缩略图
                productPicture.setProduct_picture_path(path + "+");
                productPicture.setProduct_picture_create_time(new Date());
                productPicture.setProduct_picture_update_time(new Date());
                productPictureMapper.insert(productPicture);

            } else {
                if (picture.getProduct_picture_path().equals("")) {
                    productPictureMapper.updatePictureByProductId(productId, path + "+");
                } else {
                    productPictureMapper.updatePictureByProductId(productId, picture.getProduct_picture_path() + path + "+");
                }

            }


        } catch (Exception e) {
            throw new ServerInternalException(e.getMessage());
        }
        Product product1 = productMapper.selectByPrimaryKey(productId);
        ProductPicture productPicture1 = productPictureMapper.selectProductPictureIdByProductId(productId);
        product1.setProduct_picture_id(productPicture1.getProduct_picture_id());
        productMapper.updateByPrimaryKeySelective(product1);
    }

    public void uploadProductSizePic(MultipartFile multipartFile, @NotNull Integer productId) {
        try {
            Product product = productMapper.selectByPrimaryKey(productId);
            if (product == null) {
                throw new Exception("产品不存在");
            }
            if (multipartFile.isEmpty()) {
                throw new Exception("上传的文件有误");
            }
            String path = QiniuUtil.uploadFile(multipartFile);
            productMapper.updateProductSizePic(productId, path);
        } catch (Exception e) {
            throw new ServerInternalException(e.getMessage());
        }
    }

    @Transactional
    @Override
    public void deleteProductPicture(Integer productId){
        try {
            productPictureMapper.deletePictureByProductId(productId);
        }catch (Exception e){
            throw new ServerInternalException(e.getMessage());
        }
        Product product = productMapper.selectByPrimaryKey(productId);
        product.setProduct_picture_id(null);
        productMapper.updateByPrimaryKeySelective(product);
    }
    @Transactional
    @Override
    public void deletePic(Integer picId, String picPath) {
        try {
            ProductPicture productPicture = productPictureMapper.selectByPrimaryKey(picId);
            if (productPicture == null) {
                return;
            }
            String key = picPath.replace(QiniuUtil.DOMAIN, "");
            QiniuUtil.deleteFile(key);
            // 得到哦图片的地址 list
            List<String> list = Arrays.asList(productPicture.getProduct_picture_path().split("\\+"));
            String productPicturePath = "";
            // 遍历
            for (String path : list) {
                // 如果是这张图片地址就过滤掉，进行下个循环
                if (path.contains(key)) {
                    continue;
                }
                // 重新组装新的路径
                String img = path + "+";
                productPicturePath = productPicturePath + img;
            }
            productPicture.setProduct_picture_path(productPicturePath);
            productPictureMapper.updateByPrimaryKey(productPicture);
        } catch (Exception e) {
            throw new ServerInternalException(e.getMessage());
        }
    }

    @Transactional
    @Override
    public List<HashMap<String, Object>> listProduct(Integer pageNum, Integer pageSize) {
        Page<HashMap<String, Object>> list = PageHelper.startPage(pageNum, pageSize);
        List<HashMap<String, Object>> result = new ArrayList<>();
        ProductExample productExample = new ProductExample();
        List<Product> products = productMapper.selectByExample(productExample);
        for (Product product : products) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("product", product);
            Classify classify = classifyMapper.selectByPrimaryKey(product.getProduct_classify_id());
            map.put("classify", classify);
            ProductStyle productStyle = productStyleMapper.selectByPrimaryKey(product.getProduct_class_id());
            map.put("product_style", productStyle);
            ProductPicture productPicture = productPictureMapper.selectByPrimaryKey(product.getProduct_picture_id());
            map.put("product_picture", productPicture);
            result.add(map);
        }
        return result;
    }


    @Transactional
    @Override
    public List<HashMap<String, Object>> getMainProductInformation(Integer productId) {
        ProductExample productExample = new ProductExample();
        List<HashMap<String, Object>> result = new ArrayList<>();
        productExample.createCriteria().andProduct_attach_idEqualTo(productId);
        List<Product> products = productMapper.selectByExample(productExample);
        for (Product product : products) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("product", product);
            Classify classify = classifyMapper.selectByPrimaryKey(product.getProduct_classify_id());
            map.put("classify", classify);
            ProductStyle productStyle = productStyleMapper.selectByPrimaryKey(product.getProduct_class_id());
            map.put("product_style", productStyle);
            ProductPicture productPicture = productPictureMapper.selectByPrimaryKey(product.getProduct_picture_id());
            map.put("product_picture", productPicture);
            result.add(map);
        }
        return result;
    }

    @Transactional
    @Override
    public HashMap<String, Object> getMainNewProductInformation(@NotNull Integer productId) {
        ProductExample productExample = new ProductExample();
        productExample.createCriteria().andProduct_attach_idEqualTo(productId);
        List<Product> products = productMapper.selectByExamples(productExample);
        ProductItems productItems = null;
        List<ProductItems> productItems1 = new ArrayList<>();
        for (Product product : products) {
            Classify classify = classifyMapper.selectByPrimaryKey(product.getProduct_classify_id());
            ProductStyle productStyle = productStyleMapper.selectByPrimaryKey(product.getProduct_class_id());
            ProductPicture productPicture = productPictureMapper.selectByPrimaryKey(product.getProduct_picture_id());
            productItems = new ProductItems();
            if (classify != null) {
                productItems.setClass_id(classify.getClass_id());
                productItems.setClass_name(classify.getClass_name());
            }

            if (product != null) {
                productItems.setProduct_id(product.getProduct_id());
                productItems.setProduct_name(product.getProduct_name());
                productItems.setProduct_size(product.getProduct_size());
                productItems.setProduct_is_new(product.getProduct_is_new());
                productItems.setProduct_number(product.getProduct_number());
                productItems.setProduct_tag(product.getProduct_tag());
                productItems.setProduct_marketable(product.getProduct_marketable());
                productItems.setProduct_attach_id(product.getProduct_attach_id());

            }

            if (productPicture != null) {
                productItems.setProduct_picture_id(productPicture.getProduct_picture_id());
                productItems.setProduct_picture_path(productPicture.getProduct_picture_path());
            }

            if (productStyle != null) {
                productItems.setProduct_style_id(productStyle.getProduct_style_id());
                productItems.setProduct_style_name(productStyle.getProduct_style_name());
            }
            productItems1.add(productItems);

        }
        Collections.reverse(productItems1);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("productItemsl", productItems1);
        return map;
    }
//    public HashMap<String,Object> checkProductItem(Integer pageNum, Integer pageSize) {
//        Page<Product> list = PageHelper.startPage(pageNum, pageSize);
//        ProductExample productExample = new ProductExample();
//        List<Product> products = productMapper.selectByExample(productExample);
//        ProductItems productItems = null;
//        List<ProductItems> productItems1 = new ArrayList<>();
//        for (Product product : products) {
//            Classify classify = classifyMapper.selectByPrimaryKey(product.getProduct_classify_id());
//            ProductStyle productStyle = productStyleMapper.selectByPrimaryKey(product.getProduct_class_id());
//
//
//            productItems = new ProductItems();
//            if ( classify != null){
//                productItems.setClass_id(classify.getClass_id());
//                productItems.setClass_name(classify.getClass_name());
//            }
//
//            if ( product != null){
//                productItems.setProduct_id(product.getProduct_id());
//                productItems.setProduct_name(product.getProduct_name());
//                productItems.setProduct_size(product.getProduct_size());
//                productItems.setProduct_is_new(product.getProduct_is_new());
//                productItems.setProduct_number(product.getProduct_number());
//                productItems.setProduct_tag(product.getProduct_tag());
//                productItems.setProduct_marketable(product.getProduct_marketable());
//            }
//
//            if ( productStyle != null){
//                productItems.setProduct_style_id(productStyle.getProduct_style_id());
//                productItems.setProduct_style_name(productStyle.getProduct_style_name());
//            }
//            productItems1.add(productItems);
//
//        }
//        Collections.reverse(productItems1);
//        HashMap<String,Object> map=new HashMap<String,Object>();
//        map.put("productItems1",productItems1);
//        map.put("pages",list.getPages());
//        map.put("total",list.getTotal());
//        return map;
//    }

    @Transactional
    @Override
    public List<HashMap<String, Object>> ListProductItem(Integer pageNum, Integer pageSize) {
//        Page<HashMap<String, Object>> list = PageHelper.startPage(pageNum, pageSize);
//        ProductItem productItem = new ProductItem();
//        List<HashMap<String, Object>> result = new ArrayList<>();
//        ProductExample productExample = new ProductExample();
//        List<Product> products = productMapper.selectByExample(productExample);
//        for (Product product : products) {
//            HashMap<String, Object> map = new HashMap<>();
//            Classify classify = classifyMapper.selectByPrimaryKey(product.getProduct_classify_id());
//            ProductStyle productStyle = productStyleMapper.selectByPrimaryKey(product.getProduct_class_id());
//            ProductPicture productPicture = productPictureMapper.selectByPrimaryKey(product.getProduct_picture_id());
//            if (product != null) {
//                if (product.getProduct_id() != null) {
//                    productItem.setProduct_id(product.getProduct_id());
//                }
//                if (product.getProduct_size() != null) {
//                    productItem.setProduct_size(product.getProduct_size());
//                }
//                if (product.getProduct_name() != null) {
//                    productItem.setProduct_name(product.getProduct_name());
//                }
//                if (product.getProduct_class_id() != null) {
//                    productItem.setClass_id(product.getProduct_class_id());
//                }
//                if (product.getProduct_price() != null) {
//                    productItem.setProduct_price(product.getProduct_price());
//                }
//                if (product.getProduct_estimate_price() != null) {
//                    productItem.setProduct_estimate_price(product.getProduct_estimate_price());
//                }
//                if (product.getProduct_marketable() != null) {
//                    productItem.setProduct_marketable(product.getProduct_marketable());
//                }
//                if (product.getProduct_attach_id() != null) {
//                    productItem.setProduct_attach_id(product.getProduct_attach_id());
//                }
//                if (product.getProduct_number() != null) {
//                    productItem.setProduct_number(product.getProduct_number());
//                }
//                if (product.getProduct_picture_id() != null) {
//                    productItem.setProduct_picture_id(product.getProduct_picture_id());
//                }
//                if (product.getProduct_update_time() != null) {
//                    productItem.setProduct_update_time(product.getProduct_update_time());
//                }
//                if (product.getProduct_create_time() != null) {
//                    productItem.setProduct_create_time(product.getProduct_create_time());
//                }
//                if (product.getProduct_is_new() != null) {
//                    productItem.setProduct_is_new(product.getProduct_is_new());
//                }
//                if (product.getProduct_classify_id() != null) {
//                    productItem.setProduct_classify_id(product.getProduct_classify_id());
//                }
//            }
//            if (classify != null) {
//                if (classify.getClass_id() != null) {
//                    productItem.setClass_id(classify.getClass_id());
//                }
//                if (classify.getClass_name() != null) {
//                    productItem.setClass_name(classify.getClass_name());
//                }
//                if (classify.getIs_parent() != null) {
//                    productItem.setIs_parent(classify.getIs_parent());
//                }
//                if (classify.getParent_id() != null) {
//                    productItem.setParent_id(classify.getParent_id());
//                }
//                if (classify.getClass_create_time() != null) {
//                    productItem.setClass_create_time(classify.getClass_create_time());
//                }
//                if (classify.getClass_update_time() != null) {
//                    productItem.setClass_update_time(classify.getClass_update_time());
//                }
//            }
//
//            if (productPicture != null) {
//                if (productPicture.getProduct_picture_id() != null) {
//                    productItem.setProduct_picture_id(productPicture.getProduct_picture_id());
//                }
//                if (productPicture.getProduct_picture_type() != null) {
//                    productItem.setProduct_picture_type(productPicture.getProduct_picture_type());
//                }
//                if (productPicture.getProduct_picture_path() != null) {
//                    productItem.setProduct_picture_path(productPicture.getProduct_picture_path());
//                }
//                if (productPicture.getProduct_picture_create_time() != null) {
//                    productItem.setProduct_picture_create_time(productPicture.getProduct_picture_create_time());
//                }
//                if (productPicture.getProduct_picture_update_time() != null) {
//                    productItem.setProduct_picture_update_time(productPicture.getProduct_picture_update_time());
//                }
//            }
//
//            if (productStyle != null) {
//                if (productStyle.getProduct_style_id() != null) {
//                    productItem.setProduct_style_id(productStyle.getProduct_style_id());
//                }
//                if (productStyle.getProduct_style_name() != null) {
//                    productItem.setProduct_style_name(productStyle.getProduct_style_name());
//                }
//                if (productStyle.getProduct_style_picture() != null) {
//                    productItem.setProduct_style_picture(productStyle.getProduct_style_picture());
//                }
//                if (productStyle.getProduct_style_create_time() != null) {
//                    productItem.setProduct_style_create_time(productStyle.getProduct_style_create_time());
//                }
//                if (productStyle.getProduct_style_update_time() != null) {
//                    productItem.setProduct_picture_update_time(productStyle.getProduct_style_update_time());
//                }
//            }
////            if (product != null) {
////                copyFieldToBean(product, productItem);
////            }
////            if (classify != null) {
////                copyFieldToBean(classify, productItem);
////            }
////            if (productPicture != null) {
////                copyFieldToBean(productPicture, productItem);
////            }
////            if (productStyle != null) {
////                copyFieldToBean(productStyle, productItem);
////            }
//
//            map.put("productItem", productItem);
//            result.add(map);
//        }
//        return result;
        return null;
    }


    public static void copyFieldToBean(Object srcObj, Object destObj) {
        Map<String, Object> srcMap = new HashMap<String, Object>();
        Field[] srcFields = srcObj.getClass().getDeclaredFields();
        for (Field srcField : srcFields) {
            try {
                srcField.setAccessible(true);
                srcMap.put(srcField.getName(), srcField.get(srcObj)); //获取属性值
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Field[] destFields = destObj.getClass().getDeclaredFields();
        for (Field destField : destFields) {
            destField.setAccessible(true);
            if (srcMap.get(destField.getName()) == null) {
                continue;
            }
            try {
                destField.set(destObj, srcMap.get(destField.getName())); //给属性赋值
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @Transactional
    @Override
    public HashMap<String, Object> checkProductItem(Integer pageNum, Integer pageSize) {
        Page<Product> list = PageHelper.startPage(pageNum, pageSize);
//        ProductExample productExample = new ProductExample();
//        List<Product> products = productMapper.selectByExamples(productExample);
        List<Product> products = productMapper.selectProductDesc();
//        Collections.reverse(products);
        ProductItems productItems = null;
        List<ProductItems> productItems1 = new ArrayList<>();
        for (Product product : products) {
            Classify classify = classifyMapper.selectByPrimaryKey(product.getProduct_classify_id());
            ProductStyle productStyle = productStyleMapper.selectByPrimaryKey(product.getProduct_class_id());
            ProductPicture productPicture = productPictureMapper.selectByPrimaryKey(product.getProduct_picture_id());

            productItems = new ProductItems();
            if (classify != null) {
                productItems.setClass_id(classify.getClass_id());
                productItems.setClass_name(classify.getClass_name());
            }

            if (product != null) {

                productItems.setProduct_id(product.getProduct_id());
                productItems.setProduct_name(product.getProduct_name());
                productItems.setProduct_size(product.getProduct_size());
                productItems.setProduct_is_new(product.getProduct_is_new());
                productItems.setProduct_number(product.getProduct_number());
                productItems.setProduct_tag(product.getProduct_tag());
                productItems.setProduct_marketable(product.getProduct_marketable());
                productItems.setProduct_attach_id(product.getProduct_attach_id());
                productItems.setProduct_price(product.getProduct_price());
                productItems.setProduct_estimate_price(product.getProduct_estimate_price());
                productItems.setProduct_estimate_deliver_time(product.getProduct_estimate_deliver_time());
            }

            if (productPicture != null) {
                productItems.setProduct_picture_path(productPicture.getProduct_picture_path());
                productItems.setProduct_picture_id(productPicture.getProduct_picture_id());
            }

            if (productStyle != null) {
                productItems.setProduct_style_id(productStyle.getProduct_style_id());
                productItems.setProduct_style_name(productStyle.getProduct_style_name());
            }
            productItems1.add(productItems);

        }
//        Collections.reverse(productItems1);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("productItems1", productItems1);
        map.put("pages", list.getPages());
        map.put("total", list.getTotal());
        return map;
    }


    @Transactional
    @Override
    public List<HashMap<String, Object>> getAllProductStyleName() {
        List<HashMap<String, Object>> resp = new ArrayList<>();
        List<ProductStyle> productStyles = productMapper.getProductStyleName();
        for (ProductStyle productStyle : productStyles) {
            HashMap<String, Object> map = new HashMap<>();
            if (productStyle != null) {
                if (productStyle.getProduct_style_name() != null) {
                    map.put("product_style_name", productStyle.getProduct_style_name());
                    map.put("product_style_id", productStyle.getProduct_style_id());
                    resp.add(map);
                }
            }
        }
        return resp;
    }

    @Transactional
    @Override
    public List<HashMap<String, Object>> getAllClassifyName() {
        List<HashMap<String, Object>> resp = new ArrayList<>();
        List<Classify> classifies = productMapper.getClassifyName();
        for (Classify classify : classifies) {
            HashMap<String, Object> map = new HashMap<>();
            if (classify != null) {
                if (classify.getClass_name() != null) {
                    map.put("class_name", classify.getClass_name());
                    map.put("class_id", classify.getClass_id());
                    resp.add(map);
                }
            }
        }
        return resp;
    }


    @Transactional
    @Override
    public List<HashMap<String, Object>> getAllProductTag() {
        List<HashMap<String, Object>> resp = new ArrayList<>();
//        ProductExample productExample = new ProductExample();
        List<Product> products = productMapper.getProductTag();
        for (Product product : products) {
            HashMap<String, Object> map = new HashMap<>();
//            map.put("product_id", product.getProduct_id());
            if (product != null) {
                map.put("product_tag", product.getProduct_tag());
                resp.add(map);
            }
        }
        return resp;
    }

}



