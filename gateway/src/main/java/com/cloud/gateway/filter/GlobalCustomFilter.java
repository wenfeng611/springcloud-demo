package com.cloud.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class GlobalCustomFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("do global filter...");
        //token验证
        String token = exchange.getRequest().getQueryParams().getFirst("token");
        if(token == null){
            //认证失败
            System.out.println("验证失败");
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();  //结束
        }
        //成功放行
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;  //返回值越小 优先级越高
    }
}
