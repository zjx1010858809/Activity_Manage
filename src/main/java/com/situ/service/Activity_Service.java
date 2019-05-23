package com.situ.service;

import java.util.List;

import com.situ.entity.Activity;
import com.situ.entity.User;
import com.situ.utils.ActivitySearchInfo;

public interface Activity_Service {
public List<Activity> selectAll(ActivitySearchInfo info);
	
	public int selectSize(ActivitySearchInfo info);
	
	public List<Activity> selectInSeven();
	
	public List<User> student(ActivitySearchInfo info);

	public List<User> activityStudent(ActivitySearchInfo info);
	
	public void cancel(int id);
	
	public int insert(Activity activity);
	
	public int addStudents(Activity activity);
	
	public Activity getbyid(int id);
	
	public String getOption(int id);
	
	public int setOption(Activity activity);
	
	public void updateall(Activity activity);

}
