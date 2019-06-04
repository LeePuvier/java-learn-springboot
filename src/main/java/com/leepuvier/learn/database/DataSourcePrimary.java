package com.leepuvier.learn.database;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DataSourcePrimary {


        @Bean("primaryDataSource")
        @Qualifier( "primaryDataSource" )
        @ConfigurationProperties(prefix = "spring.datasource.primary")
        public DataSource primaryDataSource(){ return DataSourceBuilder.create().build(); }


        @Bean(name = "jdbcTemplatePrimary")
        public JdbcTemplate jdbcTemplatePrimary(@Qualifier( "primaryDataSource" ) DataSource dataSource){
            return new JdbcTemplate(dataSource);
    }
}
