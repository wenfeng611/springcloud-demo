package com.cloud.ribbonservice.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

//用于调用 product-service 的服务
@Service
public class ProductService {

    @Autowired
    private RestTemplate restTemplate;

    public Object geOne(int id){
        Object result = restTemplate.getForObject("http://product-service/product/"+id,Object.class);
        return result;
    }
}
