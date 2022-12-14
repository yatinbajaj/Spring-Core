package com.example.springcore;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class InfraConfig {
	@Bean
	public DataSource dataSource() {
		return new DriverManagerDataSource();
	}
}
