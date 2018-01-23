package com.wx.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wx.dao.UserDao;
import com.wx.entity.User;

/**
 * 在service层添加@Transactional注解，实现注解式事务
 * @author Administrator
 *
 */
@Service
@Transactional  //该事物注解，可以标记类或方法
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
//	@Transactional
	public void insert() {
		User user = new User();
		user.setUsername("Alfred");
		user.setBirthday(new Date());
		user.setAddress("sdf");
		user.setSex("男");
		userDao.insertUser(user);
		//service抛出异常
//		int i = 1/0;
	}
	
}
