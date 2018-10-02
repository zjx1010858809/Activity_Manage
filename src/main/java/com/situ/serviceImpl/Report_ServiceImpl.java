package com.situ.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.entity.Activity;
import com.situ.entity.Report;
import com.situ.mapper.Report_Mapper;
import com.situ.service.Report_Service;
import com.situ.utils.CheckWorkSearchInfo;
@Service
public class Report_ServiceImpl implements Report_Service {
	@Autowired
	Report_Mapper rmapper;

	@Override
	public List<Activity> selectActivity() {
		return rmapper.selectActivity();
	}

	@Override
	public List<Report> selectDate(int activity_id) {
		return rmapper.selectDate(activity_id);
	}

	@Override
	public List<Report> select(CheckWorkSearchInfo info) {
		return rmapper.select(info);
	}

	@Override
	public void insert(Report r) {
		rmapper.insert(r);
	}

	@Override
	public void delete(int id) {
		rmapper.delete(id);
	}

	@Override
	public void update(Report r) {
		rmapper.update(r);
	}

	@Override
	public Report getbyid(int id) {
		return rmapper.getbyid(id);
	}

	@Override
	public int getcount(CheckWorkSearchInfo info) {
		return rmapper.getcount(info);
	}

}
