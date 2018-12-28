package com.situ.service;

import java.util.List;

import com.situ.entity.Activity;
import com.situ.entity.Notice;
import com.situ.entity.Operator;
import com.situ.utils.SearchInfo;

public interface Notice_Service {
	
	public List<Notice> select(SearchInfo info);

	public List<Notice> selectSize(SearchInfo info);

	public int insert(Notice n);

	public int update(Notice n);
	
	public int delete(int id);

	public Notice getById(int id);
	
	public List<Activity> selectActivity();
	
	public List<Operator> selectOperator();
}
