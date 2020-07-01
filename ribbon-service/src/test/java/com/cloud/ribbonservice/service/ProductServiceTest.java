package com.cloud.ribbonservice.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductServiceTest {

    @Autowired
    ProductService productService;

    @Test
    public void geOne() {
        for (int i = 0; i < 10 ; i++) {
            System.out.println("test..." + i);
            Object o = productService.geOne(i);
            System.out.println("result: "+o);
        }
    }
}
