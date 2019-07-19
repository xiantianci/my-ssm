package com.bjsxt.mapper;

import org.apache.ibatis.annotations.Insert;

import com.bjsxt.pojo.User;

public interface UserMapper {
	@Insert("insert into user values (default,#{username},#{password},#{photo})")
	void insertUser(User user);
}
