package vip.incolor.service;

import vip.incolor.entity.Classify;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;

/**
 * @author LiYizhan
 * @email 1062585732@qq.com
 * @description
 * @date 2018/7/16
 * @time 22:28
 */

public interface NewPropertyValueService {

    //-------------------------------------拉取列表区----------------------------------------------------------

    /**
     * 拉取分类列表
     * @return     键值对
     */
    List<Classify> getClassifyList();

    /**
     * 根据具体的分类拉取它的属性名称列表
     * @param classifyId    分类id
     * @return              键值对
     */
    List<HashMap<String,Object>> getPropertyList(@NotNull Integer classifyId);

    /**
     * 根据某个商品和属性名称拉取对应的属性名称的值列表
     * @param propertyId    属性名称id
     * @param productId     商品id
     * @return      键值对
     */
    List<HashMap<String,Object>> getPropertyValueList(@NotNull Integer propertyId, @NotNull Integer productId);

    //-------------------------------------拉取列表区----------------------------------------------------------

    //-------------------------------------新增区--------------------------------------------------------------

    /**
     * 给某个商品的具体分类添加一个新的属性名称
     * @param classifyId            分类id
     * @param newProperty           新的属性名称
     */
    void addNewProperty(@NotNull Integer classifyId, @NotNull String newProperty);

    /**
     * 给某个商品的具体属性名称添加一个新的值
     * @param productId             商品id
     * @param propertyId            属性名称id
     * @param newValue              新的值
     * @param newPrice              新的价格
     */
    void addNewPropertyValue(@NotNull Integer productId, @NotNull Integer propertyId,
                             @NotNull String newValue, @NotNull Double newPrice);

    //-------------------------------------新增区--------------------------------------------------------------

    //-------------------------------------修改区--------------------------------------------------------------

    /**
     * 给某个propertyValue替换掉它的旧值
     * @param propertyValueId     id
     * @param newValue            新值
     */
    void updatePropertyValue(@NotNull Integer propertyValueId, @NotNull String newValue, @NotNull Double newPrice);

    //-------------------------------------修改区--------------------------------------------------------------

    //-------------------------------------删除区--------------------------------------------------------------

    /**
     * 删除某个propertyValue
     * @param propertyValueId     id
     */
    void deletePropertyValue(@NotNull Integer propertyValueId);

    void deleteProperty(@NotNull Integer propertyId);

    //-------------------------------------删除区--------------------------------------------------------------
}
