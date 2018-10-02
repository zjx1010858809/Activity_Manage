package com.situ.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.situ.entity.College;
import com.situ.entity.User;
import com.situ.utils.UserSearchInfo;

@Repository
public interface User_Mapper {
	
	@Select("select u.*,s.name school_name,c.name college_name from activity_user u INNER JOIN activity_school s ON u.school_id = s.id INNER JOIN activity_college c ON u.college_id = c.id ${where} ${limits}")
	public List<User> select(UserSearchInfo info);
	
	@Select("select count(u.id) count from activity_user u ${where}")
	public List<User> selectSize(UserSearchInfo info);
	
	@Insert("insert into activity_user(nike,pass,name,type,tel,classinfo,ylevel,glevel,sex,qq,slevel,school_id,college_id,status,info,createdate,operator_id,comments) values(#{nike},#{pass},#{name},#{type},#{tel},#{classinfo},#{ylevel},#{glevel},#{sex},#{qq},#{slevel},#{school_id},#{college_id},#{status},#{info},#{createdate},#{operator_id},#{comments})")
	public int insert(User u);
	
	//修改学生信息
	@Update("update activity_user set name=#{name},sex=#{sex},tel=#{tel},qq=#{qq},classinfo=#{classinfo},slevel=#{slevel},ylevel=#{ylevel},glevel=#{glevel},status=#{status},info=#{info},comments=#{comments} where id=#{id}")
	public int studentUpdate(User u);
	
	//修改辅导员信息
	@Update("update activity_user set name=#{name},sex=#{sex},tel=#{tel},qq=#{qq},status=#{status},info=#{info},comments=#{comments} where id=#{id}")
	public int teacherUpdate(User u);
	
	@Select("select * from activity_college where school_id=#{school_id}")
	public List<College> selectCollege(int school_id);
	
	@Delete("delete from activity_user where id = ${id}")
	public int delete();
	
	@Select(value = "select u.*,s.name school_name,c.name college_name from activity_user u INNER JOIN activity_school s ON u.school_id = s.id INNER JOIN activity_college c ON u.college_id = c.id where u.id=#{id}")
	public User getById(int id);
	
}
