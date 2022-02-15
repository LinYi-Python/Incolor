package vip.incolor;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author JimLin
 * @email leafyunjim@gmail.com
 * @description springboot 启动类
 * @date 2018-03-18
 * @time 14:26
 */
@SpringBootApplication
// mapper 接口类扫描包配置
@MapperScan("vip.incolor.mapper")
@EnableScheduling
public class IncolorApplication {

    public static void main(String[] args) {
        SpringApplication.run(IncolorApplication.class, args);
    }
}
