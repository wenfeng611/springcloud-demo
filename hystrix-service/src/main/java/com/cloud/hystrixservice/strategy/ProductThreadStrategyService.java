package com.cloud.hystrixservice.strategy;

import com.cloud.hystrixservice.service.ProductService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductThreadStrategyService {

    private Logger logger = LoggerFactory.getLogger(ProductThreadStrategyService.class);

    @Autowired
    private RestTemplate restTemplate;

    //groupKey 默认使用类名
    @HystrixCommand(groupKey = "ProductThreadStrategyService",commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "100"),//指定多久超时，单位毫秒。超时进fallback
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),//判断熔断的最少请求数，默认是10；只有在一个统计窗口内处理的请求数量达到这个阈值，才会进行熔断与否的判断
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "10"),//判断熔断的阈值，默认值50，表示在一个统计窗口内有50%的请求处理失败，会触发熔断
            },
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "30"),
                    @HystrixProperty(name = "maxQueueSize", value = "101"),
                    @HystrixProperty(name = "keepAliveTimeMinutes", value = "2"),
                    @HystrixProperty(name = "queueSizeRejectionThreshold", value = "15"),
                    @HystrixProperty(name = "metrics.rollingStats.numBuckets", value = "12"),
                    @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "1440")
            },fallbackMethod = "findOneFallback")
    public Object findOne(int id){
        logger.info("findOne current thread name: {}",Thread.currentThread().getName());
        Object o = restTemplate.getForObject("http://product-service/product/"+id,Object.class);
        return o;
    }

    public Object findOneFallback(int id){
        logger.info("findOne fallback: {}",Thread.currentThread().getName());
        return null;
    }
}
