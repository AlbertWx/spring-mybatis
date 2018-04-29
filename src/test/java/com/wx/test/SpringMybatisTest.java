package com.wx.test;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wx.dao.UserDao;
import com.wx.entity.User;
import com.wx.mapper.ExtUserMapper;
import com.wx.mapper.UserMapper;
import com.wx.service.UserService;

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
	 * 因为 ExtUserMapper继承UserMapper接口，所以spring在通过context.getBean(UserMapper.class)获取UserMapper
	 * 时会找到两个，搞混，因此需要指定一下
	 */
	@Test
	public void selectByIdByScanPackage() {
		//UserMapper mapper = (UserMapper) context.getBean(UserMapper.class);
		UserMapper mapper = (UserMapper) context.getBean("userMapper", UserMapper.class);
		List<User> list = mapper.selectById(26);
		for (User user : list) {
			System.out.println("+++++++++++");
			System.out.println(user.toString());
			System.out.println("+++++++++++");
		}
	}
	
	/**
	 * ExtUserMapper继承UserMapper接口开发
	 */
	@Test
	public void selectByIdByScanPackageExtUserMapper1() {
		ExtUserMapper mapper = (ExtUserMapper) context.getBean(ExtUserMapper.class);
		List<User> list = mapper.selectById(26);
		for (User user : list) {
			System.out.println("+++++++++++");
			System.out.println(user.toString());
			System.out.println("+++++++++++");
		}
	}
	
	/**
	 * ExtUserMapper继承UserMapper接口开发
	 */
	@Test
	public void selectByIdByScanPackageExtUserMapper2() {
		ExtUserMapper mapper = (ExtUserMapper) context.getBean(ExtUserMapper.class);
		List<User> list = mapper.selectByIdExt(26);
		for (User user : list) {
			System.out.println("+++++++++++");
			System.out.println(user.toString());
			System.out.println("+++++++++++");
		}
	}
	
	/**
	 * 测试事物配置
	 */
	@Test
	public void insertUser() {
		UserService service = (UserService) context.getBean(UserService.class);
		service.insert();
	}
	
	
}
