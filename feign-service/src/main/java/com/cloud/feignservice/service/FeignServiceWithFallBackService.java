package com.cloud.feignservice.service;


import com.cloud.feignservice.config.FeignLogConfiguration;
import com.cloud.feignservice.service.fallback.ProductFallbackFactory;
import com.cloud.feignservice.service.fallback.ProductServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//带有降级方法的FeignClient

//configuration = FeignLogConfiguration.class 引用该日志配置
//@FeignClient(name = "product-service",fallback = ProductServiceFallBack.class,configuration = FeignLogConfiguration.class)  fallbackmethods

@FeignClient(name = "product-service",fallbackFactory = ProductFallbackFactory.class,configuration = FeignLogConfiguration.class)
public interface FeignServiceWithFallBackService {

    @RequestMapping(value = "/product/{id}",method = RequestMethod.GET)  //不能用GetMapping
    Object findById(@PathVariable(value = "id") int id);
}


