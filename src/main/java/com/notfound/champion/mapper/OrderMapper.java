package com.notfound.champion.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.notfound.champion.entity.Order;

@Mapper
public interface OrderMapper {
	
	//加载购物che
	@Select("select * from orders where user_name = #{user_name}")
	public List<Order> get(String user_name);
	
	//加入购物车
	@Insert("insert into orders(user_name,prod_name,quantity,prod_price) values(#{user_name},#{prod_name},#{quantity},#{prod_price}) ")
	public void add(@Param(value = "user_name")String user_name,
			@Param(value = "prod_name")String prod_name,
			@Param(value = "quantity")Integer quantity,
			@Param(value = "prod_price")Integer prod_price);

	//从购物车中删除
	@Delete("delete from orders where order_id = #{order_id}")
	public void deleteOrder(Integer order_id);
}
