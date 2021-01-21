package com.main.configuration;

import java.beans.BeanProperty;

import javax.sql.DataSource;
import javax.xml.transform.Source;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.main.dao.Dao;
import com.main.dao.DaoImpl;
import com.main.daohelper.DaoHelper;
import com.main.daohelper.DaoHelperImpl;
import com.main.daohelperservice.DaoHelperService;
import com.main.daohelperservice.DaoHelperServiceImpl;
import com.main.service.DaoService;
import com.main.service.DaoServiceImpl;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.main"})
public class Config implements WebMvcConfigurer {
	
	@Bean 
	public InternalResourceViewResolver resolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver(); 
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver; 
	}
	
	
	@Bean
	public DataSource dataSource() {
		
		String username = "root";
		String password = "Bricks64";
		String url = "jdbc:mysql://localhost:3306/info"; 
		String driverClass = "com.mysql.cj.jdbc.Driver";
		
		DriverManagerDataSource source = new DriverManagerDataSource(); 
		source.setPassword(password);
		source.setUrl(url);
		source.setDriverClassName(driverClass);
		source.setUsername(username);
		
		return source; 
	}
	
	@Bean 
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate template = new JdbcTemplate(dataSource());
		return template; 
	}
	
	
	//if you get bean factory errors, check name of bean method, and type must be the exact object
	
	@Bean 
	public DaoImpl daoImpl() {
		return new DaoImpl(); 
	}
	
	

	/*for the helper methods */ 
	
	@Bean
	public DaoHelperImpl daoHelperImpl() {
		return new DaoHelperImpl(); 
	}
	

	@Bean
	public DaoHelperServiceImpl DaoHelperServiceImpl() {
		return new DaoHelperServiceImpl(); 
	}
	
	
	

}
