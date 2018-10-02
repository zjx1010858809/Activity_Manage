package com.situ.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.situ.entity.Checkwork;
import com.situ.utils.CheckWorkSearchInfo;

@Repository
public interface CheckWork_Mapper {
	
	@Select("select * from activity_checkwork where activity_id=#{activity_id} order by date desc")
	public List<Checkwork> selectDate(int activity_id);
	
	@Select("select ack.*,au.name uname,ao.name oname from activity_checkwork ack inner join  activity_user au inner join activity_operator ao on ack.user_id=au.id and ack.operator_id=ao.id ${where} order by ack.id asc ${limits}")
	public List<Checkwork> select(CheckWorkSearchInfo info);
	
	@Insert("insert into activity_checkwork (activity_id,user_id,date,check1,check2,check3,lastdate,operator_id,comments) values(#{activity_id},#{user_id},#{date},#{check1},#{check2},#{check3},#{lastdate},#{operator_id},#{comments})")
	public void insert(Checkwork c);
	
	@Delete("delete from activity_checkwork where id=#{id}")
	public void delete(int id);
	
	@Update("update activity_checkwork set check1=#{check1},check2=#{check2},check3=#{check3},lastdate=#{lastdate},operator_id=#{operator_id},comments=#{comments} where id=#{id}")
	public void update(Checkwork c);
	
	@Select("select * from activity_checkwork where id=#{id}")
	public Checkwork getbyid(int id);
	
	@Select("select count(ack.id) from activity_checkwork ack inner join  activity_user au inner join activity_operator ao on ack.user_id=au.id and ack.operator_id=ao.id ${where}")
	public int getcount(CheckWorkSearchInfo info);
	
	@Update("update activity_checkwork set ${check}=#{status},lastdate=#{lastdate},operator_id=#{operator_id} where id in (${ids})")
	public void updatecheck(Checkwork c);
	
}
