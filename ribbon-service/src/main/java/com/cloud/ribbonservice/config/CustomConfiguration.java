package com.cloud.ribbonservice.config;

import com.cloud.ribbonservice.anno.ExcludeFromComponentScan;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

//可以自定义负载策略


@ExcludeFromComponentScan  //加这个注解不让被扫描到  不然的话会对所有的服务都生效  这里只需要对product-service一个服务的请求生效
@Configuration
public class CustomConfiguration {

    @Autowired
    IClientConfig config;

    public IRule ribbonRule(IClientConfig iClientConfig){
        //可以自定义规则
        return new RandomRule();
    }
}
