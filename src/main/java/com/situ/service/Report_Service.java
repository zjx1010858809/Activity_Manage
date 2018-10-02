package com.situ.service;

import java.util.List;

import com.situ.entity.Activity;
import com.situ.entity.Report;
import com.situ.utils.CheckWorkSearchInfo;

public interface Report_Service {
	
	public List<Activity> selectActivity();
	
	public List<Report> selectDate(int activity_id);
	
	public List<Report> select(CheckWorkSearchInfo info);
	
	public void insert(Report r);
	
	public void delete(int id);
	
	public void update(Report r);
	
	public Report getbyid(int id);
	
	public int getcount(CheckWorkSearchInfo info);

}
