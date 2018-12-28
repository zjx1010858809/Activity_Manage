package com.situ.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.entity.Activity;
import com.situ.entity.Market;
import com.situ.mapper.Market_Mapper;
import com.situ.service.Market_Service;
import com.situ.utils.CheckWorkSearchInfo;
@Service
public class Market_ServiceImpl implements Market_Service {
	@Autowired
	Market_Mapper mmapper;

	@Override
	public List<Activity> selectActivity() {
		return mmapper.selectActivity();
	}

	@Override
	public List<Market> selectDate(int activity_id) {
		return mmapper.selectDate(activity_id);
	}

	@Override
	public List<Market> select(CheckWorkSearchInfo info) {
		return mmapper.select(info);
	}

	@Override
	public void insert(Market m) {
		mmapper.insert(m);
	}

	@Override
	public void delete(int id) {
		mmapper.delete(id);
	}

	@Override
	public void update(Market m) {
		mmapper.update(m);
	}

	@Override
	public Market getbyid(int id) {
		return mmapper.getbyid(id);
	}

	@Override
	public int getcount(CheckWorkSearchInfo info) {
		return mmapper.getcount(info);
	}
	

}
