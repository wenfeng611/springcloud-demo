package com.cloud.feignservice.service.fallback;

import com.cloud.feignservice.service.FeignServiceWithFallBackService;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceFallBack implements FeignServiceWithFallBackService {

    @Override
    public Object findById(int id) {
        return "fallback method";
    }
}