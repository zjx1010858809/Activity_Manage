package com.situ.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.situ.entity.Activity;
import com.situ.entity.UserGroup;
import com.situ.utils.SearchInfo;

@Repository
public interface UserGroup_Mapper {
	
	@Select("select * from activity order by id desc")
	public List<Activity> selectActivity();
	
	@Select("select au.*,ao.name oname from activity_usergroup au inner join activity_operator ao on au.operator_id=ao.id ${where} order by au.id desc ${limits}")
	public List<UserGroup> select(SearchInfo info);
	
	@Insert("insert into activity_usergroup (name,activity_id,ids,project,path,point1,point2,point3,point4,point5,point6,createdate,operator_id,comments) values(#{name},#{activity_id},#{ids},#{project},#{path},#{point1},#{point2},#{point3},#{point4},#{point5},#{point6},#{createdate},#{operator_id},#{comments})")
	public void insert(UserGroup u);
	
	@Delete("delete from activity_usergroup where id=#{id}")
	public void delete(int id);
	
	@Update("update activity_usergroup set name=#{name},ids=#{ids},project=#{project} where id=#{id}")
	public void update(UserGroup u);
	
	@Update("update activity_usergroup set point1=#{point1},point2=#{point2},point3=#{point3},point4=#{point4},point5=#{point5},point6=#{point6},comments=#{comments} where id=#{id}")
	public void upscore(UserGroup u);
	
	@Select("select * from activity_usergroup where id=#{id}")
	public UserGroup getbyid(int id);
	
	@Select("select count(au.id) from activity_usergroup au inner join activity_operator ao on au.operator_id=ao.id ${where}")
	public int getcount(SearchInfo info);

}
