package com.cloud.feignservice.controller;

import com.cloud.feignservice.service.FeignService;
import com.cloud.feignservice.service.FeignServiceWithFallBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("feign")
public class ProductFeignClientController {

//    @Autowired
//    FeignService feignService;

//    @RequestMapping(value = "/product/{id}",method = RequestMethod.GET)
//    public Object findOne(@PathVariable int id){
//        return feignService.findById(id);
//    }

    @Autowired
    FeignServiceWithFallBackService feignServiceWithFallBackService;

    @RequestMapping(value = "/product/fallback/{id}",method = RequestMethod.GET)
    public Object fallback(@PathVariable int id){
        return feignServiceWithFallBackService.findById(id);
    }
}
