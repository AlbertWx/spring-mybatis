package com.wx.dao;

import com.wx.entity.User;

public interface UserDao {
	
	public void queryAllUser();
	
	public void insertUser(User user);
	
}
