package com.dongdong.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * durid管理界面和过滤器配置
 */
@Configuration
public class DruidConfig {

    @Bean(name = "druidStatView")
    public ServletRegistrationBean druidStatView() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        //IP白名单 (没有配置或者为空，则允许所有访问)
        registrationBean.addInitParameter("allow", "");
        //IP黑名单 (存在共同时，deny优先于allow)
        registrationBean.addInitParameter("deny", "");
        registrationBean.addInitParameter("loginUsername", "admin");
        registrationBean.addInitParameter("loginPassword", "admin");
        registrationBean.addInitParameter("resetEnable", "false");
        return registrationBean;
    }

    @Bean(name = "druidWebStatFilter")
    public FilterRegistrationBean druidWebStatFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(new WebStatFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*");
        return registrationBean;
    }
}
