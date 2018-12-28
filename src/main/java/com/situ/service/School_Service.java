package com.situ.service;

import java.util.List;

import com.situ.entity.School;
import com.situ.utils.SearchInfo;

public interface School_Service {
	public List<School> selectall();
	
	public List<School> select(SearchInfo info);
	
	public void insert(School s);
	
	public void delete(int id);
	
	public void update(School s);
	
	public School getbyid(int id);
	
	public int getcount(SearchInfo info);

}
