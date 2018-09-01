package com.notfound.champion.controller;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.notfound.champion.entity.Product;
import com.notfound.champion.mapper.ProductMapper;


@RestController
public class SearchController {
	
	@Autowired
	ProductMapper mapper;
	
	@GetMapping("/search")
	public List<Product> search(String type){
		return mapper.search(type);
	}
	
	@GetMapping("/searchAll")
	public List<Product> searchAll(String key1){
		System.out.println(key1);
		String key = "%"+key1+"%";
		return mapper.searchAll(key);
	}
	
	@GetMapping("/getAllProduct")
	public List<Product> getAll(){
		return mapper.getAllProduct();
	}

	
}
