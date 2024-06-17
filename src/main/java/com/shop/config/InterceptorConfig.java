package com.shop.config;

import com.shop.interceptor.AdminInterceptor;
import com.shop.interceptor.ClientLoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class InterceptorConfig implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new ClientLoginInterceptor())
                .addPathPatterns("/user_center/**")
                .addPathPatterns("/cart/**")
                .addPathPatterns("/order/submit");

        registry.addInterceptor(new AdminInterceptor())
                .addPathPatterns("/user/**").excludePathPatterns(new String[]{"/user/login","/user/register"})
                .addPathPatterns("/order/**").excludePathPatterns("/order/submit")
                .addPathPatterns("/category/**")
                .addPathPatterns("/upload/game_image")
                .addPathPatterns("/game/**");
    }
}
