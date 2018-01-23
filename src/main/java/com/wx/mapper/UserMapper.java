package com.wx.mapper;

import java.util.List;

import com.wx.entity.User;

public interface UserMapper {
	
	public List<User> selectById(int id);
	
}
