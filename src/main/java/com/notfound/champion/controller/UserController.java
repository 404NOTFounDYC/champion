package com.notfound.champion.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.notfound.champion.entity.User;
import com.notfound.champion.mapper.UserMapper;
import com.notfound.champion.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/user/info")
	public User getUserInfo(String name) {
//		String name = (String)map.get("name");
		return userService.checkname(name);
	}
	
	@PostMapping(value = "/changeUserInfo")
	public HashMap<String, Object> changeInfo(@RequestBody User user){
//		String name = (String) map.get("user_name");
//		String phone = (String) map.get("user_phone");
//		String sex = (String) map.get("user_sex");
//		String email = (String) map.get("user_email");
//		String address = (String) map.get("user_address");
		userService.changeUserInfo(user);
		HashMap<String, Object> hash = new HashMap<>();
		hash.put("msg", "ok");
		return hash;
	}
	
	@PostMapping(value = "/user",produces = "application/json;charset=UTF-8")
	public User userinfoUser(@RequestBody Map map) {
		String id = (String) map.get("user_id");
		return userService.userinfo(id);

	}
}
