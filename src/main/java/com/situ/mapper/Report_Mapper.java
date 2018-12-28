package com.situ.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.situ.entity.Activity;
import com.situ.entity.Report;
import com.situ.utils.CheckWorkSearchInfo;

@Repository
public interface Report_Mapper {
	
	@Select("select * from activity order by id desc")
	public List<Activity> selectActivity();
	
	@Select("select * from activity_report where activity_id=#{activity_id}")
	public List<Report> selectDate(int activity_id);
	
	@Select("select ar.*,ao.name oname from activity_report ar inner join activity_operator ao on ar.operator_id=ao.id ${where} order by ar.id desc ${limits}")
	public List<Report> select(CheckWorkSearchInfo info);
	
	@Insert("insert into activity_report (activity_id,operator_id,date,tprogress,sprogress,cprogress,json,comments) values(#{activity_id},#{operator_id},#{date},#{tprogress},#{sprogress},#{cprogress},#{json},#{comments})")
	public void insert(Report r);
	
	@Delete("delete from activity_report where id=#{id}")
	public void delete(int id);
	
	@Update("update activity_report set operator_id=#{operator_id},tprogress=#{tprogress},sprogress=#{sprogress},cprogress=#{cprogress},json=#{json},comments=#{comments} where id=#{id}")
	public void update(Report r);
	
	@Select("select * from activity_report where id=#{id}")
	public Report getbyid(int id);
	
	@Select("select count(ar.id) from activity_report ar inner join activity_operator ao on ar.operator_id=ao.id ${where}")
	public int getcount(CheckWorkSearchInfo info);

}
