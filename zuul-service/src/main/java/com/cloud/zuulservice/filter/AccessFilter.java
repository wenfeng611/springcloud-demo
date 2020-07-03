package com.cloud.zuulservice.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import javax.servlet.http.HttpServletRequest;

public class AccessFilter extends ZuulFilter {
    @Override
    public String filterType() {
//        pre：可以在请求被路由之前调用
//        route：在路由请求时候被调用
//        post：在route和error过滤器之后被调用
//        error：处理请求时发生错误时被调用
        return "pre";   // 前置过滤器
    }

    @Override
    public int filterOrder() {
        return 0;       // 优先级为0，数字越大，优先级越低
    }

    @Override
    public boolean shouldFilter() {
        return true;    // 是否执行该过滤器，此处为true，说明需要过滤
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        System.out.println(String.format("%s AccessFilter request to %s", request.getMethod(), request.getRequestURL().toString()));

        //校验等等操作 例如token校验
        //....

//            通过的
            ctx.setSendZuulResponse(true);// 对该请求进行路由
            ctx.setResponseStatusCode(200);
            ctx.set("isSuccess", true);// 设值，让下一个Filter看到上一个Filter的状态  ctx.get(key) 取到
            return null;

//             失败的 不通过
//            ctx.setSendZuulResponse(false);// 过滤该请求，不对其进行路由
//            ctx.setResponseStatusCode(401);// 返回错误码
//            ctx.setResponseBody("{\"result\":\"error!\"}");// 返回错误内容
//            ctx.set("isSuccess", false);
//            return null;

    }
}
