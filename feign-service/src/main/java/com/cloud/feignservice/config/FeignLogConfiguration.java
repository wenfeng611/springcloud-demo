package com.cloud.feignservice.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignLogConfiguration {

//  Feign的Looger级别有下面4类
//  1 None:不记录任何信息
//  2 BASIC:仅记录请求方法,URL,响应状态码和执行时间
//  3 HEADERS:除了记录BASIC级别的信息之外,还会记录头信息
//  4 FULL:记录请求和相应的所有明细

  @Bean
  Logger.Level feignLoggerLevel() {
    return Logger.Level.FULL;
  }
}