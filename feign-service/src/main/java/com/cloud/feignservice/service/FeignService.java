package com.cloud.feignservice.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * 在当前服务调用product-service服务
 */

//@FeignClient(name = "service-hi", configuration=CustomConfig.class)//自定义配置的类 参考ribbon-service中自定义配置
@FeignClient(name = "product-service")
public interface FeignService {

    @RequestMapping(value = "/product/{id}",method = RequestMethod.GET)  //不能用GetMapping
    Object findById(@PathVariable(value = "id") int id); //(value = "id")要写 springmvc默认用参数名作为value feign不会
                                                         //当参数是复杂对象时即使用的是GET方法 feign默认会用post发送请求
}
