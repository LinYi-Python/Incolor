package vip.incolor.service.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.HtmlUtils;
import vip.incolor.dto.OrderItem;
import vip.incolor.dto.ReceiverInfo;
import vip.incolor.entity.*;
import vip.incolor.exception.NotPayException;
import vip.incolor.exception.ServerInternalException;
import vip.incolor.exception.SignatrueFailException;
import vip.incolor.exception.WrongInputException;
import vip.incolor.mapper.*;
import vip.incolor.service.AliPayService;
import vip.incolor.utils.Checker;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author LiYizhan
 * @email 1062585732@qq.com
 * @description
 * @date 2018/4/22
 * @time 17:32
 */
@Service
public class AliPayServiceImpl implements AliPayService{
    //沙箱环境网关
    private final static String SANDBOX_URL="https://openapi.alipaydev.com/gateway.do";
    //沙箱环境APPID
    private final static String SANDBOX_APP_ID="2016091400513156";
    //沙箱环境公钥
    private final static String SANDBOX_PUBLIC_KEY="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAmuh1Mk8ztGpgbTi6iUYPWRJwL29YkphzhaWnEsx1FtgevLK2+f6r6OSPyUE+MfEMpZgkoPf+vL1dx+ZSTpHHnzc776P47iZ5yCY9gsl9GU4h9Q3k5qbAmrTQRdeBZUfwxoHSJY2g6kLW+3iSRdkvC+3ofsuPrFwP7pTUBve1nMzvAjzFHtceAIrSyEVxaIBRXT2lX9hze12910H2pVSLaYclTZIPX6zwO0R96zXmrN2qLiz5ES/6cC1T9xKmGNROd/FaKFQnskX+GOMI4+U0mkatqomnt0quqtWq/LIp3l87369v9+yYxR/Gw+UrGEqF6VQwixm2v1zY+TdaZR38LQIDAQAB";
//    private final static String SANDBOX_PUBLIC_KEY="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAiKmRKtC3SQqUyZfR0Xg4cFvvz1F6mdKrm/kZB82JI0txFY5/gSt6GAqSDyrZwC/Mqdk5COz8n/lzFCLkZmQVLz4QOwoApHjSLUswWm8dkNwrJ2CMbo6BFODbJdl19r5kjsuE+TzG0eIhkVfrqvvb4GX4MLMEkQVUKOqeLHUWAgoTyVqkaI3MK29j0hk3AG0cW9k36G3UYVzH6ocIZezhPyMdXbsuW8LlQPYWwxMjyvGDJ58Nf10LAxoxJz1HKV8kXnPjXiP9rjYGbLqATfvbx05hdjqvbL8TcYtFGL2rI2dWJ/TVNxEqIEP6xEuEhPmw7CeknP4hiDpDF0KdEUtsDQIDAQAB";
    //沙箱环境密钥
    private final static String SANDBOX_PRIVATE_KEY="MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCEpJe/ipmDXLfQdhd7ro9CXmUIhy3AiINAUsm4ohgUOmzMY1imVY8KaSndPOTuGy64YHsFvnJV6ePlspVrlbAwOlDtmJB2qHZrNdwYQ3mxXTcvUX1VY0hC9O7iQzOR/hy4UPmgvvjTJr2audnjQH5D77SlhzC3puruyrGDm5RXhYzD4XsSEDo+HyETRghH2xGuBbe0Esn1mtdN2TaigPfxkjPepnvpGRfDR4Fth0XiamDNsGxgk7FS1Gazp4bsqkVoigW896A4p1gyGwYK3qOM/mKMedcJnoQajFu1g3t9L+p1iPICLv0LGHmwD2e7LO5OwbYBvu7OFly0zwu0+k+/AgMBAAECggEAezOF31sVC3ZrJS0K0s5oMfULUsh8LoCdqHk89ElapC9ALvd3t8dwfPMA94U//gkxc//pRISIHlSIYSlmr+7xH1qLIKS8SfpfQ2VbcQ37UkqKn2DJUS5OSCLIX1Cb7dZhRrGvqya2ZylsovJM909H+EIFQFo5XdukCvgpuVwghMkojLOjXk/M4boeeIwHhunJ2+7zIEFMfxnMrN3b6FPgiIfDlH3onp17tDhxUxEcf5Jen6V/kjdlL7dmjtf2LAR4mOEz8BGMrYlxv+IndL1+VZyEKHIyzD5R9/w9V5GimV5H8XsNnoRXQUgCHGFAPbv1gu5ZiYx8qbrT93xvdTvzQQKBgQC4e7RUry+PQs7teqbBSf1qHg5XmyJAL0mqtMZiq+FfMCRHVkArym9RV17TvlPrQYgN/Wpf/dhOPlMgHGKxHGnURz0Li919vr99/exaHhcHomRgbzZe+cY++Courpi+LFWTr5z3ut11ZAIBmUoeVuc3yd2+0NGZVxDUxBq6iiGqwwKBgQC4EDVKpYwjys1kM3oIXft1z9qDMRx9y6x4Gfz0tPvyZjffskfX47FNOjLf5pGpOATzfZeSbRCtko0XmNs880xMiUEUoYS71MDcjajwIG/IyPH7GGz49cQGDukztMub/spi0Z4PottHgLx9YuTKwjCSFkBmyjgZYjKoZbfA03UfVQKBgBJsgEDo0fYbtPCwjBDHo+BCKiqDmrMQReofbaSTB8nq0+Sv726wI9fawuSgoF7hR4YmJcZ6YmzF+qU9UHnhnYwOpUEO8crKDvO1NTJ2yNQBWsbqtGJdzXeibwwEccqkQNOj+SggaFd96llghq9q/GJs7ZFN53DJ6itlfknc26njAoGBAKndA2FVL+RkJ3JeczM/kG3kGVNTQmjxSsQ3r5MhZxYHsW62t8iL77dGi2bIAQr6kM8oy3WtQ2P7yEvLnCA+o95KGI5ylO1G5YllDlA0jxTsJSzGGOMU5Ad3QU2ffvwCgkH6EvV5JQZyzwCkAGMCHRLkiCCUZHtAfWGdJZxFSWRVAoGAEPB+oxuU2qBl2Mle+46y2OtN4PW6TfqQz78lqpvOVJimFkzgyUZdTFjGrSKQLjegFmjqPFCmGmQyKY/NtjOLjtEb8RaNEHbGjnIkRTX8qCx0YpxEZLav6VVqENDZHEgtD5a6CuAfEat8LKGmgBBa/9zd7TegTv0UESo6bEeyJa0=";
//    private final static String SANDBOX_PRIVATE_KEY="MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCIqZEq0LdJCpTJl9HReDhwW+/PUXqZ0qub+RkHzYkjS3EVjn+BK3oYCpIPKtnAL8yp2TkI7Pyf+XMUIuRmZBUvPhA7CgCkeNItSzBabx2Q3CsnYIxujoEU4Nsl2XX2vmSOy4T5PMbR4iGRV+uq+9vgZfgwswSRBVQo6p4sdRYCChPJWqRojcwrb2PSGTcAbRxb2TfobdRhXMfqhwhl7OE/Ix1duy5bwuVA9hbDEyPK8YMnnw1/XQsDGjEnPUcpXyRec+NeI/2uNgZsuoBN+9vHTmF2Oq9svxNxi0UYvasjZ1Yn9NU3ESogQ/rES4SE+bDsJ6Sc/iGIOkMXQp0RS2wNAgMBAAECggEAGalNeu6qG+sCuT/qxByA7Ig25YT1MoEefDEwBAkSITB/UX7qbkTNrkn91x9CuBXBpnsFfKmTXi6m7zcGEDvmxnIu9gcQy9FsFdkygSiwMo1FBSXZ+MCFeHgoblkBD438r9uDYpGI+8wsZXBO7lJQnThIfEyBJQINJYm4nbx2n3cihOFSArq28Dd6BVvyPVy+gPGpowJRydhnfKLp2FJg8LM6V3AAnlS1jSi6ft1KjL9S9/FKhwJVRzN6xQYGh0k5z+H9bAKTrFVIXoHe2rqmXkihFAB2uDtJNstEsy6YlMDcatcFHxAOWQk5S/LuQH/Pk9oiYd9uzphBFZHbm9KBQQKBgQDJTo13Kr+16uIEie3KoCZn0nSa0zFkCaLesKWyTLcI2akkYYIEzoMkHehuXgyfrYr9N/6VnN4WR9II2A2V8ybMyMu2uTXW+3WvgMBAoqdN2BOsj4wCpR5kEyJIO9axMxf2o1VtBtGgCZ+xAshRmoNVhRDBx1Ua6LaZDuvZ65SD6QKBgQCtytAHa7j/7p83UrJRQ3bt1ZHTsoGyHi52ag0jGxPztXsTBD78ZxGoYl8WXfT4fDj4iJBmEj3LooK9KgQOoYa+/kyoAVYsC+R69Orzegmu0z/hCBnrYcbZWOh6a2qfKybzGYqQNiG4ahya3Ne8zyBF8O9lud8ZYv9dW11FFrFEhQKBgESiC4k9ge88DaMOg4w53d432pmOt6AryOOzxkpr7VuPGiPVOsb4wa1mpQA8AIHQYTrEBIBt4yolgm6RetBM/kWDkDDUJI8PXKhhdSqUSgY4TTzgFBQyx5HHFEEcZa40hU8JkO6DDKVLoq5vDG0GCRD3NSdcFp/+B4NXmwHJV/FBAoGAVULivEFFCYpv4hxYDzYh6pyUZl908YWNFdsBhu+J4k5uiu3SWNHX/9wC+l4uCJoo+QVGkkzwtC6OJW+vfd4Q1TK9OM8vD3zmIsx1V+3PQk2xUR1AWhImFAtiQmzgaiYpfapSKF3mPSsRzYf6705ObwG88RM3OKUw0wQ3xeVUImECgYEAmtxI+mMFj8IKxjhmOdh4e6fJb1+QyYEgWtjzLl3eQlBrVaPOrmloHcp0Z6AFKE2OCUX7h68PKSyxdqf4x7ATTCuEgkIZQw1TjIN2xI/P7jx755DAYfqfDBahmtav/ZN1KPZ3QEATS3eFlODfqdsZHIic/fmzjey0n33ybwKkipQ=";
    //支付宝网关
    private final static String URL="https://openapi.alipay.com/gateway.do";
    //APPID
    private final static String APP_ID="2018042660012646";
    //商户应用密钥
    private final static String PRIVATE_KEY="MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQDBQlO4z1YSlMqAu+ZYqRp+YjBdTn3EQnc/2rOhUSsCIvpT59aifOAkxTuI5hpg7fPAm8WvUygsogmsdKqs7HS3TR0TgTrX46IdnY2IqwJm6sGcKO7+L/DZjCHQkw8JOboeVGgd/E9QK2cyCuC8brmw+1px9vT0u11Cr5Gjtz9Teuf0mfpJn7fVK3YrDz9rSA3jsLIsWgRmxta8UxqJxH6MCoyOiYH2o9WUmqavsGTfTvSvGDHUqwbzoCmrG1muMvhb4i6bFlW+oDR864J3NUd/O/VyggJtW8DJkh1qHjdwts5cYFwa9iz7d5zLZuClxNDZipZFDValIuOwxK3edurVAgMBAAECggEAW9MK+p2xFOUTjrU4zlmS2AgJWNwpj63RAUsF3Jk3aS17aZCXf977lR0Nm49Ra0rEbXjWJebKCOL427MXQVCcaFfAf/sAHYHwDkhE7nHqk0HpuiwM2kOnGYamrnahR03ha/XI/q5adQoaX0Gh5IZrvna/U7T2UK4RstS+y14PPbctrzvwi1QzbCiBjlE0GcMf4Uj6K7+b+lF7joqHuB9fNd0EdcMEEaRZ9fRSTCPZxUGlQTqLY+o6dkFew+3Ox0OgeyBSTECypdWKWk+gV2GHB62knTSfGIq/QnZj00Aoe8jwC94vm7c7RW9IwP+CCfJmF4kieIRqjFQjsww2ZaRRQQKBgQDmFiOUR9zm5JwircTA2BrVLAs/Jmg92r4+QaFeyfBuLd/4mWcsBbD7FanhBJAay56Kqzslntb/TcCYWVfGFyU0hi+TEDm0YGuD3DljFxBDJyjb3hAzUPyKijoGXKYk3yRhH9KiUnHGJ3sO4lIETxx54usWsReHsISm4ZYAFz0pJQKBgQDXBmEoHY8ZQBvafcDcH86CDirZ2zRHdL9SMi68EIkAarGNDbYrtjJMvk6l4aoT0wakYOE6KbrSEP84F5xW0X61vuKugyJKFlvz75hHKGwgghiKOl8DTDREFxiSGBUuj/LttfqWQqDF7Oq4k4E9kSGijs/jZxTiT3LSNi++cZzD8QKBgBlTqorx9iD8XSt8EUJhB2MbvAkxgxv77iEQPGEgvXSDXDoTOMYhwj+BPPfl9q7cZxFAk/wqJeRofKDIhN7rQU8sziPUD2YJjwwuu6pqqYGa1+aL5SCg84uUd5qnrCo23dxLEnaHuLplMiiLRRfwVWQdVF9lEv/+sDtmbYqJBFR5AoGAVUM3VVPbQVT1dn708ZQ/K7z4auiL42W805gIhhQ8bwjfnKH6QXz+lwXDY+2GplPAR4AO7yRK6y9INHLQUHDDwMePVUm0WBJjpee0x0qVDZLori8VK9aUxwctfAjGpW75Eh9d3SVQYQtfy47Z6ZLZ9n6QmohudIqyaf6Ikgi089ECgYB/TvwyxztEOgWY4uFU3A8yhx+J6BprMge4rJzhH5CYogsRbsh3EzBXxfQFD3lJgSzFoo4e+Mae4nynw0+FkYr68R0cGbZsZAkg7vEVAV2jTLmJ54P8z7IKUgzr2kV/lHXy+6kReMd8AyI52kkETdB8t0kJQ+OXUzoI4hhtbx3MAg==";
//    private final static String PRIVATE_KEY="MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCg0jArBtZd2kWKu1BeuZywnqRTwJ6PHeE7MhncWZ14r5t/XAzKBUG0KpIyy2r9+V7T2Hofk/asnQz08aJMXx06b3kJXeb/LOvhDxK93TGPo/09gQNyrSIfalWo2b4veHXexG3YLbJjg+K9J7I5ITBFfacrgGeNzfLVJkalaisxjVNKtRkFSQm2xaedMlRXbUTTvo1uyi9FZU6rNUfzcHBF83Y1GuDuZ6s7AY7hTHh/UZaxAEjJa5Cw3IkZKt3TWCC/DGUH8gNvHdgVvu4P6fOCM4Z8VhbkNJjWv2bCOIA8A8EPRrGvGxU/tBlZkPsuXEfXgfcXzlcOaRcI8XNkno1pAgMBAAECggEATgnw6dAlkeFrQYjn1S+Iw4QYBbRAvP4o34rOVcj+yyOb9095vUaTvZOy4gcn4hpyU6aGjHBGkTicovfmY9z71/Fj8JGqmET6KXohBBUkCanwJzpFrA4rssbszkTrLynrOLBlBTQXjobfLh7nMyXRwMbaqhdjKMK5hYlPWtGMKDy8kovF46Nd6GXjrXB5CXufkL0QEoKbIhOdOZdIryfCuhnJMUfJaJlKiv8zCxuJ/nRPbuBi/HCldPbT0XbOYWAfGAxLyevSfioNeF4LMIuB7ve8+GRpBTud3Pk+QOurHVSblMN29Z/R9kOz2E/ryTDounucdE8oAZP4MvR/X1WNAQKBgQD78En76MBXQlLmiSkMsLQElZEqYCTaJ9aXeml0gXMesSb9/OBueF/Pj+ykTegD5AqWOtfeVOltZYicKZ9faVe2jjRxn2wcuoXNhq/NS2watW1WFDSIT47gxi4pWkMaw7g9xyodqpaJm+U3o6SBLS7ud+t3xavc2aYXiBX3oDPc8QKBgQCjad8LJibES46OwZrhiCEJZ5i3cFEWCBtV05dnRLa9KPWX/eAbS2zsGoqaq78WZEM0BOHmj3ZKFNQOWy6RbR7ztlzSf7nJc9pbxyuQQK2sy7r32QbN2uKEt+G6YtbrZQKGoq39/h6z30RHeegABmNIkf44Ob80YEuWyLRPeoMX+QKBgGOzKKQO7KbbcVEX8G28M9Eom0TovUyzvUE+ySK446S+uE6E1xAAhPHv49b1mZ6IjQP8j1bFxYZsSs55zj8EwhhVWD2quC76RV8bMNEOSt6a84TABDX5PfKHmtb0iF+8GlogSfNpgZ89WU1WbhBMoCjwvfcs+6EvZIIlcYQIGt4RAoGAfBlow2TDyArBRnSNFH126Vd9SMHJMnwRlkpMDqbGSD0U1cp9KP1MyLkXTYLkaTLXPmf+zkNgx72tlQF2CgbenKJ/N3S8ONr8lvpYgQI9Yp6NbK+qVSbHI5cpm4x4PufE1U4x6FPWKS+DAOz5XRt8xp3oe/aO2E3Q2b+t/zXA3LECgYBLWxKIy6RzUKWlcwaEmF42Z6EgzAvjNDyGBvBjRCA9/E3CQOghv0WarfN8yFhV3NqAOKpV4P0fSDJbc7SkLcH91MxNoMCr3k4HDpDCcNXxWRHKcLwLC5b9jgcL45x035nR+svD/abAkuGVqnm9PoRfEJ8LEYPVE0incT9kM84cvg==";
    //传输格式
    private final static String FORMAT="json";
    //编码格式
    private final static String CHARSET="UTF-8";
    //支付宝支付公钥
    private final static String PUBLIC_KEY="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAmuh1Mk8ztGpgbTi6iUYPWRJwL29YkphzhaWnEsx1FtgevLK2+f6r6OSPyUE+MfEMpZgkoPf+vL1dx+ZSTpHHnzc776P47iZ5yCY9gsl9GU4h9Q3k5qbAmrTQRdeBZUfwxoHSJY2g6kLW+3iSRdkvC+3ofsuPrFwP7pTUBve1nMzvAjzFHtceAIrSyEVxaIBRXT2lX9hze12910H2pVSLaYclTZIPX6zwO0R96zXmrN2qLiz5ES/6cC1T9xKmGNROd/FaKFQnskX+GOMI4+U0mkatqomnt0quqtWq/LIp3l87369v9+yYxR/Gw+UrGEqF6VQwixm2v1zY+TdaZR38LQIDAQAB";
//    private final static String PUBLIC_KEY="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAoNIwKwbWXdpFirtQXrmcsJ6kU8Cejx3hOzIZ3FmdeK+bf1wMygVBtCqSMstq/fle09h6H5P2rJ0M9PGiTF8dOm95CV3m/yzr4Q8Svd0xj6P9PYEDcq0iH2pVqNm+L3h13sRt2C2yY4PivSeyOSEwRX2nK4Bnjc3y1SZGpWorMY1TSrUZBUkJtsWnnTJUV21E076NbsovRWVOqzVH83BwRfN2NRrg7merOwGO4Ux4f1GWsQBIyWuQsNyJGSrd01ggvwxlB/IDbx3YFb7uD+nzgjOGfFYW5DSY1r9mwjiAPAPBD0axrxsVP7QZWZD7LlxH14H3F85XDmkXCPFzZJ6NaQIDAQAB";
    //加密方式
    private final static String SIGN_TYPE="RSA2";

