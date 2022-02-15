package vip.incolor.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import vip.incolor.exception.AccessException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: JimLin
 * @description: 用户登录拦截器
 * @email leafyunjim@gmail.com
 * @date: 2018-04-12
 * @time: 14:53
 */
public class AuthInterceptor implements HandlerInterceptor {

    /**
     * 该方法在目标方法之前被调用.
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        // 如果 Session 过期
        if (httpServletRequest.getSession().getAttribute("user_id") != null
                || httpServletRequest.getSession().getAttribute("manager") != null) {
            System.out.println("Session is active!");
            return true;
        } else {
            System.out.println("hhh");
            System.out.println(httpServletRequest.getSession(false) == null);
            // 抛出访问异常
            throw new AccessException();
        }

    }

    /**
     * 调用目标方法之后, 但渲染视图之前.
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 渲染视图之后被调用. 释放资源
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }


}
