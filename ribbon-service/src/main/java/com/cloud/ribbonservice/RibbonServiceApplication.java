package com.cloud.ribbonservice;

import com.cloud.ribbonservice.anno.ExcludeFromComponentScan;
import com.cloud.ribbonservice.config.CustomConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

//测试ribbon  默认eureka引入了ribbon 所以不需要引入其他依赖
//需要先启动eureka-server、product-service服务

@SpringBootApplication
//用了这种方式 配置文件中的可以注释
@RibbonClient(name = "product-service",configuration = CustomConfiguration.class)
@ComponentScan(excludeFilters = { @ComponentScan.Filter(type = FilterType.ANNOTATION,value = ExcludeFromComponentScan.class)})
public class RibbonServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RibbonServiceApplication.class, args);
    }

}
