package com.doraemon.lottery.base.security;

import com.doraemon.lottery.base.jwt.JWTAuthenticationEntryPoint;
import com.doraemon.lottery.base.jwt.JWTAuthenticationFilter;
import com.doraemon.lottery.base.jwt.JWTAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
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
        // 跨域共享
        http.cors()
                .and()
                // 跨域伪造请求限制无效
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/addUser").permitAll()
                .antMatchers("/redis").permitAll()
                .anyRequest().authenticated()
                .and()
                // 添加JWT登录拦截器
                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
                // 添加JWT鉴权拦截器
                .addFilter(new JWTAuthorizationFilter(authenticationManager()))
                .sessionManagement()
                // 设置Session的创建策略为：Spring Security永不创建HttpSession 不使用HttpSession来获取SecurityContext
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                // 异常处理
                .exceptionHandling()
                // 匿名用户访问无权限资源时的异常
                .authenticationEntryPoint(new JWTAuthenticationEntryPoint());

//        http
//                .authorizeRequests()
//                .antMatchers(HttpMethod.POST, "/addUser").permitAll() // 允许post请求/add-user，而无需认证
//                .anyRequest().authenticated() // 所有请求都需要验证
//                .and()
//                .formLogin() // 使用默认的登录页面
//                .and()
//                .csrf().disable();// post请求要关闭csrf验证,不然访问报错；实际开发中开启，需要前端配合传递其他参数

//        // 跨域共享
//        http.cors()
//                .and()
//                // 跨域伪造请求限制无效
//                .csrf().disable()
//                .authorizeRequests()
//                // 访问/data需要ADMIN角色
//                .antMatchers("/user").hasRole("ADMIN")
//                // 其余资源任何人都可访问
//                .anyRequest().permitAll()
//                .and()
//                // 添加JWT登录拦截器
//                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
//                // 添加JWT鉴权拦截器
//                .addFilter(new JWTAuthorizationFilter(authenticationManager()))
//                .sessionManagement()
//                // 设置Session的创建策略为：Spring Security永不创建HttpSession 不使用HttpSession来获取SecurityContext
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                // 异常处理
//                .exceptionHandling()
//                // 匿名用户访问无权限资源时的异常
//                .authenticationEntryPoint(new JWTAuthenticationEntryPoint());

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