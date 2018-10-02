package com.situ.serviceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.situ.entity.Activity;
import com.situ.entity.User;
import com.situ.mapper.Activity_Mapper;
import com.situ.mapper.Activity_Time_Mapper;
import com.situ.service.Activity_Service;
import com.situ.utils.ActivitySearchInfo;

@Service
public class Activity_ServiceImpl implements Activity_Service{
	
	@Autowired
	Activity_Mapper dao;
	
	@Autowired
	Activity_Time_Mapper time_dao;

	@Override
	public List<Activity> selectAll(ActivitySearchInfo info) {
		return dao.selectAll(info);
	}

	@Override
	public int selectSize(ActivitySearchInfo info) {
		return dao.selectSize(info);
	}

	@Override
	@Transactional
	public void cancel(int id) {
		dao.cancel(id);
		time_dao.cancelByActivity(id);
	}

	@Override
	public Activity getbyid(int id) {
		return dao.getbyid(id);
	}

	@Override
	public int insert(Activity activity) {
		return dao.insert(activity);
	}

	@Override
	public int addStudents(Activity activity) {
		return dao.addStudents(activity);
	}

	@Override
	public List<Activity> selectInSeven() {
		return dao.selectInSeven();
	}

	@Override
	public List<User> student(ActivitySearchInfo info) {
		return dao.student(info);
	}

	@Override
	public List<User> activityStudent(ActivitySearchInfo info) {
		return dao.activityStudent(info);
	}

	@Override
	public String getOption(int id) {
		return dao.getOption(id);
	}

	@Override
	public int setOption(Activity activity) {
		return dao.setOption(activity);
	}

}
