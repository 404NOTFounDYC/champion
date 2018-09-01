package com.notfound.champion.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.notfound.champion.entity.Product;

@Mapper
public interface ProductMapper {
	@Select("select * from product")
	public List<Product> getAllProduct();
	
	@Select("select * from product where prod_type like #{type}")
	public List<Product> search(String type);

	@Select("select * from product where prod_name like #{key} or prod_note like #{key}")
	public List<Product> searchAll(String key);
}
