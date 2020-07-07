package com.cloud.auth2server.config;

import com.cloud.auth2server.service.UserDetailsCustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

@Configuration
@EnableAuthorizationServer
public class OAuth2ServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    public PasswordEncoder passwordEncoder;

    @Autowired
    public UserDetailsCustomService kiteUserDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.allowFormAuthenticationForClients();            //允许客户端访问 OAuth2 授权接口，否则请求 token 会返回 401
        security.checkTokenAccess("permitAll()");          //允许已授权用户访问 checkToken 接口
        security.tokenKeyAccess("permitAll()");            //允许已授权用户访问 获取 token 接口
    }

    /*  client的配置
        ClientId、Client-Secret：这两个参数对应请求端定义的 cleint-id 和 client-secret

        authorization_code：授权码类型。
        implicit：隐式授权类型。
        password：资源所有者（即用户）密码类型。
        client_credentials：客户端凭据（客户端ID以及Key）类型。
        refresh_token：通过以上授权获得的刷新令牌来获取新的令牌。

        accessTokenValiditySeconds：token 的有效期

        scopes：用来限制客户端访问的权限，在换取的 token 的时候会带上 scope 参数，只有在 scopes 定义内的，才可以正常换取 token。
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()   //正式生产要持久化到数据库
                .withClient("product-client")
                .secret(passwordEncoder.encode("product-client-secret"))
                .authorizedGrantTypes("refresh_token", "password")
                .accessTokenValiditySeconds(3600)
                .scopes("all");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

        endpoints.authenticationManager(authenticationManager)
                .userDetailsService(kiteUserDetailsService);   //存在内存中  也可以存在redis 或者 数据库中
    }
}
