package com.atguigu.admin.config;

import com.atguigu.admin.interceptor.LoginInterceptor;
import com.atguigu.admin.interceptor.RedisUrlCountInterceptor;
import com.baomidou.mybatisplus.extension.api.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * @EnableWebMvc：全面接管
 * @author lq
 * @create 2021-07-09-17:22
 */
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {

    /**
     * Filter、Interceptor几乎拥有相同的功能？
     * 1.Filter是Servlet定义的原生组件。好处，脱离Spring应用也能使用
     * 2.Interceptor是Spring定义的接口，可以使用自动注入
     */
    @Autowired
    RedisUrlCountInterceptor redisUrlCountInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginInterceptor())
//                .addPathPatterns("/**")   //静态所有请求都会拦截
//                .excludePathPatterns("/","/login","/level1/**","/css/**","/fonts/**","/images/**","/js/**","/aa/**");
        registry.addInterceptor(redisUrlCountInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**","/aa/**");
    }

//    @Bean  //修改HandlerMapping.HandlerAdapter ExceptionHandlerExceptionResolver 太底层
//    public WebMvcRegistrations webMvcRegistrations(){
//        return new WebMvcRegistrations() {
//            @Override
//            public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
//                return null;
//            }
//        };
//    }
}
