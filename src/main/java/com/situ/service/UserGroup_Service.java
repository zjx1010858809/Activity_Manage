package com.situ.service;

import java.util.List;

import com.situ.entity.Activity;
import com.situ.entity.UserGroup;
import com.situ.utils.SearchInfo;

public interface UserGroup_Service {
	
	public List<Activity> selectActivity();
	
	public List<UserGroup> select(SearchInfo info);
	
	public void insert(UserGroup u);
	
	public void delete(int id);
	
	public void update(UserGroup u);
	
	public UserGroup getbyid(int id);
	
	public int getcount(SearchInfo info);
	
	public void upscore(UserGroup u);

}
