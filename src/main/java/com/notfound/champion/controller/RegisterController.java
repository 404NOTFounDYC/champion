package com.notfound.champion.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.notfound.champion.service.UserService;

@RestController
public class RegisterController {

	@Autowired
	UserService service;
	@PostMapping(value = "/register",produces = "application/json;charset=UTF-8")
	public String register(@RequestBody Map map) {
		String name = (String) map.get("name");
		String pswd = (String) map.get("password");
		String phone = (String) map.get("phone");
		JSONObject result = new JSONObject();
		//用户名和电话都不存在
		if ((service.checkusername(name) == null) && (service.checkuserphone(phone) == null)) {
			service.insertUser(name, phone, pswd);
			String Id = service.getId(name) + "";
			result.put("msg", Id);
			return result.toJSONString();
		}
		// 如果用户名已经存在
		if (service.checkusername(name) != null) {
			result.put("msg", "用户名已被注册");
			return result.toJSONString();
		}
		//如果电话存在
		if (service.checkuserphone(phone) != null) {
			result.put("msg", "手机号已被注册");
			return result.toJSONString();
		}
		
		return "服务器或其他错误";
	}
}
