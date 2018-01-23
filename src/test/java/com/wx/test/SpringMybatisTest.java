package com.wx.test;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wx.dao.UserDao;
import com.wx.entity.User;
import com.wx.mapper.UserMapper;

public class SpringMybatisTest {
	
	private ApplicationContext context;
	
	@Before
	public void loadResource() {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	/**
	 * 原始的dao层开发
	 */
	@Test
	public void queryAllUser() {
		UserDao dao = (UserDao) context.getBean("userDao");
		dao.queryAllUser();
	}
	
	/**
	 * mapper动态代理接口基本方式开发
	 */
	@Test
	public void selectById() {
		UserMapper mapper = (UserMapper) context.getBean("userMapper");
		List<User> list = mapper.selectById(36);
		for (User user : list) {
			System.out.println("+++++++++++");
			System.out.println(user.toString());
			System.out.println("+++++++++++");
		}
	}
	
	/**
	 * mapper动态代理接口包扫描方式开发
	 */
	@Test
	public void selectByIdByScanPackage() {
		UserMapper mapper = (UserMapper) context.getBean(UserMapper.class);
		List<User> list = mapper.selectById(36);
		for (User user : list) {
			System.out.println("+++++++++++");
			System.out.println(user.toString());
			System.out.println("+++++++++++");
		}
	}
	
}