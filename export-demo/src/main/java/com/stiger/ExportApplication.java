package com.stiger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Auther: zheng.yuan
 * @Date: 2019/6/22 14:57
 * @Description:
 */
//@ComponentScan
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ExportApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExportApplication.class, args);
    }
}
