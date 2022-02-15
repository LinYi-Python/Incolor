package vip.incolor.fillter;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @version V1.0.0
 * 解决跨域问题
 */
@Component
public class CorsFilter implements Filter {

    /**
     * json web token 在请求头的名字
     */
   // private String tokenHeader = "X_Auth_Token";

    /**
     * 解决跨域的核心部分， copy 的，还未研究原理
     *
     * @param req
     * @param res
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest request = (HttpServletRequest) req;
        String token = request.getHeader("X_Auth_Token");
        System.out.println(token + "token");
        String Origin = request.getHeader("Origin");
        System.out.println("Origin:" + Origin);
        //System.out.println("tokenHeader:" + this.tokenHeader);
        Logger logger = Logger.getLogger(this.getClass());
        logger.info("Origin:  " + Origin);
        response.setHeader("Access-Control-Allow-Origin", Origin);
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, " );
        response.setHeader("Access-Control-Allow-Credentials", "true");
        chain.doFilter(req, res);
    }

    public void init(FilterConfig filterConfig) {
    }

    public void destroy() {
    }


}
