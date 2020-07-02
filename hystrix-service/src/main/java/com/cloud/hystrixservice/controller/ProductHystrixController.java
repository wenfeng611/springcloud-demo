package com.cloud.hystrixservice.controller;

import com.cloud.hystrixservice.service.ProductService;
import com.cloud.hystrixservice.strategy.ProductThreadStrategyService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hystrix")
public class ProductHystrixController {

    private Logger logger = LoggerFactory.getLogger(ProductHystrixController.class);

    @Autowired
    ProductService productService;

    @Autowired
    ProductThreadStrategyService productThreadStrategyService;

    @GetMapping("test/{id}")
    public Object findOne(@PathVariable int id){
        return productService.getOne(id);
    }

    //线程池隔离 会有不同的线程去执行  包括fallback也是不同的线程执行
    @GetMapping("test/thread/{id}")
    public Object findOnethread(@PathVariable int id){
        logger.info("ProductHystrixController thread name: {}",Thread.currentThread().getName());
        return productThreadStrategyService.findOne(id);
    }
}
