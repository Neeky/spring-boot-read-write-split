package com.sqlpy.readwritesplit.demo.configs;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class JdbcTemplateConfig {
    @Bean
    JdbcTemplate jdbcTemplateWrite(@Qualifier("dsWrite")DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    JdbcTemplate jdbcTemplateRead(@Qualifier("dsRead")DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
