package com.situ.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.situ.entity.Activity;
import com.situ.entity.User;
import com.situ.utils.ActivitySearchInfo;

@Repository("Activity_Mapper")
public interface Activity_Mapper {
	@Select("select a.* FROM activity a ${where} ${limits}")
	public List<Activity> selectAll(ActivitySearchInfo info);
	
	@Select("select count(a.id) count from activity a")
	public int selectSize(ActivitySearchInfo info);
	
	@Select("select id,name,type,status from activity WHERE DATE_SUB(CURDATE(), INTERVAL 60 DAY) <= createdate order by id desc")
	public List<Activity> selectInSeven();
	
	@Select("select id,name from activity_user where type = 0 ${where}")
	public List<User> student(ActivitySearchInfo info);

	@Select("select au.id,au.name,au.tel,acs.name school_name,ac.name college_name from activity_user au INNER JOIN activity_school acs on au.school_id = acs.id INNER JOIN activity_college ac on au.college_id = ac.id where au.type = 0 ${where}")
	public List<User> activityStudent(ActivitySearchInfo info);
	
	@Update("update activity set status = 1 where id = #{id}")
	public void cancel(int id);
	
	@Insert("insert into activity (courseinfo,planinfo,dateinfo,school,name,source_operator_id,options,attention,type,Instructor_user_id,operator_id,comments,createdate,user_ids,count,charge_operator_id) values (#{courseinfo},#{planinfo},#{dateinfo},#{school},#{name},#{source_operator_id},#{options},#{attention},#{type},#{Instructor_user_id},#{operator_id},#{comments},#{createdate},#{user_ids},#{count},#{charge_operator_id})")
	public int insert(Activity activity);
	
	@Update("update activity set user_ids = #{user_ids},count = #{count} where id = #{id}")
	public int addStudents(Activity activity);
	
	@Select("select * from activity where id=#{id}")
	public Activity getbyid(int id);
	
	@Select("select options from activity where id=#{id}")
	public String getOption(int id);

	@Update("update activity set options = #{options} where id = #{id}")
	public int setOption(Activity activity);
	
	@Update("update activity set name=#{name},courseinfo=#{courseinfo},dateinfo=#{dateinfo},operator_id=#{operator_id},type=#{type},planinfo=#{planinfo},school=#{school},comments=#{comments},attention=#{attention} where id=#{id}")
	public void updateall(Activity activity);

}
