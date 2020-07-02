package com.cloud.hystrixservice.controller;

import com.cloud.hystrixservice.service.ProductService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hystrix")
public class ProductHystrixController {

    @Autowired
    ProductService productService;

    @GetMapping("test/{id}")
    public Object findOne(@PathVariable int id){
        return productService.getOne(id);
    }

}
