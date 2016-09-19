package com.example.comment.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;

@Configuration
@ComponentScan({"com.example.comment.repo"})
@PropertySource("classpath:/config/dbconfig.properties")
public class CommentConfig {
	@Bean
	public DataSource dataSource(@Value("${ds.driverClassName}")String driverClassName,
								 @Value("${ds.url}") String url,
								 @Value("${ds.username}") String userName,
								 @Value("${ds.password}") String password,
								 @Value("${ds.maxTotal}") int maxTotal,
								 @Value("${ds.initialSize}") int initialSize,
								 @Value("${ds.maxIdle}") int maxIdle){
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(driverClassName);
		ds.setUrl(url);
		ds.setUsername(userName);
		ds.setPassword(password);
		ds.setMaxTotal(maxIdle);
		ds.setInitialSize(initialSize);
		ds.setMaxIdle(maxIdle);
		return ds;
	}
	
	@Bean
	public SqlSessionFactoryBean sqlSessionFacoryBean(DataSource ds){
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(ds);
		String loc="mybatis/mybatis-config.xml";
		bean.setConfigLocation(new ClassPathResource(loc));
		return bean;
	}
	
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactoryBean sfb) throws Exception{
		SqlSessionTemplate template = new SqlSessionTemplate(sfb.getObject());
		return template;

	}
	
/*	@Bean
	public JdbcTemplate jdbcTemplate(DataSource ds){
		return new JdbcTemplate(ds);
	}*/
}
