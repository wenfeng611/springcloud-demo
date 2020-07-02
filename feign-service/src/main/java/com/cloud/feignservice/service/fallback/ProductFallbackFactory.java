package com.cloud.feignservice.service.fallback;

import com.cloud.feignservice.service.FeignServiceWithFallBackService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class ProductFallbackFactory implements FallbackFactory<FeignServiceWithFallBackService> {
    @Override
    public FeignServiceWithFallBackService create(Throwable throwable) {
        return new FeignServiceWithFallBackService(){

            @Override
            public Object findById(int id) {
                return "ProductFallbackFactory fallback method";
            }
        };
    }
}
