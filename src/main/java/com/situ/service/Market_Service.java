package com.situ.service;

import java.util.List;

import com.situ.entity.Activity;
import com.situ.entity.Market;
import com.situ.utils.CheckWorkSearchInfo;

public interface Market_Service {
	
	public List<Activity> selectActivity();
	
	public List<Market> selectDate(int activity_id);
	
	public List<Market> select(CheckWorkSearchInfo info);
	
	public void insert(Market r);
	
	public void delete(int id);
	
	public void update(Market m);
	
	public Market getbyid(int id);
	
	public int getcount(CheckWorkSearchInfo info);

}
