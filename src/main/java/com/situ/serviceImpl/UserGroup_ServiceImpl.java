package com.situ.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.entity.Activity;
import com.situ.entity.UserGroup;
import com.situ.mapper.UserGroup_Mapper;
import com.situ.service.UserGroup_Service;
import com.situ.utils.SearchInfo;
@Service
public class UserGroup_ServiceImpl implements UserGroup_Service {
	@Autowired
	UserGroup_Mapper umapper;

	@Override
	public List<UserGroup> select(SearchInfo info) {
		return umapper.select(info);
	}

	@Override
	public void insert(UserGroup u) {
		umapper.insert(u);
	}

	@Override
	public void delete(int id) {
		umapper.delete(id);
	}

	@Override
	public void update(UserGroup u) {
		umapper.update(u);
	}

	@Override
	public UserGroup getbyid(int id) {
		return umapper.getbyid(id);
	}

	@Override
	public int getcount(SearchInfo info) {
		return umapper.getcount(info);
	}

	@Override
	public List<Activity> selectActivity() {
		return umapper.selectActivity();
	}

	@Override
	public void upscore(UserGroup u) {
		umapper.upscore(u);
	}
	

	
	

}
