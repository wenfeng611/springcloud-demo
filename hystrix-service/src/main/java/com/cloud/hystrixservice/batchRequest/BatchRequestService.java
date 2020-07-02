package com.cloud.hystrixservice.batchRequest;

import com.google.common.collect.Lists;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Future;

@Service
public class BatchRequestService {

    //适用高并发场景
    //默认合并是100毫秒 或者到达了200个request 会合并发起
    //@HystrixCollapser 为其创建了合并请求器
    //scope 是合并求情的域  全局 单个request域
    @HystrixCollapser(batchMethod = "saveAll", scope = com.netflix.hystrix.HystrixCollapser.Scope.GLOBAL, collapserProperties = {
            @HystrixProperty(name="timerDelayInMilliseconds", value = "100"),
            @HystrixProperty(name = "maxRequestsInBatch" ,value = "200")
    })
    public Future<Object> save(Object accessLogCount) {
        return null;
    }

    @HystrixCommand(fallbackMethod = "myFallback")
    public List<Object> saveAll(List<Object> accessLogCounts) {
        //saveAll操作。。。
        return Lists.newArrayList();
    }

    private List<Object> myFallback(List<Object> accessLogCounts, Throwable e) {
        return null;
    }
}