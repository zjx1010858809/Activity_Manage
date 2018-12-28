package com.situ.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.situ.entity.Activity_Time;
import com.situ.entity.Operator;
import com.situ.utils.ActivitySearchInfo;

@Repository("Activity_Time_Mapper")
public interface Activity_Time_Mapper {
	@Select("select at.*,a.name activity_name,o.name operator_name from activity_time at INNER JOIN activity a on at.activity_id = a.id INNER JOIN activity_operator o ON at.operator_id = o.id ${where} order by at.date desc ${limits}")
	public List<Activity_Time> selectAll(ActivitySearchInfo info);
	
	@Select("select count(at.id) count from activity_time at ${where}")
	public List<Activity_Time> selectSize(ActivitySearchInfo info);
	
	@Select("select at.time1,at.time2,at.time3,at.time4,at.time5,at.time6,at.roominfo,ao.name operator_name from activity_time at INNER JOIN activity_operator ao ON at.operator_id = ao.id where at.id = #{id}")
	public List<Activity_Time> selectDetails(int id);
	
	@Select("select * from activity_time where id = #{id}")
	public Activity_Time selectById(int id);
	
	@Update("UPDATE activity_time set status = #{status} where id = #{id}")
	public void updateStatus(Activity_Time acTime);
	
	@Update("UPDATE activity_time set status = 3 where id = #{id}")
	public int cancel(int id);
	
	@Update("UPDATE activity_time set status = 3 where activity_id = #{id}")
	public void cancelByActivity(int id);
	
	@Select("select id,name,type,power,status from activity_operator where type = 0")
	public List<Operator> teacher();
	
	@Insert("insert into activity_time (activity_id,time1,time2,time3,time4,time5,time6,operator_id,roominfo,date) values (#{activity_id},#{time1},#{time2},#{time3},#{time4},#{time5},#{time6},#{operator_id},#{roominfo},#{date})")
	public int add(Activity_Time activity_Time);
	
	@Select("select MAX(id) from activity")
	public int maxId();
	
	@Update("UPDATE activity_time set time1 = #{time1}, time2 = #{time2}, time3 = #{time3}, time4 = #{time4}, time5 = #{time5}, time6 = #{time6}, roominfo = #{roominfo}, date = #{date}, operator_id = #{operator_id} where id = #{id}")
	public int updateDetails(Activity_Time acTime);
	
	@Select("select a.name activity_name,at.date from activity_time at INNER JOIN activity a ON at.activity_id = a.id")
	public List<Activity_Time> canlender();
	
	@Select("select @@identity AS 'identity'")
	public int selectIdentity();
}
