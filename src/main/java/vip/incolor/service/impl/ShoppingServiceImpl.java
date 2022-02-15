package vip.incolor.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vip.incolor.dto.FrontOrder;
import vip.incolor.entity.Shopping;
import vip.incolor.entity.ShoppingExample;
import vip.incolor.entity.ShoppingPropertyValue;
import vip.incolor.exception.ServerInternalException;
import vip.incolor.exception.WrongInputException;
import vip.incolor.mapper.ShoppingMapper;
import vip.incolor.mapper.ShoppingPropertyValueMapper;
import vip.incolor.service.ShoppingService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author LiYizhan
 * @email 1062585732@qq.com
 * @description
 * @date 2018/4/24
 * @time 21:26
 */
@Service
public class ShoppingServiceImpl implements ShoppingService {

    private ShoppingMapper shoppingMapper;
    private ShoppingPropertyValueMapper shoppingPropertyValueMapper;

    public ShoppingServiceImpl(ShoppingMapper shoppingMapper,
                               ShoppingPropertyValueMapper shoppingPropertyValueMapper) {
        super();
        this.shoppingMapper = shoppingMapper;
        this.shoppingPropertyValueMapper = shoppingPropertyValueMapper;
    }

    @Override
    public List<FrontOrder> getShoppingCart(HttpSession session) {
        int userId = (Integer) session.getAttribute("user_id");
        List<FrontOrder> result = shoppingMapper.getUnPayedShoppingCart(userId);
        for (FrontOrder frontOrder : result) {
            StringBuilder sb = new StringBuilder();
            Integer shoppingId = frontOrder.getShoppingId();
            List<ShoppingPropertyValue> values = shoppingPropertyValueMapper.getShoppingParams(shoppingId);
            for (ShoppingPropertyValue value : values) {
                String param = value.getShopping_property_value();
                sb.append(param);
                sb.append(" ");
            }
            frontOrder.setDetail(sb.toString());
        }
        return result;
    }

    @Override
    @Transactional
    public void modifyShoppingNumber(Integer shoppingId, Integer number) {
        try {
            if (number == 0) {
                return;
            }
            Shopping shopping = shoppingMapper.selectByPrimaryKey(shoppingId);
            if (shopping == null) {
                throw new WrongInputException();
            }
            int originNumber = shopping.getShopping_number();
            int newNumber = originNumber + number;
            if (newNumber < 1) {  //数量至少为1
                throw new WrongInputException();
            }
            shopping.setShopping_number(newNumber);
            shoppingMapper.updateByPrimaryKey(shopping);
        } catch (WrongInputException e) {
            throw new WrongInputException();
        } catch (Exception e) {
            throw new ServerInternalException(e.getMessage());
        }
    }

    @Transactional
    @Override
    public void deleteShoppingCartItem(HttpSession session, Integer shoppingId) {
        try {
            int userId = (Integer) session.getAttribute("user_id");
            ShoppingExample shoppingExample = new ShoppingExample();
            shoppingExample.createCriteria().andUser_idEqualTo(userId).andShopping_idEqualTo(shoppingId);
            List<Shopping> shoppings = shoppingMapper.selectByExample(shoppingExample);
            if (shoppings.isEmpty()) {
                throw new WrongInputException();
            }
            shoppingMapper.deleteByPrimaryKey(shoppingId);
        } catch (WrongInputException e) {
            throw e;
        } catch (Exception e) {
            throw new ServerInternalException(e.getMessage());
        }
    }
}
