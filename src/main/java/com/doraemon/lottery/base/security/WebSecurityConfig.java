package com.doraemon.lottery.base.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Security 核心配置类
 */
@Configuration
/**
 * 启用Spring Security的Web安全支持，并提供Spring MVC集成。扩展WebSecurityConfigurerAdapter，并覆盖了一些方法来设置Web安全配置的一些细节
 */
@EnableWebSecurity
/**
 * EnableGlobalMethodSecurity 用于判断用户对某个控制层的方法是否具有访问权限
 * @PreAuthorize("hasRole('admin')")
 */
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyUserDetailService myUserDetailService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/addUser").permitAll() // 允许post请求/add-user，而无需认证
                .anyRequest().authenticated() // 所有请求都需要验证
                .and()
                .formLogin() // 使用默认的登录页面
                .and()
                .csrf().disable();// post请求要关闭csrf验证,不然访问报错；实际开发中开启，需要前端配合传递其他参数
    }

    /**
     * 指定加密方式
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        // 使用BCrypt加密密码
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                // 从数据库读取的用户进行身份认证
                .userDetailsService(myUserDetailService)
                .passwordEncoder(passwordEncoder());
    }
}