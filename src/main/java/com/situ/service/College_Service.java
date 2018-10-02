package com.situ.service;

import java.util.List;

import com.situ.entity.College;
import com.situ.utils.SearchInfo;

public interface College_Service {
	
	public List<College> select(SearchInfo info);
	
	public void insert(College c);
	
	public void delete(int id);
	
	public void update(College c);
	
	public College getbyid(int id);
	
	public int getcount(SearchInfo info);
	
	public List<College> selectBySchool(int school_id);

}
