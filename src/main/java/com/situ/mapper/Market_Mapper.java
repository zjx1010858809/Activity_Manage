package com.situ.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.situ.entity.Activity;
import com.situ.entity.Market;
import com.situ.utils.CheckWorkSearchInfo;

@Repository
public interface Market_Mapper {
	
	@Select("select * from activity order by id desc")
	public List<Activity> selectActivity();
	
	@Select("select * from activity_market where activity_id=#{activity_id}")
	public List<Market> selectDate(int activity_id);
	
	@Select("select am.*,ao.name oname from activity_market am inner join activity_operator ao on am.operator_id=ao.id ${where} order by am.id desc ${limits}")
	public List<Market> select(CheckWorkSearchInfo info);
	
	@Insert("insert into activity_market (activity_id,operator_id,date,info,json,comments) values(#{activity_id},#{operator_id},#{date},#{info},#{json},#{comments})")
	public void insert(Market r);
	
	@Delete("delete from activity_market where id=#{id}")
	public void delete(int id);
	
	@Update("update activity_market set operator_id=#{operator_id},info=#{info},comments=#{comments},json=#{json} where id=#{id}")
	public void update(Market r);
	
	@Select("select * from activity_market where id=#{id}")
	public Market getbyid(int id);
	
	@Select("select count(am.id) from activity_market am inner join activity_operator ao on am.operator_id=ao.id ${where}")
	public int getcount(CheckWorkSearchInfo info);

}
