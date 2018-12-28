package com.situ.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.situ.entity.Operator;
import com.situ.utils.SearchInfo;

@Repository("Operator_Mapper")
public interface Operator_Mapper {
	
	@Select(value = "select * from activity_operator")
	public List<Operator> selectall();
	
	@Select(value = "select * from activity_operator ${where} ${limits}")
	public List<Operator> index(SearchInfo info);
	
	@Select("select count(id) count from activity_operator ${where}")
	public List<Operator> selectSize(SearchInfo info);
	
	//添加管理员
	@Insert("insert into activity_operator(nike,pass,name,type,tel,power,status,comments) values(#{nike},'3032B963A259075B964B07153D3C4B70',#{name},#{type},#{tel},#{power},#{status},#{comments})")
	public int insert(Operator o);
	
	//重置密码
	@Update("update activity_operator set pass='3032B963A259075B964B07153D3C4B70' where id=#{id}")
	public void updatePass(int id);
	
	//修改管理员信息
	@Update("update activity_operator set name=#{name},type=#{type},tel=#{tel},power=#{power},status=#{status},comments=#{comments} where id=#{id}")
	public void update(Operator oper);
	
	//
	@Select(value = "select * from activity_operator where id=#{id}")
	public Operator getById(int id); 
	
}
