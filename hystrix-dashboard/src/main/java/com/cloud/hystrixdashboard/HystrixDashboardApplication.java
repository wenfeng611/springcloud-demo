package com.cloud.hystrixdashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;


//需要先启动 hystrix-service 9401端口 因为hystrix-service有hystrix 可以被监控
//http://localhost:9401/actuator/hystrix.stream 可以看到信息

//dashoard中输入http://localhost:9401/actuator/hystrix.stream可以看到图标

//http://localhost:9501/hystrix进入监控首页
@EnableHystrixDashboard
@EnableDiscoveryClient
@SpringBootApplication
public class HystrixDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardApplication.class, args);
    }

}
