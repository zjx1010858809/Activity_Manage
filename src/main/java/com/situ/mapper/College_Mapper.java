package com.situ.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.situ.entity.College;
import com.situ.utils.SearchInfo;

@Repository
public interface College_Mapper {
	
	@Select("select * from activity_college ${where} order by id desc ${limits}")
	public List<College> select(SearchInfo info);
	
	@Insert("insert into activity_college (name,school_id) values(#{name},#{school_id})")
	public void insert(College c);
	
	@Delete("delete from activity_college where id=#{id}")
	public void delete(int id);
	
	@Update("update activity_college set name=#{name},school_id=#{school_id} where id=#{id}")
	public void update(College c);
	
	@Select("select * from activity_college where id=#{id}")
	public College getbyid(int id);
	
	@Select("select count(id) from activity_college ${where}")
	public int getcount(SearchInfo info);
	
	@Select("select * from activity_college where school_id=#{school_id}")
	public List<College> selectBySchool(int school_id);

}
