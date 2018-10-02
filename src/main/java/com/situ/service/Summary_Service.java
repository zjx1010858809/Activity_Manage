package com.situ.service;

import java.util.List;

import com.situ.entity.Activity;
import com.situ.entity.Summary;
import com.situ.utils.SummarySearchInfo;

public interface Summary_Service {
	
	public List<Activity> selectActivity();
	
	public List<Summary> selectDate(int activity_id);
	
	public List<Summary> select(SummarySearchInfo info);
	
	public void insert(Summary r);
	
	public void delete(int id);
	
	public void update(Summary r);
	
	public Summary getbyid(int id);
	
	public int getcount(SummarySearchInfo info);

}
