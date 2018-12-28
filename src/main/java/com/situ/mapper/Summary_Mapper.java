package com.situ.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.situ.entity.Activity;
import com.situ.entity.Summary;
import com.situ.utils.SummarySearchInfo;

@Repository
public interface Summary_Mapper {
	
	@Select("select * from activity")
	public List<Activity> selectActivity();
	
	@Select("select * from activity_summary where activity_id=#{activity_id}")
	public List<Summary> selectDate(int activity_id);
	
	@Select("select asu.*,ao.name oname,act.name aname from activity_summary asu inner join activity_operator ao inner join activity act on asu.operator_id=ao.id and asu.activity_id=act.id ${where} order by asu.id desc ${limits}")
	public List<Summary> select(SummarySearchInfo info);
	
	@Insert("insert into activity_summary (activity_id,operator_id,createdate,options,sstatus,tstatus,cstatus,xstatus,summary,proposal,comments) values(#{activity_id},#{operator_id},#{createdate},#{options},#{sstatus},#{tstatus},#{cstatus},#{xstatus},#{summary},#{proposal},#{comments})")
	public void insert(Summary r);
	
	@Delete("delete from activity_summary where id=#{id}")
	public void delete(int id);
	
	@Update("update activity_summary set operator_id=#{operator_id},options=#{options},sstatus=#{sstatus},tstatus=#{tstatus},cstatus=#{cstatus},xstatus=#{xstatus},summary=#{summary},proposal=#{proposal},comments=#{comments} where id=#{id}")
	public void update(Summary r);
	
	@Select("select * from activity_summary where id=#{id}")
	public Summary getbyid(int id);
	
	@Select("select count(asu.id) from activity_summary asu inner join activity_operator ao on asu.operator_id=ao.id ${where}")
	public int getcount(SummarySearchInfo info);

}
