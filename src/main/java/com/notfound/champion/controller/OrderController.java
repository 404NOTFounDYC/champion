package com.notfound.champion.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.notfound.champion.entity.Order;
import com.notfound.champion.mapper.OrderMapper;

@RestController
public class OrderController {
	
	@Autowired
	OrderMapper mapper;
	
	@GetMapping("/getOrder")
	public List<Order> get(String user_name){
		return mapper.get(user_name);
	}
	
	@PostMapping("/addOrder")
	public void add(@RequestBody Map map) {
		String user_name = (String) map.get("user_name");
		int prod_price = (int) map.get("prod_price");
		String prod_name = (String) map.get("prod_name");
		int quantity = (int) map.get("quantity");
		mapper.add(user_name, prod_name, quantity, prod_price);
	}

	@PostMapping("/deleteOrder")
	public void delete(@RequestBody Map map) {
		System.out.println(map.get("order_id"));
		mapper.deleteOrder((Integer) map.get("order_id"));
		
	}
}
