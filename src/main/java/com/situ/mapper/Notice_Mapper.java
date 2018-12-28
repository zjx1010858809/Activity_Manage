package com.situ.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.situ.entity.Activity;
import com.situ.entity.College;
import com.situ.entity.Notice;
import com.situ.entity.Operator;
import com.situ.entity.School;
import com.situ.utils.SearchInfo;

@Repository
public interface Notice_Mapper {
	
	@Select("select an.*,a.name aname,ao.name aoname from activity_notice an inner join activity a inner join activity_operator ao on an.activity_id=a.id and an.operator_id=ao.id")
	public List<Notice> select(SearchInfo info);
	
	@Select("select count(id) count from activity_notice ${where}")
	public List<Notice> selectSize(SearchInfo info);
	
	@Insert("insert into activity_notice(title,activity_id,date,type,status,info,operator_id) values(#{title},#{activity_id},#{date},#{type},#{status},#{info},#{operator_id})")
	public int insert(Notice n);
	
	//修改用户信息
	@Update("update activity_notice set title=#{title},activity_id=#{activity_id},date=#{date},operator_id=#{operator_id},type=#{type},status=#{status},info=#{info} where id=#{id}")
	public int update(Notice n);
	
	@Delete("delete from activity_notice where id = #{id}")
	public int delete(int id);
	
	@Select(value = "select an.*,a.name aname,ao.name aoname from activity_notice an inner join activity a inner join activity_operator ao on an.activity_id=a.id and an.operator_id=ao.id where an.id=#{id}")
	public Notice getById(int id);
	
	@Select("select * from activity")
	public List<Activity> selectActivity();
	
	@Select("select * from activity_operator")
	public List<Operator> selectOperator();
	
}
