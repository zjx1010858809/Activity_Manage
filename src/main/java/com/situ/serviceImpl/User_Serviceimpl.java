package com.situ.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.entity.College;
import com.situ.entity.School;
import com.situ.entity.User;
import com.situ.mapper.User_Mapper;
import com.situ.service.User_Service;
import com.situ.utils.UserSearchInfo;

@Service
public class User_Serviceimpl implements User_Service {

	@Autowired
	User_Mapper mapper;

	@Override
	public List<User> select(UserSearchInfo info) {
		return mapper.select(info);
	}

	@Override
	public List<User> selectSize(UserSearchInfo info) {
		return mapper.selectSize(info);
	}

	@Override
	public int delete() {
		return mapper.delete();
	}

	@Override
	public List<College> selectCollege(int school_id) {
		return mapper.selectCollege(school_id);
	}

	@Override
	public int insert(User u) {
		return mapper.insert(u);
	}

	@Override
	public User getById(int id) {
		return mapper.getById(id);
	}

	@Override
	public int studentUpdate(User u) {
		return mapper.studentUpdate(u);
	}

	@Override
	public int teacherUpdate(User u) {
		return mapper.teacherUpdate(u);
	}

}