    private final static AlipayClient alipayClient=
            new DefaultAlipayClient(URL,APP_ID,PRIVATE_KEY,FORMAT,CHARSET,PUBLIC_KEY,SIGN_TYPE);

//    private final static AlipayClient alipayClient=
//            new DefaultAlipayClient(SANDBOX_URL,SANDBOX_APP_ID,SANDBOX_PRIVATE_KEY,FORMAT,CHARSET,SANDBOX_PUBLIC_KEY,SIGN_TYPE);

    private ProductMapper productMapper;
    private OrderMapper orderMapper;
    private OrderExpresswayMapper orderExpresswayMapper;
    private OrderPayMapper orderPayMapper;
    private OrderInformationMapper orderInformationMapper;
    private ShoppingMapper shoppingMapper;
    private MyOrderDetailMapper myOrderDetailMapper;

    @Autowired
    public AliPayServiceImpl(ProductMapper productMapper,
                             OrderMapper orderMapper,
                             OrderExpresswayMapper orderExpresswayMapper,
                             OrderPayMapper orderPayMapper,
                             OrderInformationMapper orderInformationMapper,
                             ShoppingMapper shoppingMapper,
                             MyOrderDetailMapper myOrderDetailMapper) {
        super();
        this.productMapper=productMapper;
        this.orderMapper=orderMapper;
        this.orderExpresswayMapper=orderExpresswayMapper;
        this.orderPayMapper=orderPayMapper;
        this.orderInformationMapper=orderInformationMapper;
        this.shoppingMapper=shoppingMapper;
        this.myOrderDetailMapper=myOrderDetailMapper;
    }

