package com.situ.service;

import java.util.List;

import com.situ.entity.College;
import com.situ.entity.User;
import com.situ.utils.UserSearchInfo;

public interface User_Service {
	public List<User> select(UserSearchInfo info);
	public List<User> selectSize(UserSearchInfo info);
	public int insert(User u);
	public int studentUpdate(User u);
	public int teacherUpdate(User u);
	public List<College> selectCollege(int school_id);
	public int delete();
	public User getById(int id);
}
