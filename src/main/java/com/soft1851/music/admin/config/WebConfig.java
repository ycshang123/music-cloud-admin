package com.soft1851.music.admin.config;

import com.soft1851.music.admin.interceptor.JwtInterceptor;
import com.soft1851.music.admin.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/***
 * 注册拦截器等web配置
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Resource
    private LoginInterceptor interceptor;
    @Resource
    private JwtInterceptor jwtInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截路径可自行配置多个 可用，可隔开
        registry.addInterceptor(interceptor).addPathPatterns("/sysAdmin/login").excludePathPatterns("/**");
        registry.addInterceptor(jwtInterceptor).addPathPatterns("/**").excludePathPatterns("/sysAdmin/login", "/captcha").excludePathPatterns("/static/**");


    }
}

