package com.notfound.champion.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.notfound.champion.entity.User;


@Mapper
public interface UserMapper {
	// 两种方式验证
	@Select("select * from user where user_name = #{name} or user_phone = #{name}")
	public User checkname(String name);

	// 查找用户名
	@Select("select * from user where user_name = #{name}")
	public User checkusername(String name);

	// 检查phone
	@Select("select * from user where user_phone = #{phone}")
	public User checkuserphone(String phone);

	// 验证用户和密码
	@Select("select * from user where (user_name=#{name} and user_password=(#{pswd})) or (user_phone=#{name} and user_password=(#{pswd}))")
	public User checkinfo(@Param(value = "name") String name, @Param(value = "pswd") String pswd);

	// 登录用户获取用户数据
	@Select("select * from user where user_id = #{id}")
	public User userinfo(String id);

	// 注册
	@Insert("insert into user (user_name,user_phone,user_password) values (#{name},#{phone},(#{pswd}))")
	public void insertUser(@Param(value = "name") String name, @Param(value = "phone") String phone,
			@Param(value = "pswd") String pswd);

	// 根据用户名获得用户id
	@Select("select user_id from user where user_name = #{name}")
	public int userid(@Param(value = "name") String name);
	
	//修改用户信息
	
	
	@Update("update user set user_name=#{user_name},user_sex=#{user_sex},user_phone=#{user_phone},user_email=#{user_email},user_address=#{user_address} where user_id=#{user_id}")
	public void changeUserInfo(User user);



}
