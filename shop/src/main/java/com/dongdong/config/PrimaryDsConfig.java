package com.dongdong.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import java.io.IOException;
import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@MapperScan(basePackages = "com.dongdong.mapper", sqlSessionTemplateRef = "sqlSessionTemplatePrimary")
public class PrimaryDsConfig {

    private static final Logger LOG = LoggerFactory.getLogger(PrimaryDsConfig.class);

    /**
     * 数据源配置
     */
    @Primary
    @Bean(name = "dataSourcePrimary")
    @ConfigurationProperties("spring.datasource.druid.one")
    public DataSource dataSourceOne() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "sqlSessionFactoryPrimary")
    @Primary
    public SqlSessionFactoryBean sqlSessionFactoryPrimary(@Qualifier("dataSourcePrimary") DataSource dataSource) throws IOException {
        LOG.info("load Primary sql sesion factory");
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        bean.setMapperLocations(resolver.getResources("classpath*:mapper/*Mapper.xml"));
        return bean;
    }

    @Bean(name = "sqlSessionTemplatePrimary")
    @Primary
    public SqlSessionTemplate sqlSessionTemplatePrimary(@Qualifier("sqlSessionFactoryPrimary") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean(name = {"transactionManagerPrimary", "primary"})
    @Primary
    public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier("dataSourcePrimary") DataSource dataSource) {
        LOG.info("init Lifec transaction");
        return new DataSourceTransactionManager(dataSource);
    }
}
