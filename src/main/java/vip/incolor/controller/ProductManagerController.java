package vip.incolor.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import vip.incolor.dto.*;
import vip.incolor.entity.Classify;
import vip.incolor.entity.Product;
import vip.incolor.entity.ProductPicture;
import vip.incolor.entity.ProductStyle;
import vip.incolor.exception.ServerInternalException;
import vip.incolor.service.NewPropertyValueService;
import vip.incolor.service.ProductManagerService;
import vip.incolor.utils.GsonUtil;
import vip.incolor.utils.IncolorResultUtil;

import java.util.HashMap;
import java.util.List;

/**
 * @author LinPython
 * @email ly546654542@gmail.com
 * @description
 * @date 2018/5/6
 * @time 21:46
 */
@RestController
@RequestMapping("productManager")
public class ProductManagerController {

    private ProductManagerService productManagerService;
    private NewPropertyValueService newPropertyValueService;

    @Autowired
    public ProductManagerController(ProductManagerService productManagerService, NewPropertyValueService newPropertyValueService) {
        this.productManagerService = productManagerService;
        this.newPropertyValueService = newPropertyValueService;
    }


    @RequestMapping("/getClassifyList")
    @ResponseBody
    public String getClassifiesList(Integer productId) {
        try {
            List result = productManagerService.getClassifyList(productId);
            return GsonUtil.getSuccessJson(result);
        } catch (ServerInternalException e) {
            e.printStackTrace();
            return GsonUtil.getErrorJson("server internal error");
        }
    }

    @RequestMapping("/getProductList")
    @ResponseBody
    public String getProductList(Integer productId) {
        try {
            List result = productManagerService.getProductList(productId);
            return GsonUtil.getSuccessJson(result);
        } catch (ServerInternalException e) {
            e.printStackTrace();
            return GsonUtil.getErrorJson("server internal error");
        }
    }

    @RequestMapping("/getProductPictureList")
    @ResponseBody
    public String getProductPictureList(Integer productId) {
        try {
            List result = productManagerService.getProductPictureList(productId);
            return GsonUtil.getSuccessJson(result);
        } catch (ServerInternalException e) {
            e.printStackTrace();
            return GsonUtil.getErrorJson("server internal error");
        }
    }

    @RequestMapping("/getProductStyleList")
    @ResponseBody
    public String getProductStyleList(Integer productId) {
        try {
            List result = productManagerService.getProductStyleList(productId);
            return GsonUtil.getSuccessJson(result);
        } catch (ServerInternalException e) {
            e.printStackTrace();
            return GsonUtil.getErrorJson("server internal error");
        }
    }

    @RequestMapping("/updateClassifyByProductId")
    @ResponseBody
    public String updateClassifyByProductId(Classify classify) {
        try {
            productManagerService.updateClassifyByProductId(classify);
            return GsonUtil.getSuccessJson();
        } catch (ServerInternalException e) {
            e.printStackTrace();
            return GsonUtil.getErrorJson("server internal error");
        }
    }

    @RequestMapping("/updateProductByProductId")
    @ResponseBody
    public String updateProductByProductId(Product product) {
        try {
            productManagerService.updateProductByProductId(product);
            return GsonUtil.getSuccessJson();
        } catch (ServerInternalException e) {
            e.printStackTrace();
            return GsonUtil.getErrorJson("server internal error");
        }
    }

    @RequestMapping("/updateProductPictureByProductId")
    @ResponseBody
    public String updateProductPictureByProductId(ProductPicture productPicture) {
        try {
            productManagerService.updateProductPictureByProductId(productPicture);
            return GsonUtil.getSuccessJson();
        } catch (ServerInternalException e) {
            e.printStackTrace();
            return GsonUtil.getErrorJson("server internal error");
        }
    }

    @RequestMapping("/updateProductStyleByProductId")
    @ResponseBody
    public String updateProductStyleByProductId(ProductStyle productStyle) {
        try {
            productManagerService.updateProductStyleByProductId(productStyle);
            return GsonUtil.getSuccessJson();
        } catch (ServerInternalException e) {
            e.printStackTrace();
            return GsonUtil.getSuccessJson("server internal error");
        }
    }


    @RequestMapping("/deleteProduct")
    @ResponseBody
    public String deleteProduct(Integer productId) {
        try {
            productManagerService.deleteProduct(productId);
            return GsonUtil.getSuccessJson();
        } catch (ServerInternalException e) {
            e.printStackTrace();
            return GsonUtil.getErrorJson("server internal error");
        }
    }