    @Override
    public String order(ReceiverInfo info, HttpServletResponse response) {
        try {
            //获取用户
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                    .getRequestAttributes())
                    .getRequest();
            HttpSession session=request.getSession();
            Integer userId=(Integer)session.getAttribute("user_id");
            if(userId==null){
                //TODO:改个异常
                throw new WrongInputException();
            }
            //校验输入
            String phone=info.getPhone();
            if(!(Checker.isChinaMobilePhone(phone)||Checker.isHomePhone(phone))){
                throw new WrongInputException();
            }
            String postalCode=info.getPostalCode();
            if(!Checker.isPostalCode(postalCode)){
                throw new WrongInputException();
            }
            //校验支付方式和配送方式是否存在
            int payWay=info.getPayWayId();
            int expressWay=info.getExpressWayId();
            OrderPay orderPay=orderPayMapper.selectByPrimaryKey(payWay);
            OrderExpressway orderExpressway=orderExpresswayMapper.selectByPrimaryKey(expressWay);
            if(orderPay==null||orderExpressway==null){
                throw new WrongInputException();
            }
            //转义处理
            String name=info.getName();
            String address=info.getAddress();
            name= HtmlUtils.htmlEscape(name);
            address=HtmlUtils.htmlEscape(address);
            //生成总订单
            Order order=new Order();
            order.setOrder_create_times(new Date());
            order.setOrder_receiver(name);
            order.setOrder_phone(phone);
            order.setOrder_address(address);
            order.setOrder_postalcode(Integer.parseInt(postalCode));
            order.setOrder_state(false);
            order.setOrder_status("待支付");
            order.setIs_need_invoices(info.isNeedInvoices());
            order.setInvoices_type(info.isCompanyInvoices());
            order.setUser_id(userId);   //TODO:改了
            orderMapper.insert(order);  //TODO:改了

            OrderInformation orderInformation=new OrderInformation();
            orderInformation.setOrder_id(order.getOrder_id());
            //orderInformation.setProduct_id(productId);
            orderInformation.setUser_id(userId);
            orderInformation.setOrder_pay_id(payWay);
            orderInformation.setOrder_expressway_id(expressWay);
            //orderInformation.setOrder_number(buyNumber);
            orderInformationMapper.insert(orderInformation);

            double totalPrice=0;
            //对购物车的order生成一个orderId
            List<Integer> shoppingIds=info.getShoppingId();
            for(Integer shoppingId:shoppingIds){
                Shopping shopping=shoppingMapper.selectByPrimaryKey(shoppingId);
                shopping.setOrder_id(order.getOrder_id());
                shopping.setIs_payed(false);
                totalPrice+=shopping.getShopping_price()*shopping.getShopping_number();
                shoppingMapper.updateByPrimaryKey(shopping);
            }
            //检查商品是否存在且余量足够，然后再进行订单子项crud操作

            Product firstProduct=null;
            List<OrderItem> items=info.getProducts();
            for(int i=0;i<items.size();i++){
                OrderItem item=items.get(i);
                int productId=item.getProductId();
                int buyNumber=item.getNumber();
                if(buyNumber<=0){
                    throw new WrongInputException();
                }
                Product product=productMapper.selectByPrimaryKey(productId);
                if(product==null||product.getProduct_number()<buyNumber){
                    throw new WrongInputException();
                }
                if(i==0){
                    firstProduct=product;
                }

                /*OrderInformation orderInformation=new OrderInformation();
                orderInformation.setOrder_id(order.getOrder_id());
                orderInformation.setProduct_id(productId);
                orderInformation.setUser_id(userId);
                orderInformation.setOrder_pay_id(payWay);
                orderInformation.setOrder_expressway_id(expressWay);
                orderInformation.setOrder_number(buyNumber);
                orderInformationMapper.insert(orderInformation);*/

                //更新商品状态
                product.setProduct_number(product.getProduct_number()-buyNumber);
                productMapper.updateByPrimaryKeySelective(product);
                //totalPrice+=product.getProduct_price()*buyNumber;

                MyOrderDetail myOrderDetail=new MyOrderDetail();
                myOrderDetail.setNumber(buyNumber);
                myOrderDetail.setOrder_id(order.getOrder_id());
                myOrderDetail.setProduct_id(productId);
                myOrderDetailMapper.insert(myOrderDetail);
            }

            String body=firstProduct.getProduct_name();
            if(items.size()>1){
                body=body+"等商品";
            }

            //double handlePrice=new BigDecimal(totalPrice).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
            double handlePrice=0.01;
            AlipayTradePagePayRequest alipayRequest=new AlipayTradePagePayRequest();
            alipayRequest.setNotifyUrl("https://www.incolor.vip/incolor1/pay/onCallAliPay"); //异步回调
            alipayRequest.setBizContent("{" +
                    "    \"out_trade_no\":\""+order.getOrder_id()+"\"," +
                    "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," +
                    "    \"total_amount\":"+totalPrice+"," +
                    "    \"subject\":\"Incolor商品购买\"," +
                    "    \"body\":\""+body+"\"," +
                    "    \"passback_params\":\"merchantBizType%3d3C%26merchantBizNo%3d2016010101111\"" +   //作用未知
                    "  }");

            //供前端查询使用
            session.setAttribute("alipay_loop_consult",order.getOrder_id());

            String form="";
            try {
                form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
            } catch (AlipayApiException e) {
                e.printStackTrace();
            }
            return form;
            /*response.setContentType("text/html;charset=" + CHARSET);
            response.getWriter().write(form);//直接将完整的表单html输出到页面
            response.getWriter().flush();
            response.getWriter().close();*/

        } catch (Exception e) {
            e.printStackTrace();
            throw new ServerInternalException();
        }

    }

    @Override
    public void notifyUrl(Map<String,String> resp) throws AlipayApiException{
        System.out.println(resp);
        boolean signVerified = AlipaySignature.rsaCheckV1(resp, PUBLIC_KEY, CHARSET, SIGN_TYPE) ;//调用SDK验证签名
        if(signVerified){
            int orderId=Integer.parseInt(resp.get("out_trade_no"));
            String tradeCode=resp.get("trade_status");
            Order order=orderMapper.selectByPrimaryKey(orderId);
            if(order.getOrder_state()){
                return;
            }
            if(tradeCode!=null&&tradeCode.equals("TRADE_SUCCESS")){
                order.setOrder_status("已支付");
                order.setOrder_state(true);
                order.setOrder_pay_time(new Date());
                //更新购物车项为已购买
                shoppingMapper.pay(orderId);
                /*ShoppingExample example=new ShoppingExample();
                example.createCriteria().andOrder_idEqualTo(orderId);
                List<Shopping> shoppings=shoppingMapper.selectByExample(example);
                for(Shopping shopping:shoppings){
                    shopping.setIs_payed(true);
                    shoppingMapper.updateByPrimaryKey(shopping);
                }*/
                orderMapper.updateByPrimaryKeySelective(order);
            }else if(tradeCode!=null&&tradeCode.equals("TRADE_CLOSED")){
                //回滚库存
                rollBack(orderId);
            }
        }else{
            throw new SignatrueFailException();
        }
    }

    private void rollBack(int orderId){
        OrderInformationExample example=new OrderInformationExample();
        example.createCriteria().andOrder_idEqualTo(orderId);
        List<OrderInformation> information=orderInformationMapper.selectByExample(example);
        for(int i=0;i<information.size();i++){
            int productId=information.get(i).getProduct_id();
            int number=information.get(i).getOrder_number();
            Product product=productMapper.selectByPrimaryKey(productId);
            product.setProduct_number(product.getProduct_number()+number);
            productMapper.updateByPrimaryKeySelective(product);
        }
    }

    @Override
    public void consultPayStatus(HttpSession session) {
        //前端查询支付状态
        Integer orderId=(Integer)session.getAttribute("alipay_loop_consult");
        if(orderId!=null){
            //查询数据库订单支付状态
            Order order=orderMapper.selectByPrimaryKey(orderId);
            if(order==null){
                //订单不存在
                //TODO:换个异常
                throw new ServerInternalException();
            }
            boolean state=order.getOrder_state();
            if(!state){
                //未支付抛出未支付异常
                throw new NotPayException();
            }
            //已支付什么都不做，由Controller完成操作
        }else{
            //未成功发起支付
            //TODO:换个异常
            throw new ServerInternalException();
        }
    }
}
