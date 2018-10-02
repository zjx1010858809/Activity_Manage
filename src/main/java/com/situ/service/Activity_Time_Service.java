package com.situ.service;

import java.util.List;

import com.situ.entity.Activity_Time;
import com.situ.entity.Operator;
import com.situ.utils.ActivitySearchInfo;

public interface Activity_Time_Service {
	public List<Activity_Time> selectAll(ActivitySearchInfo info);
	public List<Activity_Time> selectSize(ActivitySearchInfo info);
	public List<Activity_Time> selectDetails(int id);
	public void updateStatus(Activity_Time acTime);
	public int cancel(int id);
	public List<Operator> teacher();
	public int add(Activity_Time activity_Time);
	public int maxId();
	public Activity_Time selectById(int id);
	public int updateDetails(Activity_Time acTime);
	public List<Activity_Time> canlender();

}
