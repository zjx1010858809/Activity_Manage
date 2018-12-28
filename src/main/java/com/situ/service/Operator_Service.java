package com.situ.service;

import java.util.List;

import com.situ.entity.Operator;
import com.situ.utils.SearchInfo;

public interface Operator_Service {
	public List<Operator> selectall();
	
	public List<Operator> index(SearchInfo info);
	
	public List<Operator> selectSize(SearchInfo info);
	
	public int insert(Operator o);
	
	public void updatePass(int id);
	
	public void update(Operator oper);
	
	public Operator getById(int id); 
	
}
