package vip.incolor.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vip.incolor.constant.Constants;
import vip.incolor.entity.*;
import vip.incolor.exception.ServerInternalException;
import vip.incolor.mapper.*;
import vip.incolor.service.ProductService;
import vip.incolor.vo.ProductVO;
import vip.incolor.vo.PropertyShoppingVO;
import vip.incolor.vo.PropertyVO;
import vip.incolor.vo.ShoppingVO;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author: JimLin
 * @description: 产品 service
 * @email leafyunjim@gmail.com
 * @date: 2018-04-12
 * @time: 18:00
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper productMapper;
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private PropertyValueMapper propertyValueMapper;
    @Resource
    private ShoppingMapper shoppingMapper;
    @Resource
    private ProductStyleMapper productStyleMapper;


    /**
     * 点击某产品得到三级页面：详情
     *
     * @param productId 产品 Id
     * @return
     */
    @Override
    public HashMap getProductDetail(Integer productId) {
        ProductVO productVO = productMapper.selectByProductId(productId);
        ProductPicture picture = productVO.getPicture();
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("imgs", Arrays.asList(picture.getProduct_picture_path().split("\\+")));
        map.put("product", productVO);
        return map;
    }

    /**
     * 添加到购物车：参数选择
     *
     * @param shopping 产品 id,用户 id和价格,shopping id可选
     * @return
     */

    @Transactional(rollbackFor = Exception.class)
    @Override
    public HashMap addShoppingTrolleyFirst(Shopping shopping) {
        shopping.setShopping_number(1);
        shopping.setIs_payed(false);
        shopping.setShopping_price(0.00);
        // 产生新的采购记录
        shoppingMapper.insertShopping(shopping);
        System.out.println("shoppingId: " + shopping.getShopping_id());
        // 查询是否是单车类型
        String style = productStyleMapper.selectProductStyle(shopping.getProduct_id());
        if (Constants.BICYCLE.equals(style)) {
            ProductVO part = productMapper.selectFramePartByProductId(shopping.getProduct_id());
            List<PropertyVO> propertyVOS = propertyValueMapper.selectByProductId(part.getProductId());
            // 得到购物车产品的属性
            List<PropertyShoppingVO> propertyShoppingVOs = getPropertyShoppingVOs(propertyVOS);
            ShoppingVO shoppingVO = new ShoppingVO();
            shoppingVO.setProductVO(part);
            shoppingVO.setPropertyVOS(propertyShoppingVOs);
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("shoppingId", shopping.getShopping_id());
            map.put("shoppingVO", shoppingVO);
            map.put("type", "1");
            return map;
        }
        // 非单车类型直接选参数
        ProductVO productVO = productMapper.selectByProductId(shopping.getProduct_id());
        List<PropertyVO> propertyVOS = propertyValueMapper.selectByProductId(productVO.getProductId());
        // 得到购物车产品的属性
        List<PropertyShoppingVO> propertyShoppingVOs = getPropertyShoppingVOs(propertyVOS);
        ShoppingVO shoppingVO = new ShoppingVO();
        shoppingVO.setProductVO(productVO);
        shoppingVO.setPropertyVOS(propertyShoppingVOs);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("shoppingId", shopping.getShopping_id());
        map.put("shoppingVO", shoppingVO);
        map.put("type", "0");
        return map;
    }

    /**
     * 得到购物车产品的属性
     */
    private List<PropertyShoppingVO> getPropertyShoppingVOs(List<PropertyVO> propertyVOS) {
        List<PropertyValue> propertyValues = null;
        List<PropertyShoppingVO> propertyShoppingVOs = new ArrayList<PropertyShoppingVO>(10);
        for (PropertyVO propertyVO1 : propertyVOS) {
            propertyValues = new ArrayList<PropertyValue>(6);
            for (PropertyVO propertyVO2 : propertyVOS) {
                if (propertyVO2.getPropertyId().equals(propertyVO1.getPropertyId())) {
                    // 添加属性值和价格
                    PropertyValue propertyValue = new PropertyValue();
                    propertyValue.setProperty_value_id(propertyVO2.getPropertyValueId());
                    propertyValue.setProperty_price(propertyVO2.getPropertyPrice());
                    propertyValue.setProperty_value(propertyVO2.getPropertyValue());
                    propertyValues.add(propertyValue);
                }
            }
            boolean flag = true;
            for (PropertyShoppingVO vo : propertyShoppingVOs) {
                if (propertyVO1.getPropertyId().equals(vo.getPropertyId())) {
                    flag = false;
                    break;
                }
            }
            // 设置产品属性编号，以及属性名称和属性值
            if (flag) {
                PropertyShoppingVO propertyShoppingVO = new PropertyShoppingVO();
                propertyShoppingVO.setPropertyId(propertyVO1.getPropertyId());
                propertyShoppingVO.setPropertyName(propertyVO1.getPropertyName());
                propertyShoppingVO.setPropertyValues(propertyValues);
                propertyShoppingVOs.add(propertyShoppingVO);
            }
        }
        return propertyShoppingVOs;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<ShoppingVO> addShoppingTrolleySecond(Integer shoppingId, List<PropertyVO> propertyVOs) {
        Shopping shopping = shoppingMapper.selectProductByShoppingId(shoppingId);
        List<ShoppingVO> shoppingVOs = new ArrayList<ShoppingVO>(10);
        List<PropertyShoppingVO> propertyShoppingVOs1 = null;
        double total = 0;
        for (PropertyVO vo : propertyVOs) {
            // 插入详细信息
            vo.setShoppingId(shopping.getShopping_id());
            shoppingMapper.insertDetail(vo);
            // 插入值
            shoppingMapper.insertPropertyValue(vo);
            // 算出车架总价
            PropertyValue propertyValue = propertyValueMapper.selectByPrimaryKey(vo.getPropertyValueId());
            total += propertyValue.getProperty_price();
        }
        // 更新价格
        shopping.setShopping_price(total);
        shopping.setIs_payed(false);
        shoppingMapper.updateByPrimaryKey(shopping);
        String style = productStyleMapper.selectProductStyle(shopping.getProduct_id());
        if (Constants.BICYCLE.equals(style)) {
            // 查询车其他配件
            List<ProductVO> parts = productMapper.selectOtherPartByProductId(shopping.getProduct_id());
            for (ProductVO productVO : parts) {
                List<PropertyVO> propertyVOS = propertyValueMapper.selectByProductId(productVO.getProductId());
                // 得到购物车产品的属性
                List<PropertyShoppingVO> propertyShoppingVOs = getPropertyShoppingVOs(propertyVOS);
                propertyShoppingVOs1 = new ArrayList<PropertyShoppingVO>(10);
                for (PropertyShoppingVO vo : propertyShoppingVOs) {
                    propertyShoppingVOs1.add(vo);
                }
                propertyShoppingVOs.clear();
                ShoppingVO shoppingVO = new ShoppingVO();
                shoppingVO.setProductVO(productVO);
                shoppingVO.setPropertyVOS(propertyShoppingVOs1);
                shoppingVOs.add(shoppingVO);
            }
        }
        return shoppingVOs;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addShoppingTrolleyLast(Integer shoppingId, List<PropertyVO> propertyVOs) {
        try {
            Shopping shopping = shoppingMapper.selectProductByShoppingId(shoppingId);
            double total = 0;
            for (PropertyVO vo : propertyVOs) {
                vo.setShoppingId(shoppingId);
                // 插入详细信息
                shoppingMapper.insertDetail(vo);
                // 插入值
                shoppingMapper.insertPropertyValue(vo);
                // 算出总价
                PropertyValue propertyValue = propertyValueMapper.selectByPrimaryKey(vo.getPropertyValueId());
                total += propertyValue.getProperty_price();
            }
            // 更新价格
            shopping.setShopping_price(total + shopping.getShopping_price());
            shopping.setIs_payed(false);
            shoppingMapper.updateByPrimaryKey(shopping);
        } catch (Exception e) {
            throw new ServerInternalException();
        }

    }

    @Override
    public void giveUpShoppingTrolleySecond(Integer shoppingId) {
        try {
            shoppingMapper.deleteShoppingTrolley(shoppingId);
        } catch (Exception e) {
            throw new ServerInternalException();
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void giveUpShoppingTrolley(Integer shoppingId) {
        try {
            shoppingMapper.deleteShoppingTrolley(shoppingId);
        } catch (Exception e) {
            throw new ServerInternalException();
        }


    }

    @Override
    public HashMap<String, Object> returnShoppingTrolleyLast(Integer shoppingId) {
        // 返回上一步时，再重新加入购物车
        Shopping shopping = shoppingMapper.selectProductByShoppingId(shoppingId);
        ProductVO part = productMapper.selectFramePartByProductId(shopping.getProduct_id());
        List<PropertyVO> propertyVOS = propertyValueMapper.selectByProductId(part.getProductId());
        // 得到购物车产品的属性
        List<PropertyShoppingVO> propertyShoppingVOs = getPropertyShoppingVOs(propertyVOS);
        ShoppingVO shoppingVO = new ShoppingVO();
        shoppingVO.setProductVO(part);
        shoppingVO.setPropertyVOS(propertyShoppingVOs);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("shoppingId", shopping.getShopping_id());
        map.put("shoppingVO", shoppingVO);
        // 删除属性记录
        shoppingMapper.deleteShoppingTrolleyDetailAndValue(shopping.getShopping_id());
        return map;


    }

    @Override
    public String getProductSize(Integer productId) {
        return productMapper.selectProductSizeById(productId);
    }

    @Transactional
    @Override
    public List<HashMap<String, Object>> selectProductByProductTag(String productTag){
        List<HashMap<String, Object>> resp = new ArrayList<>();
        ProductExample productExample = new ProductExample();
        productExample.createCriteria().andProduct_tagEqualTo(productTag);
        List<Product> products = productMapper.selectProductByProductTag(productTag);
        for (Product product : products){
            HashMap<String, Object> map = new HashMap<>();
            map.put("product_id", product.getProduct_id());
            map.put("product_name", product.getProduct_name());
            resp.add(map);
        }
        return resp;
    }


}
