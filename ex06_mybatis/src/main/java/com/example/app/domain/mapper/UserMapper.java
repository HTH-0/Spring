package com.example.app.domain.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.example.app.domain.dto.UserDto;

@Mapper
public interface UserMapper {
	@SelectKey(statement="select max(userid)+1 from tbl_user",keyProperty = "userid",before = false, resultType = int.class)
	@Insert(value = "INSERT INTO tbl_user VALUES (#{userid}, #{password}, #{rePassword}, #{username}, #{phone}, #{zipcode}, #{addr1}, #{addr2}, #{birthday})")
	public int insert(UserDto userDto);
	
	@Update("update tbl_user set username=#{username} where userid=#{userid}")
	public int update(UserDto userDto);
	
	@Delete("delete from tbl_user where userid=#{userid}")
	public int delete(int userid);
	
	@Select("select * from tbl_user where userid=#{userid}")
	public UserDto selectAt(int userid);
	
	
	@Select("select * from tbl_user")
	public List<UserDto> selectAll(); 

	@Results(id="MemoResultMap", value= {
			@Result(property = "userid",column="userid"),
			@Result(property = "password", column="password")
	})
	@Select("select * from tbl_user")
	public List< Map<String,Object> > selectAllResultMap(); 
	
	
	// xml 방식
	public int insertXml(UserDto userDto);
	public int updateXml(UserDto userDto);
	public int deleteXml(@Param("userid") int userid);
	public UserDto selectAtXml(int userid);
	public List<UserDto> selectAllXml();
	public List<Map<String, Object>> selectAllResultMapXml();

	
}
