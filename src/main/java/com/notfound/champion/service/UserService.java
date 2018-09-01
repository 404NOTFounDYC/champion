package com.notfound.champion.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notfound.champion.entity.User;
import com.notfound.champion.mapper.UserMapper;

@Service
public class UserService {
	@Autowired
	UserMapper mapper;

	// 检查用户输入的用户名，或phone
	public User checkname(String name) {
		return mapper.checkname(name);
	}

	// 登陆（检查）
	public User checkinfo(String name, String pswd) {
		return mapper.checkinfo(name, pswd);
	}

	// 根据用户id获取用户信息
	public User userinfo(String userid) {
		return mapper.userinfo(userid);
	}

	// 根据用户名获取用户id
	public int getId(String name) {
		return mapper.userid(name);
	}

	// 注册用户信息
	public void insertUser(String name, String phone, String pswd) {
		mapper.insertUser(name, phone, pswd);
	}

	// 检查注册时的用户名输入
	public User checkusername(String name) {
		return mapper.checkusername(name);
	}

	// 检查注册时的用户phone输入
	public User checkuserphone(String phone) {
		return mapper.checkuserphone(phone);
	}

	
	public void changeUserInfo(User user) {
		mapper.changeUserInfo(user);
	}
}
