package com.situ.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.situ.entity.Activity;
import com.situ.entity.Activity_Time;
import com.situ.entity.FeedBack;
import com.situ.utils.FeedBackSearchInfo;

@Repository
public interface FeedBack_Mapper {
	@Select("select id from activity_feedback where activity_time_id = #{activity_time_id} and user_id = #{user_id}")
	public FeedBack ifExit(FeedBack feedBack);
	
	@Insert("insert into activity_feedback(activity_time_id,user_id) values(#{activity_time_id},#{user_id})")
	public int insert(FeedBack feedBack);
	
	@Select("select af.*,au.name user_name from activity_feedback af INNER JOIN activity_user au ON af.user_id = au.id ${where} ${limits}")
	public List<FeedBack> selectAll(FeedBackSearchInfo info);
		
	@Select("select COUNT(af.id) from activity_feedback af INNER JOIN activity a ON af.activity_time_id = a.id INNER JOIN activity_user au ON af.user_id = au.id ${where} ${limits}")
	public int selectSize(FeedBackSearchInfo info);
	
	@Select("select MAX(id) activity_id from activity")
	public int selectMax(FeedBackSearchInfo info);
	
	@Select("select id from activity_time where activity_id = #{activity_id} and date = (select MAX(date) from activity_time where activity_id = #{activity_id})")
	public int selectMaxDate(int activity_id);
	
	@Select("select id,name,type,status from activity where type = #{type} order by id desc")
	public List<Activity> activity(FeedBackSearchInfo info);
	
	@Select("select * from activity_feedback where id = #{id}")
	public FeedBack selectById(int id);
	
	@Update("update activity_feedback set status = #{status} where id = #{id}")
	public int updateStatus(FeedBack feedBack);
	
	@Update("update activity_feedback set result = #{result} where id = #{id}")
	public int updateResult(FeedBack feedBack);

	@Select("select * from activity_time where activity_id = #{activity_id} order by date desc")
	public List<Activity_Time> selectByAcid(int activity_id);
	
	@Select("select af.*,at.date,a.name activity_name from activity_feedback af INNER JOIN activity_time at ON af.activity_time_id = at.id INNER JOIN activity a ON at.activity_id = a.id where af.user_id = #{user_id}")
	public List<FeedBack> selectByUserid(int user_id);
	
	@Select("select count(af.id) count from activity_feedback af INNER JOIN activity_time at ON af.activity_time_id = at.id INNER JOIN activity a ON at.activity_id = a.id where af.user_id = #{user_id}")
	public int userSize(int user_id);
}
