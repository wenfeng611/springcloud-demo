package com.cloud.productservice.controller;

import com.cloud.productservice.entity.Apple;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
public class ProductController {

    @GetMapping("{id}")
    public Apple findById(@PathVariable int id){
        System.out.println("findById: "+id);
        return new Apple(id,"red","苹果",1.0);
    }
}
