package vip.incolor.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import vip.incolor.interceptor.AuthInterceptor;

/**
 * 定义拦截器链初始化
 *
 * @author JimLin
 * @version V1.0.0
 * @date 2017/9/19
 * Email:lzhabc@163.com
 */

@Configuration
public class WebConfigurer extends WebMvcConfigurerAdapter {

    /**
     * 初始化拦截器链
     *
     * @param registry
     */
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        // 多个拦截器组成一个拦截器链
//        // addPathPatterns 用于添加拦截规则
//        registry.addInterceptor(new AuthInterceptor())
//                .excludePathPatterns("/register/**")
//                .excludePathPatterns("/login/**/**")
//                .excludePathPatterns("/user/sign/up")
//                .excludePathPatterns("/classify/get/**")
//                .excludePathPatterns("/classify/index/search")
//                .excludePathPatterns("/product/get/**")
//                .excludePathPatterns("/article/get/**")
//                .excludePathPatterns("/carousel/get/all")
//                .excludePathPatterns("/carousel/triangle/get/all")
//                .addPathPatterns("/**");
////        registry.addInterceptor(new AuthInterceptor())
////                .excludePathPatterns("/**");
//        super.addInterceptors(registry);
//    }
}
