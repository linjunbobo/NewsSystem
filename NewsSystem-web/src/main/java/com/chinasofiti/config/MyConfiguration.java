package com.chinasofiti.config;

import java.util.Properties;

import javax.sql.DataSource;

import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.github.pagehelper.PageInterceptor;
import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
public class MyConfiguration {
    @Bean
    public PageHelper pageHelper() {
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum", "true");
        properties.setProperty("rowBoundsWithCount", "true");
        properties.setProperty("reasonable", "true");
        properties.setProperty("dialect","mysql");
        pageHelper.setProperties(properties);
        return pageHelper;
    }
	
//	/** 定义创建Session工厂Bean的方法 */
//	@Bean
//	public SqlSessionFactoryBean sqlSessionFactoryBean() throws Exception {
//		//定义MyBatis的Session工厂对象，用于产生MyBatis全局的会话工厂
//	    SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//	    //设置数据源
//	    sqlSessionFactoryBean.setDataSource(getDataSource());
//	    // 分页拦截器的配置信息
//	    Properties properties = new Properties();
//	    properties.setProperty("reasonable", "true");
//	    properties.setProperty("supportMethodsArguments", "true");
//	    properties.setProperty("pageSizeZero", "true");
//	    //创建分页拦截器
//	    PageInterceptor interceptor = new PageInterceptor();
//	    interceptor.setProperties(properties);
//	    //添加分页拦截器
//	    sqlSessionFactoryBean.setPlugins(new Interceptor[]{interceptor});
//	    return sqlSessionFactoryBean;
//	}
//
//	// 配置Shiro 配置安全管理器。
//
//	@Bean(name = "securityManager")
//	public DefaultWebSecurityManager securityManager() {
//		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//		return securityManager;
//	}
//
//	// 配置Shiro 配置安全管理器。
//
//	@Bean
//	public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
//		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
//		shiroFilterFactoryBean.setSecurityManager(securityManager);
//		return shiroFilterFactoryBean;
//	}
	 
	
	
	
	

}
