package vip.incolor.service.impl;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vip.incolor.entity.Order;
import vip.incolor.entity.OrderExample;
import vip.incolor.exception.ServerInternalException;
import vip.incolor.exception.WrongInputException;
import vip.incolor.mapper.OrderMapper;
import vip.incolor.service.ExpressService;
import vip.incolor.dto.ExpressInfo;

import javax.xml.transform.Result;
import java.util.List;

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

/**
 * @author LinPython
 * @email ly546654542@gmail.com
 * @description
 * @date 2018/4/29
 * @time 15:21
 */
@Service
public class ExpressServicelmpl implements ExpressService {

    private OrderMapper orderMapper;

    @Autowired
    public ExpressServicelmpl(OrderMapper orderMapper){
        super();
        this.orderMapper = orderMapper;
    }

    @Override
    public String getMyExpressNumber(Integer orderId){
        OrderExample example = new OrderExample();
        example.createCriteria().andUser_idEqualTo(orderId);
        Order order = orderMapper.selectByPrimaryKey(orderId);
        String ExpressNumber = order.getOrder_express_number();
        return ExpressNumber;
    }


    @Override
    @Transactional
    public void  modifyMyExpressNumber(Integer orderId, String ExpressNumber){
        try {
            Order order = orderMapper.selectByPrimaryKey(orderId);
            order.setOrder_express_number(ExpressNumber);
            orderMapper.updateByPrimaryKeySelective(order);
        }catch (WrongInputException e){
            throw e;
        }catch (Exception e){
            throw new ServerInternalException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public void deleteMyExpressNumber(Integer orderId){
        try {
            Order order = orderMapper.selectByPrimaryKey(orderId);
            if(order!=null){
                orderMapper.deleteByPrimaryKey(orderId);
            }
            }catch(Exception e){
                throw new ServerInternalException(e.getMessage());
        }
    }

//    @Override
//    public String postMyExpress(String expressNumber) {
//        try {
//            String url = "https://api.apishop.net/common/express/getExpressInfo";
//            String apiKey = "9TftJ5Pa38991ca4153e693d319c8b0544cc469d4c3c1c4";
//            String expressType = "";
//            String parameters =url +"?apiKey="+ apiKey +"&expressNumber="+ expressNumber + "&expressType="+ expressType;
//
////            Gson gson = new Gson();
////            String json = gson.toJson(parameters);
//            OkHttpClient client = new OkHttpClient();//创建OkHttpClient对象
//            Request request = new Request.Builder().url(parameters).build();//创建Request对象
//            Response response = client.newCall(request).execute(); //得到Response对象
//            if (response.isSuccessful()) {
//                  String expressResult = response.body().string(); //远程服务器返回结果
//
////                ExpressInfo expressInfo = new ExpressInfo();
//
////                Gson gson = new Gson();
////                gson.fromJson(result, FrontOrder.class);    //把String换成自己对应的实体类
//                  return expressResult;
//            }
//        }catch (Exception e){
//            throw new ServerInternalException(e.getMessage());
//        }
//        return expressNumber;
//    }

    @Override
    public String postMyExpress(String expressNumber) {
        try {
            String url = "https://api.apishop.net/common/express/getExpressInfo";
            String apiKey = "9TftJ5Pa38991ca4153e693d319c8b0544cc469d4c3c1c4";
            String expressType = "";
            String parameters =url +"?apiKey="+ apiKey +"&expressNumber="+ expressNumber + "&expressType="+ expressType;

//            Gson gson = new Gson();
//            String json = gson.toJson(parameters);
            OkHttpClient client = new OkHttpClient();//创建OkHttpClient对象
            Request request = new Request.Builder().url(parameters).header("Accept","application/json").build();//创建Request对象
            Response response = client.newCall(request).execute(); //得到Response对象
            if (response.isSuccessful()) {
                ExpressInfo expressInfo = new ExpressInfo();
                String expressResult = response.body().string(); //远程服务器返回结果

//                ExpressInfo expressInfo = new ExpressInfo();

//                Gson gson = new Gson();
//                gson.fromJson(result, FrontOrder.class);    //把String换成自己对应的实体类
                return expressResult;
            }
        }catch (Exception e){
            throw new ServerInternalException(e.getMessage());
        }
        return expressNumber;
    }

//    @Override
//    public String getMyExpress(Integer orderId) {
//        try {
//            String expressNumber = getMyExpressNumber(orderId);
//            String result = postMyExpress(expressNumber);
//            return result;
//        }catch (WrongInputException e){
//            throw e;
//        }catch (Exception e){
//            throw new ServerInternalException(e.getMessage());
//        }
//    }
}
