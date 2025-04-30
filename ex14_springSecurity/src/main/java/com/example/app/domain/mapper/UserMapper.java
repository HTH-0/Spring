package com.example.app.domain.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.app.domain.dto.UserDto;

@Mapper
public interface UserMapper {
	
	@Insert("insert into tbl_user values(#{username}, #{password}, #{role}")
	public int insert(UserDto userDto);
	
	@Select("select * FROm tbl_user where username=#{username}")
	public UserDto SelectAt(String userename);
}
