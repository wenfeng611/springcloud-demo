package com.cloud.hystrixservice.service;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getOneFallback")
    public Object getOne(int id){
        Object o = restTemplate.getForObject("http://product-service/product/"+id,Object.class);
        return o;
    }

    // 此时方法的参数和 getOne() 一致
    public Object getOneFallback(int id){
        return "findOneFallback";
    }
}
