package com.situ.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.entity.Activity;
import com.situ.entity.Activity_Time;
import com.situ.entity.FeedBack;
import com.situ.mapper.FeedBack_Mapper;
import com.situ.service.FeedBack_Service;
import com.situ.utils.FeedBackSearchInfo;

@Service
public class FeedBack_ServiceImpl implements FeedBack_Service{
	@Autowired
	FeedBack_Mapper mapper;

	@Override
	public FeedBack ifExit(FeedBack feedBack) {
		return mapper.ifExit(feedBack);
	}

	@Override
	public int insert(FeedBack feedBack) {
		return mapper.insert(feedBack);
	}

	@Override
	public int selectMax(FeedBackSearchInfo info) {
		return mapper.selectMax(info);
	}

	@Override
	public List<FeedBack> selectAll(FeedBackSearchInfo info) {
		return mapper.selectAll(info);
	}

	@Override
	public int selectSize(FeedBackSearchInfo info) {
		return mapper.selectSize(info);
	}

	@Override
	public List<Activity> activity(FeedBackSearchInfo info) {
		return mapper.activity(info);
	}

	@Override
	public int updateStatus(FeedBack feedBack) {
		return mapper.updateStatus(feedBack);
	}

	@Override
	public FeedBack selectById(int id) {
		return mapper.selectById(id);
	}

	@Override
	public int updateResult(FeedBack feedBack) {
		return mapper.updateResult(feedBack);
	}

	@Override
	public List<Activity_Time> selectByAcid(int activity_id) {
		return mapper.selectByAcid(activity_id);
	}

	@Override
	public int selectMaxDate(int activity_id) {
		return mapper.selectMaxDate(activity_id);
	}
	
	@Override
	public List<FeedBack> selectByUserid(int user_id) {
		return mapper.selectByUserid(user_id);
	}

	@Override
	public int userSize(int user_id) {
		return mapper.userSize(user_id);
	}
}
