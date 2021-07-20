package com.atguigu.admin.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author lq
 * @create 2021-07-18-9:20
 */
@EnableWebSecurity  //开启WebSecurity模式
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //授权
    //链式编程
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //首页所有人可以访问，功能页只有对应有权限的人才能访问
        //请求授权的规则~
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/editable_table").hasRole("vip1")
                .antMatchers("/responsive_table").hasRole("vip2")
                .antMatchers("/dynamic_table").hasRole("vip3");
        //没有权限默认会到登录页面
        http.formLogin().loginPage("/toLogin");
    }

    //认证
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //这些数据正常应该从数据库中读
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("lq").password(new BCryptPasswordEncoder().encode("123456")).roles("vip2","vip3")
                .and()
                .withUser("root").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1","vip2","vip3")
                .and()
                .withUser("guest").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1");
    }
}
