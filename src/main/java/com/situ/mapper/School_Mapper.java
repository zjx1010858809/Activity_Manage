package com.situ.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.situ.entity.School;
import com.situ.utils.SearchInfo;

@Repository
public interface School_Mapper {
	
	@Select("select * from activity_school where id not in(1) order by id desc")
	public List<School> selectall();
	
	@Select("select * from activity_school ${where} ${limits}")
	public List<School> select(SearchInfo info);
	
	@Insert("insert into activity_school (name) values(#{name})")
	public void insert(School s);
	
	@Delete("delete from activity_school where id=#{id}")
	public void delete(int id);
	
	@Update("update activity_school set name=#{name} where id=#{id}")
	public void update(School s);
	
	@Select("select * from activity_school where id=#{id}")
	public School getbyid(int id);
	
	@Select("select count(id) from activity_school ${where}")
	public int getcount(SearchInfo info);

}
