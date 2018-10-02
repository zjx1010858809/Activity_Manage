package com.situ.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.entity.Activity;
import com.situ.entity.Summary;
import com.situ.mapper.Summary_Mapper;
import com.situ.service.Summary_Service;
import com.situ.utils.SummarySearchInfo;
@Service
public class Summary_ServiceImpl implements Summary_Service {
	@Autowired
	Summary_Mapper smapper;

	@Override
	public List<Activity> selectActivity() {
		return smapper.selectActivity();
	}

	@Override
	public List<Summary> selectDate(int activity_id) {
		return smapper.selectDate(activity_id);
	}

	@Override
	public List<Summary> select(SummarySearchInfo info) {
		return smapper.select(info);
	}

	@Override
	public void insert(Summary r) {
		smapper.insert(r);
	}

	@Override
	public void delete(int id) {
		smapper.delete(id);
	}

	@Override
	public void update(Summary r) {
		smapper.update(r);
	}

	@Override
	public Summary getbyid(int id) {
		return smapper.getbyid(id);
	}

	@Override
	public int getcount(SummarySearchInfo info) {
		return smapper.getcount(info);
	}
	

}
