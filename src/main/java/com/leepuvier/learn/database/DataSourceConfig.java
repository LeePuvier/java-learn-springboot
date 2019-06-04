package com.leepuvier.learn.database;

import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {


//    @Bean("testDataSource")
//    @Qualifier( "testDataSource" )
//    @ConfigurationProperties(prefix = "spring.datasource.primary")
//    public DataSource testDataSource(){ return DataSourceBuilder.create().build(); }
//
//
//    @Bean("devDataSource")
//    @Qualifier( "devDataSource" )
//    @Primary
//    @ConfigurationProperties(prefix = "spring.datasource.secondary")
//    public DataSource devDataSource(){ return DataSourceBuilder.create().build(); }
//
//
//    @Bean(name = "jdbcTemplateTest")
//    public JdbcTemplate jdbcTemplateTest(@Qualifier( "testDataSource" ) DataSource dataSource){
//        return new JdbcTemplate(dataSource);
//    }
//
//
//    @Bean(name = "jdbcTemplateDev")
//    public JdbcTemplate jdbcTemplateDev(@Qualifier( "devDataSource" ) DataSource dataSource){
//        return new JdbcTemplate(dataSource);
//    }
}
