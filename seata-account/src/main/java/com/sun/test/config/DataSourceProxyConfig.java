package com.sun.test.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DataSourceProxyConfig {

    @Bean(name = "accountDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.hikari.account")
    public DataSource accountDataSource() {
        return new HikariDataSource();
    }


    @Bean(name = "accountJdbcTemplate")
    @Primary
    public JdbcTemplate accountJdbcTemplate(@Qualifier("accountDataSource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "storageDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.hikari.storage")
    public DataSource storageDataSource() {
        return new HikariDataSource();
    }


    @Bean(name = "storageJdbcTemplate")
    public JdbcTemplate storageJdbcTemplate(@Qualifier("storageDataSource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
