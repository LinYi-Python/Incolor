package vip.incolor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vip.incolor.entity.*;
import vip.incolor.exception.ServerInternalException;
import vip.incolor.mapper.ClassifyMapper;
import vip.incolor.mapper.PropertyMapper;
import vip.incolor.mapper.PropertyValueMapper;
import vip.incolor.service.NewPropertyValueService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author LiYizhan
 * @email 1062585732@qq.com
 * @description
 * @date 2018/7/16
 * @time 23:00
 */

@Service
public class NewPropertyValueServiceImpl implements NewPropertyValueService{

    private ClassifyMapper classifyMapper;
    private PropertyMapper propertyMapper;
    private PropertyValueMapper propertyValueMapper;

    @Autowired
    public NewPropertyValueServiceImpl(ClassifyMapper classifyMapper,
                                       PropertyMapper propertyMapper,
                                       PropertyValueMapper propertyValueMapper){
        this.classifyMapper = classifyMapper;
        this.propertyMapper = propertyMapper;
        this.propertyValueMapper = propertyValueMapper;
    }

    @Override
    public List<Classify> getClassifyList() {
        return classifyMapper.list();
    }

    @Override
    public List<HashMap<String, Object>> getPropertyList(Integer classifyId) {
        List<HashMap<String,Object>> resp = new ArrayList<>();
        PropertyExample propertyExample = new PropertyExample();
        propertyExample.createCriteria()
                .andClassify_idEqualTo(classifyId);
        List<Property> properties = propertyMapper.selectByExample(propertyExample);
        for(Property property : properties){
            HashMap<String,Object> map = new HashMap<>();
            map.put("property_id", property.getProperty_id());
            map.put("property_name", property.getProperty_name());
            resp.add(map);
        }
        return resp;
    }

    @Override
    public List<HashMap<String, Object>> getPropertyValueList(Integer propertyId, Integer productId) {
        List<HashMap<String,Object>> resp = new ArrayList<>();
        PropertyValueExample propertyValueExample = new PropertyValueExample();
        propertyValueExample.createCriteria()
                .andProduct_idEqualTo(productId)
                .andProperty_idEqualTo(propertyId);
        List<PropertyValue> propertyValues = propertyValueMapper.selectByExample(propertyValueExample);
        for(PropertyValue propertyValue : propertyValues){
            HashMap<String,Object> map = new HashMap<>();
            map.put("property_value_id", propertyValue.getProperty_value_id());
            map.put("property_value", propertyValue.getProperty_value());
            map.put("property_price", propertyValue.getProperty_price());
            resp.add(map);
        }
        return resp;
    }

    @Transactional
    @Override
    public void addNewProperty(Integer classifyId, String newProperty) {
        try{
            Property property = new Property();
            property.setClassify_id(classifyId);
            property.setProperty_name(newProperty);
            propertyMapper.insert(property);
        }catch (Exception e){
            throw new ServerInternalException(e.getMessage());
        }
    }

    @Transactional
    @Override
    public void addNewPropertyValue(Integer productId, Integer propertyId, String newValue, Double newPrice) {
        try {
            PropertyValue propertyValue = new PropertyValue();
            propertyValue.setProduct_id(productId);
            propertyValue.setProperty_id(propertyId);
            propertyValue.setProperty_price(newPrice);
            propertyValue.setProperty_value(newValue);
            propertyValueMapper.insert(propertyValue);
        }catch (Exception e){
            throw new ServerInternalException(e.getMessage());
        }
    }
    @Transactional
    @Override
    public void updatePropertyValue(Integer propertyValueId, String newValue, Double newPrice) {
        try {
            PropertyValue propertyValue = propertyValueMapper.selectByPrimaryKey(propertyValueId);
            if(propertyValue == null) {
                throw new Exception("产品属性不存在");
            }
            propertyValue.setProperty_value(newValue);
            propertyValue.setProperty_price(newPrice);
            propertyValueMapper.updateByPrimaryKey(propertyValue);
        }catch (Exception e){
            throw new ServerInternalException(e.getMessage());
        }
    }

    @Transactional
    @Override
    public void deletePropertyValue(Integer propertyValueId) {
        try{
            propertyValueMapper.deleteByPrimaryKey(propertyValueId);
        }catch (Exception e){
            throw new ServerInternalException(e.getMessage());
        }
    }

    @Transactional
    @Override
    public void deleteProperty(Integer propertyId){
        try {
            propertyMapper.deleteByPrimaryKey(propertyId);
        }catch (Exception e){
            throw new ServerInternalException(e.getMessage());
        }
    }
}
