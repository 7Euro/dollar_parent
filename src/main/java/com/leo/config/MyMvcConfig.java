package com.leo.config;

import com.leo.component.LoginHandlerInterceptor;
import com.leo.component.MylocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Leo
 * 使用WebMvcConfigurer可以来扩展SpringMvc的功能
 * @EnableWebMvc 不要接管SpringMvc
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //浏览器发送hahaha请求也来到success页面
        registry.addViewController("/hahaha").setViewName("success");
    }
    /**
     * 所有WebMvcConfigurerAdapter组件都会一起起作用
     */
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer adapter = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }
            //注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //springBoot已经做好了静态资源映射
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")//拦截
                        .excludePathPatterns("/index.html","/","/user/login");//放行
            }
        };
        return adapter;
    }

    @Bean
    public MylocaleResolver localeResolver(){
        return new MylocaleResolver();
    }
}
