package com.situ.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.situ.entity.Activity;
import com.situ.entity.Evaluation;
import com.situ.entity.Operator;
import com.situ.utils.CheckWorkSearchInfo;
import com.situ.utils.EvaluationSearchInfo;
import com.situ.utils.SearchInfo;

@Repository
public interface Evaluation_Mapper {
	
	@Select("select ae.*,au.name auname,a.name aname from activity_evaluation ae inner join activity_user au inner join activity a on ae.user_id=au.id and ae.activity_id=a.id ${where} ${limits} ")
	public List<Evaluation> selectsingle(CheckWorkSearchInfo info);
	
	@Select("select ae.*,au.name auname,a.name aname from activity_evaluation ae inner join activity_user au inner join activity a on ae.user_id=au.id and ae.activity_id=a.id ${where} ${limits} ")
	public List<Evaluation> index(SearchInfo info);
	
	@Select("select count(ae.id) count from activity_evaluation ae inner join activity_user au on ae.user_id=au.id ${where}")
	public List<Evaluation> selectSize(SearchInfo info);
	
	@Select("select user_ids from activity ${where}")
	public List<Activity> selectIds(EvaluationSearchInfo info);
	
	@Select("select id from activity_evaluation ${where}")
	public Evaluation s_evaluation(EvaluationSearchInfo info);
	
	@Insert("insert into activity_evaluation(activity_id,user_id) values(#{activity_id},#{user_id})")
	public int insert(Evaluation e);
	
	//修改分数
	@Update("update activity_evaluation set point=#{point},remark=#{remark} where id=#{id}")
	public int update(Evaluation e);
	
	//批量修改分数
	@Update("update activity_evaluation set point=#{point},remark=#{remark} where id IN (${ids})")
	public int batchScore(Evaluation e);
	
	@Delete("delete from activity_evaluation where id = #{id}")
	public int delete(int id);
	
	@Select(value = "select ae.*,au.name auname,a.name aname from activity_evaluation ae inner join activity_user au inner join activity a on ae.user_id=au.id and ae.activity_id=a.id where ae.id=#{id}")
	public Evaluation getById(int id);
	
	@Select("select * from activity order by id desc")
	public List<Activity> selectActivity();
	
	@Select("select * from activity_operator")
	public List<Operator> selectOperator();
	
	//锁定用户状态
	@Update("update activity_evaluation set status=1 where id=#{id}")
	public void locking(int id);
	
	//锁定用户状态
	@Update("update activity_evaluation set status=0 where id=#{id}")
	public void unlock(int id);
		
}