    @RequestMapping("/`")
    @ResponseBody
    public String getClassifyList() {
        try {
            List result = newPropertyValueService.getClassifyList();
            return GsonUtil.getSuccessJson(result);
        } catch (ServerInternalException e) {
            e.printStackTrace();
            return GsonUtil.getErrorJson("server internal error");
        }
    }

    @RequestMapping("/getPropertyList")
    @ResponseBody
    public String getPropertyList(Integer classifyId) {
        try {
            List result = newPropertyValueService.getPropertyList(classifyId);
            return GsonUtil.getSuccessJson(result);
        } catch (ServerInternalException e) {
            e.printStackTrace();
            return GsonUtil.getErrorJson("server internal error");
        }
    }

    @RequestMapping("/getPropertyValueList")
    @ResponseBody
    public String getPropertyValueList(Integer propertyId, Integer productId) {
        try {
            List result = newPropertyValueService.getPropertyValueList(propertyId, productId);
            return GsonUtil.getSuccessJson(result);
        } catch (ServerInternalException e) {
            e.printStackTrace();
            return GsonUtil.getErrorJson("server internal error");
        }
    }

    @RequestMapping("/addNewProperty")
    @ResponseBody
    public String addNewProperty(Integer classifyId, String newProperty) {
        try {
            newPropertyValueService.addNewProperty(classifyId, newProperty);
            return GsonUtil.getSuccessJson();
        } catch (ServerInternalException e) {
            e.printStackTrace();
            return GsonUtil.getErrorJson("server internal error");
        }
    }

    @RequestMapping("/addNewPropertyValue")
    @ResponseBody
    public String addNewPropertyValue(Integer productId, Integer propertyId, String newValue, Double newPrice) {
        try {
            newPropertyValueService.addNewPropertyValue(productId, propertyId, newValue, newPrice);
            return GsonUtil.getSuccessJson();
        } catch (ServerInternalException e) {
            e.printStackTrace();
            return GsonUtil.getErrorJson("server internal error");
        }
    }

    @RequestMapping("/updatePropertyValue")
    @ResponseBody
    public String updatePropertyValue(@RequestParam Integer propertyValueId, String newValue,Double newPrice) {
        try {
            newPropertyValueService.updatePropertyValue(propertyValueId, newValue, newPrice);
            return GsonUtil.getSuccessJson();
        } catch (ServerInternalException e) {
            e.printStackTrace();
            return GsonUtil.getErrorJson("server internal error");
        }
    }

    @RequestMapping("/updateProduct")
    @ResponseBody
    public String updateProduct(ProductItemss productItemss){
        try {
            productManagerService.updateProductByProductIds(productItemss);
            return GsonUtil.getSuccessJson();
        } catch (ServerInternalException e) {
            e.printStackTrace();
            return GsonUtil.getSuccessJson("server internal error");
        }
    }


    @RequestMapping("/deletePropertyValue")
    @ResponseBody
    public String deletePropertyValue(@RequestParam Integer propertyValueId) {
        try {
            newPropertyValueService.deletePropertyValue(propertyValueId);
            return GsonUtil.getSuccessJson();
        } catch (ServerInternalException e) {
            e.printStackTrace();
            return GsonUtil.getErrorJson("server internal error");
        }
    }

    @RequestMapping("/deleteProperty")
    @ResponseBody
    public String deleteProperty(@RequestParam Integer propertyId){
        try {
            newPropertyValueService.deleteProperty(propertyId);
            return GsonUtil.getSuccessJson();
        }catch (ServerInternalException e){
            e.printStackTrace();
            return GsonUtil.getErrorJson("server internal error");
        }
    }

    @RequestMapping("/uploadPic")
    @ResponseBody
    public String uploadPic(MultipartFile file, Integer productId, boolean isThumb) {
        try {
            productManagerService.uploadPic(file, productId, isThumb);
            return GsonUtil.getSuccessJson();
        } catch (ServerInternalException e) {
            e.printStackTrace();
            return GsonUtil.getErrorJson("server internal error");
        }
    }

    @RequestMapping("/uploadProductSizePic")
    @ResponseBody
    public String uploadProductSizePic(MultipartFile file, Integer productId) {
        try {
            productManagerService.uploadProductSizePic(file, productId);
            return GsonUtil.getSuccessJson();
        } catch (ServerInternalException e) {
            e.printStackTrace();
            return GsonUtil.getErrorJson("server internal error");
        }
    }


    @RequestMapping("/deletePic")
    @ResponseBody
    public String deletePic(Integer productId) {
        try {
            productManagerService.deleteProductPicture(productId);
            return GsonUtil.getSuccessJson();
        } catch (ServerInternalException e) {
            e.printStackTrace();
            return GsonUtil.getErrorJson("server internal error");
        }
    }

