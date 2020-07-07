package com.cloud.auth2server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/*
主要的接口
    POST /oauth/authorize  授权码模式认证授权接口
    GET/POST /oauth/token  获取 token 的接口
    POST  /oauth/check_token  检查 token 合法性接口
 */

@RestController
@EnableResourceServer
@SpringBootApplication
public class Auth2ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Auth2ServerApplication.class, args);
    }

    Logger logger = LoggerFactory.getLogger(Auth2ServerApplication.class);

    @RequestMapping(value = "user/current", method = RequestMethod.GET)
    public Principal getUser(Principal principal) {
        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>");
        logger.info(principal.toString());
        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>");
        return principal;
    }
}
