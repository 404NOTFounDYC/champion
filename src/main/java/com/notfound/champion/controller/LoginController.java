package com.notfound.champion.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.notfound.champion.service.UserService;

@RestController
public class LoginController {

	@Autowired
	UserService service;

	// 用户登录，分别验证用户的用户名和电话，返回对应信息
	@PostMapping(value = "/login", produces = "application/json;charset=UTF-8")
	public String login(@RequestBody Map map) {
		String name = (String) map.get("name");
		String pswd = (String) map.get("password");
		JSONObject result = new JSONObject();
		if (service.checkname(name) == null) {
			System.out.println(service.checkname(name));
			result.put("msg", "用户名错误，请重新输入");
			return  result.toJSONString();
		}
		if (service.checkinfo(name, pswd) != null) {
			String user_id =""+service.checkinfo(name, pswd).getUser_id();
			result.put("msg", user_id);
			return result.toJSONString();

		} else {
			result.put("msg", "用户密码错误");
			return result.toJSONString();
		}

	}
}
