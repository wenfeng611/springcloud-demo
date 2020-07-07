package com.cloud.auth2server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/*
主要的接口
    POST /oauth/authorize  授权码模式认证授权接口
    GET/POST /oauth/token  获取 token 的接口
    POST  /oauth/check_token  检查 token 合法性接口
 */

@SpringBootApplication
public class Auth2ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Auth2ServerApplication.class, args);
    }

}
