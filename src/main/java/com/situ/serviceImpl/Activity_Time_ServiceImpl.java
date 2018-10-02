package com.situ.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.entity.Activity_Time;
import com.situ.entity.Operator;
import com.situ.mapper.Activity_Time_Mapper;
import com.situ.service.Activity_Time_Service;
import com.situ.utils.ActivitySearchInfo;

@Service
public class Activity_Time_ServiceImpl implements Activity_Time_Service{

	@Autowired
	Activity_Time_Mapper mapper;

	@Override
	public List<Activity_Time> selectAll(ActivitySearchInfo info) {
		return mapper.selectAll(info);
	}

	@Override
	public List<Activity_Time> selectSize(ActivitySearchInfo info) {
		return mapper.selectSize(info);
	}

	@Override
	public List<Activity_Time> selectDetails(int id) {
		return mapper.selectDetails(id);
	}

	@Override
	public void updateStatus(Activity_Time acTime) {
		mapper.updateStatus(acTime);
	}

	@Override
	public int cancel(int id) {
		return mapper.cancel(id);
	}

	@Override
	public List<Operator> teacher() {
		return mapper.teacher();
	}

	@Override
	public int add(Activity_Time activity_Time) {
		return mapper.add(activity_Time);
	}

	@Override
	public int maxId() {
		return mapper.maxId();
	}

	@Override
	public Activity_Time selectById(int id) {
		return mapper.selectById(id);
	}

	@Override
	public int updateDetails(Activity_Time acTime) {
		return mapper.updateDetails(acTime);
	}

	@Override
	public List<Activity_Time> canlender() {
		return mapper.canlender();
	}
}