    @RequestMapping("/addClassify")
    @ResponseBody
    public String addClassify(Classify classify) {
        try {
            productManagerService.addClassify(classify);
            return GsonUtil.getSuccessJson();
        } catch (ServerInternalException e) {
            e.printStackTrace();
            return GsonUtil.getErrorJson("server internal error");
        }
    }

    @RequestMapping("/addProduct")
    @ResponseBody
    public String addProduct(Product product) {
        try {
            productManagerService.addProduct(product);
            return GsonUtil.getSuccessJson();
        } catch (ServerInternalException e) {
            e.printStackTrace();
            return GsonUtil.getErrorJson("server internal error");
        }
    }

    @RequestMapping("/addProductPicture")
    @ResponseBody
    public String addProductPicture(ProductPicture productPicture) {
        try {
            productManagerService.addProductPicture(productPicture);
            return GsonUtil.getSuccessJson();
        } catch (ServerInternalException e) {
            e.printStackTrace();
            return GsonUtil.getErrorJson("server internal error");
        }
    }

    @RequestMapping("/addProductStyle")
    @ResponseBody
    public String addProductStyle(ProductStyle productStyle) {
        try {
            productManagerService.addProductStyle(productStyle);
            return GsonUtil.getSuccessJson();
        } catch (ServerInternalException e) {
            e.printStackTrace();
            return GsonUtil.getErrorJson("server internal error");
        }
    }

    @RequestMapping("/addProductItem")
    @ResponseBody
    public String addProductItem(ProductItemss productItemss){
        try {
            productManagerService.addProductItem(productItemss);
            return GsonUtil.getSuccessJson();
        }catch (ServerInternalException e){
            e.printStackTrace();
            return GsonUtil.getSuccessJson("server internal error");
        }
    }

    @RequestMapping("/getProductInformation")
    @ResponseBody
    public String getProductInformation(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize) {
        List<HashMap<String, Object>> list = productManagerService.listProduct(pageNum, pageSize);
        if (list.size() > 0) {
            return GsonUtil.getSuccessJson(list);
        }
        return GsonUtil.getErrorJson("没有数据");
    }

    @RequestMapping("/getAttachInformation")
    @ResponseBody
    public String getAttachInformation(Integer productId) {
        List<HashMap<String, Object>> list = productManagerService.getMainProductInformation(productId);
        if (list.size() > 0) {
            return GsonUtil.getSuccessJson(list);
        }
        return GsonUtil.getErrorJson("没有数据");
    }

    @RequestMapping("/getListProductItem")
    @ResponseBody
    public String getListProductItem(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize) {
        List<HashMap<String, Object>> list = productManagerService.ListProductItem(pageNum, pageSize);
        if (list.size() > 0) {
            return GsonUtil.getSuccessJson(list);
        }
        return GsonUtil.getErrorJson("没有数据");
    }

    @RequestMapping("/getNewAttachInformation")
    @ResponseBody
    public String getNewAttachInformation(Integer productId) {
        HashMap<String, Object> list = productManagerService.getMainNewProductInformation(productId);
        if (list.size() > 0) {
            return GsonUtil.getSuccessJson(list);
        }
        return GsonUtil.getErrorJson("没有数据");
    }

    @RequestMapping("/getNewListProductItem")
    @ResponseBody
    public RequestResult getNewListProductItem(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize) {
        HashMap<String, Object> map = productManagerService.checkProductItem(pageNum, pageSize);
        if ((Long) map.get("total") > 0) {
            return IncolorResultUtil.success(map);
        }
        return IncolorResultUtil.error("没有数据");
    }

    @RequestMapping("/getAllProductTag")
    @ResponseBody
    public String getAllProductTag(){
        try {
            List result = productManagerService.getAllProductTag();
            return GsonUtil.getSuccessJson(result);
        } catch (ServerInternalException e) {
            e.printStackTrace();
            return GsonUtil.getErrorJson("server internal error");
        }
    }

    @RequestMapping("/getAllProductStyleName")
    @ResponseBody
    public String getAllProductStyleName(){
        try {
            List result = productManagerService.getAllProductStyleName();
            return GsonUtil.getSuccessJson(result);
        } catch (ServerInternalException e) {
            e.printStackTrace();
            return GsonUtil.getErrorJson("server internal error");
        }
    }

    @RequestMapping("/getAllClassifyName")
    @ResponseBody
    public String getAllClassifyName(){
        try {
            List result = productManagerService.getAllClassifyName();
            return GsonUtil.getSuccessJson(result);
        } catch (ServerInternalException e) {
            e.printStackTrace();
            return GsonUtil.getErrorJson("server internal error");
        }
    }



}