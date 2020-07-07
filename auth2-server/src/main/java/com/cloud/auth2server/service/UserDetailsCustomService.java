package com.cloud.auth2server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;


//自定义的用户验证接口
@Service
public class UserDetailsCustomService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        if(!s.equals("admin")) throw new UsernameNotFoundException("用户名不存在");
        //....数据库中查找
        return new User("admin",passwordEncoder.encode("123456"), Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN")));
    }
}
