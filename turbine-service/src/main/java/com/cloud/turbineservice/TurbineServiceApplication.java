package com.cloud.turbineservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

//http://localhost:9601/turbine.stream 可以看到对当前服务监控的stream
//把这个url填到hystrix dashboard（启动dashboard服务 9501端口） http://localhost:9501/hystrix

//对集群的监控
@EnableTurbine
@EnableDiscoveryClient
@SpringBootApplication
public class TurbineServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TurbineServiceApplication.class, args);
    }

}
