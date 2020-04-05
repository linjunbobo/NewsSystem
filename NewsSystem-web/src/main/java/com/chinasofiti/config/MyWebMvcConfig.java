package com.chinasofiti.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author  跨域
 * @time 2019.08.22
 */
@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {

    private  String filePath;


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        //上传照片缩略图url地址
        registry.addResourceHandler("/pic/**").addResourceLocations("file:"+"D:\\pic/");
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }


}
