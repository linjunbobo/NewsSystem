package com.chinasofiti.Beans;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties()
@Data
public class applicationBean {
    private String springdatasourcedriverClass ;
    private String jdbcUrl ;
    private String user ;
    private String password ;
}
