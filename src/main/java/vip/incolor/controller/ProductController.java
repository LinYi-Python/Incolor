package vip.incolor.controller;

import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vip.incolor.dto.FrontOrder;
import vip.incolor.dto.RequestResult;
import vip.incolor.entity.Shopping;
import vip.incolor.exception.ServerInternalException;
import vip.incolor.exception.WrongInputException;
import vip.incolor.service.OrderService;
import vip.incolor.service.ProductService;
import vip.incolor.service.ShoppingService;
import vip.incolor.utils.GsonUtil;
import vip.incolor.utils.IncolorResultUtil;
import vip.incolor.utils.UUIDUtil;
import vip.incolor.vo.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    private ShoppingService shoppingService;
    private OrderService orderService;
    private ProductService productService;

    @Autowired
    public ProductController(ShoppingService shoppingService, OrderService orderService, ProductService productService) {
        super();
        this.shoppingService = shoppingService;
        this.orderService = orderService;
        this.productService = productService;
    }


    @RequestMapping("/getMyShoppingCart")
    @ResponseBody
    public String getMyShoppingCart(HttpSession session) {
        try {
            List<FrontOrder> result = orderService.getMyShoppingCart(session);
            return GsonUtil.getSuccessJson(result);
        } catch (Exception e) {
            return GsonUtil.getErrorJson("Server internal error");
        }
    }

    @RequestMapping(value = "/get/shopping/cart", method = RequestMethod.GET)
    @ResponseBody
    public String getShoppingCart(HttpSession session) {
        List<HashMap<String, Object>> result = orderService.getShoppingCart((Integer) session.getAttribute("user_id"));
        if (result.isEmpty()) {
            return GsonUtil.getErrorJson("没有数据");
        }
        return GsonUtil.getSuccessJson(result);
    }


    @RequestMapping(value = "/get/shopping/cart/properties", method = RequestMethod.GET)
    @ResponseBody
    public String getShoppingCartProperties(Integer shoppingId) {
        List<ProductPropertyVO> result = orderService.getShoppingCartProperties(shoppingId);
        if (result.isEmpty()) {
            return GsonUtil.getErrorJson("没有数据");
        }
        return GsonUtil.getSuccessJson(result);
    }


    @RequestMapping("/modifyMyShoppingCartNumber")
    @ResponseBody
    public String modifyMyShoppingCartNumber(@RequestParam Integer shoppingId,
                                             @RequestParam Integer number) {
        try {
            shoppingService.modifyShoppingNumber(shoppingId, number);
            return GsonUtil.getSuccessJson();
        } catch (WrongInputException e) {
            return GsonUtil.getErrorJson("wrong input");
        } catch (ServerInternalException e) {
            return GsonUtil.getErrorJson("Server internal error");
        }
    }

    @RequestMapping("/tempShoppingCartStorage")
    @ResponseBody
    public String tempShoppingCartStorage(HttpSession session, @RequestBody String tempData) {
        session.setAttribute("temp_shopping_cart", tempData);
        return GsonUtil.getSuccessJson();
    }

    @RequestMapping("/getTempShoppingCartStorage")
    @ResponseBody
    public String getTempShoppingCartStorage(HttpSession session) {
        String tempData = (String) session.getAttribute("temp_shopping_cart");
        if (tempData == null) {
            return GsonUtil.getErrorJson("expired");
        }
        //session.removeAttribute("temp_shopping_cart");
        return tempData;
    }

    @RequestMapping("/deleteShoppingCartItem")
    @ResponseBody
    public String deleteShoppingCartItem(HttpSession session, Integer shoppingId) {
        try {
            shoppingService.deleteShoppingCartItem(session, shoppingId);
            return GsonUtil.getSuccessJson();
        } catch (WrongInputException e) {
            return GsonUtil.getErrorJson("wrong input");
        } catch (ServerInternalException e) {
            return GsonUtil.getErrorJson("server internal error");
        }
    }

    @RequestMapping(value = "/add/shopping/trolley/last", method = RequestMethod.POST)
    public RequestResult addShoppingTrolleyLast(@RequestParam("shoppingId") Integer shoppingId, @RequestParam("body") String body) {
        List<PropertyVO> propertyVOs = JSONArray.parseArray(body, PropertyVO.class);
        System.out.println(propertyVOs.size() + "hh: ");
        if (shoppingId == null) {
            return IncolorResultUtil.error("缺少参数");
        }
        try {
            productService.addShoppingTrolleyLast(shoppingId, propertyVOs);
        } catch (ServerInternalException e) {
            e.printStackTrace();
            return IncolorResultUtil.error("服务器内部错误");
        }
        return IncolorResultUtil.success();
    }

    @RequestMapping(value = "/get/product/detail", method = RequestMethod.GET)
    public String getProductDetail(@RequestParam("productId") Integer productId) {
        HashMap productDetail = productService.getProductDetail(productId);
        if (!productDetail.isEmpty()) {
            return GsonUtil.getSuccessJson(productDetail);
        } else {
            return GsonUtil.getErrorJson("没有数据");
        }
    }


    /**
     * 产品加入购物车
     *
     * @param shopping 产品编号，用户编号，产品价格
     * @return
     */
    @RequestMapping(value = "/add/shopping/trolley/first", method = RequestMethod.POST)
    public String addShoppingTrolleyFirst(@Valid Shopping shopping, BindingResult result, HttpServletRequest request) {
        if (result.hasErrors()) {
            return GsonUtil.getErrorJson(result);
        }
        shopping.setUser_id((Integer) request.getSession().getAttribute("user_id"));
        HashMap map = productService.addShoppingTrolleyFirst(shopping);
        if (map.isEmpty()) {
            return GsonUtil.getErrorJson("没有数据");
        } else {
            return GsonUtil.getSuccessJson(map);
        }
    }


    /**
     * 第一步：自行车车架加入购物车
     *
     * @param shoppingId 产品编号，shopping id
     * @return
     */
    @RequestMapping(value = "/add/shopping/trolley/bicycle/first", method = RequestMethod.POST)
    public String addShoppingTrolleySecond(Integer shoppingId, String body) {
        if (shoppingId == null || body == null) {
            return GsonUtil.getErrorJson("缺少参数");
        }
        List<PropertyVO> propertyVOs = JSONArray.parseArray(body, PropertyVO.class);
        System.out.println(propertyVOs.size() + "hh: ");
        List<ShoppingVO> shoppingVO = productService.addShoppingTrolleySecond(shoppingId, propertyVOs);
        if (shoppingVO == null || shoppingVO.isEmpty()) {
            return GsonUtil.getErrorJson("没有数据");
        } else {
            return GsonUtil.getSuccessJson(shoppingVO);
        }
    }


    /**
     * 自行车第二步取消组装（选完车架）
     *
     * @param shoppingId 产品编号，shopping id
     * @return
     */
    @RequestMapping(value = "/give/up/shopping/trolley/second", method = RequestMethod.GET)
    public RequestResult giveUpShoppingTrolleySecond(@RequestParam("shoppingId") Integer shoppingId) {
        try {
            productService.giveUpShoppingTrolleySecond(shoppingId);
        } catch (ServerInternalException e) {
            e.printStackTrace();
            return IncolorResultUtil.error("服务器内部错误");
        }
        return IncolorResultUtil.success();
    }


    /**
     * 自行车返回上一步
     *
     * @param shoppingId 产品编号，shopping id
     * @return
     */
    @RequestMapping(value = "/return/shopping/trolley", method = RequestMethod.GET)
    public String returnShoppingTrolleyLast(@RequestParam("shoppingId") Integer shoppingId) {
        HashMap<String, Object> map = productService.returnShoppingTrolleyLast(shoppingId);
        return GsonUtil.getSuccessJson(map);
    }


    /**
     * 取消组装或者删除产品
     *
     * @param shoppingId 产品编号，shopping id
     * @return
     */
    @RequestMapping(value = "/give/up/shopping/trolley", method = RequestMethod.GET)
    public RequestResult giveUpShoppingTrolley(@RequestParam("shoppingId") Integer shoppingId) {
        try {
            productService.giveUpShoppingTrolley(shoppingId);
        } catch (ServerInternalException e) {
            e.printStackTrace();
            return IncolorResultUtil.error("服务器内部错误");
        }
        return IncolorResultUtil.success();
    }

    /**
     * 取尺码表
     *
     * @param productId 产品编号
     * @return
     */
    @RequestMapping(value = "/get/product/size", method = RequestMethod.GET)
    public String getProductSize(@RequestParam("productId") Integer productId) {
        String size = productService.getProductSize(productId);
        if (size == null) {
            return GsonUtil.getErrorJson("没有数据");
        }
        return GsonUtil.getSuccessJson(size);
    }

    /**
     * 得到购物车数量
     *
     * @param session
     * @return
     */
    @RequestMapping(value = "/get/shopping/cart/sum", method = RequestMethod.GET)
    @ResponseBody
    public String getShoppingCartSum(HttpSession session) {
        Integer result = orderService.getShoppingCartSum((Integer) session.getAttribute("user_id"));
        return GsonUtil.getSuccessJson(result);
    }

    @RequestMapping("/getProductByProductTag")
    @ResponseBody
    public String getProductByProductTag(String productTag){
        try {
            List result = productService.selectProductByProductTag(productTag);
            return GsonUtil.getSuccessJson(result);
        }catch (ServerInternalException e){
            e.printStackTrace();
            return GsonUtil.getErrorJson("server internal error");
        }
    }
}
