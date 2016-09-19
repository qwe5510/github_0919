package com.example.comment.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.comment.config.CommentConfig;
import com.example.comment.dto.Comment;
import com.example.comment.repo.CommentRepo;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=CommentConfig.class)
public class ConfigTest {
	static Logger logger = LoggerFactory.getLogger(ConfigTest.class);
	@Autowired
	CommentRepo repo;
		
	@Autowired
	DataSource ds ;
	
	@Autowired
	SqlSessionTemplate template;
	
	@Test
	public void testRepo() {
		assertThat(repo, is(notNullValue()));
	}
	
	@Test
	public void testDB() throws SQLException {
		assertThat(ds, is(notNullValue()));
		Connection con = ds.getConnection();
		assertThat(con, is(notNullValue()));
	}
	
	@Test
	public void testTemplate(){
		logger.trace("template {}",template);
		assertThat(template, is(notNullValue()));
		
	}
	
	@Test
	public void testInsert(){
		Comment comment = new Comment(0,"hong","test");
		int result = repo.insert(comment);
		logger.trace("result : {}",result);
		logger.trace("number {} ",comment.getCommentNo());
		assertThat(repo.insert(comment), is(1));
	}

}
