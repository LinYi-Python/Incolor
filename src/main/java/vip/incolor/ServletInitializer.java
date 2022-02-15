package vip.incolor;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @author JimLin
 * @email leafyunjim@gmail.com
 * @description
 * @date 2018-03-18
 * @time 14:26
 */
public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(IncolorApplication.class);
    }

}