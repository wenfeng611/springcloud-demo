package com.cloud.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("config")
//加了这个注解 当git里面配置文件发生变化后需要 手动发送 post 请求 http://localhost:9901/actuator/refresh 刷新配置  然后再次请求下面的接口就会是最新的了
@RefreshScope
public class TestConfigController {

    @Value("${name}")
    private String name;

    @GetMapping("/getName")
    public String test() {
        return name;
    }
}
