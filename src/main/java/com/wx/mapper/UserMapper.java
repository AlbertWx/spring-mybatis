package com.wx.mapper;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;

import com.wx.entity.User;

//@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,timeout=1,isolation=Isolation.DEFAULT)
public interface UserMapper {
	
	public List<User> selectById(int id);
	
	public void insertUser(User user);
	
}
