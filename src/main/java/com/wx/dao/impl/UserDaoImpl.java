package com.wx.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.wx.dao.UserDao;
import com.wx.entity.User;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {
	
	public void queryAllUser() {
		List<User> list =  this.getSqlSession().selectList("User.selectAll");
		for (User user : list) {
			System.out.println(user.toString());
		}
	}
	
}
