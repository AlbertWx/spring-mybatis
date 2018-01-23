package com.wx.dao.impl;

import java.util.List;


import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wx.dao.UserDao;
import com.wx.entity.User;
import com.wx.mapper.UserMapper;


@Transactional
@Repository
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {
	
	@Autowired
	private UserMapper userMapper;
	
	public void queryAllUser() {
		List<User> list =  this.getSqlSession().selectList("User.selectAll");
		for (User user : list) {
			System.out.println(user.toString());
		}
	}
	
	public void insertUser(User user) {
		userMapper.insertUser(user);	
		//dao层抛出异常
		int i = 1/0;
	}
	
}
