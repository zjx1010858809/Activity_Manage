package com.situ.service;

import java.util.List;

import com.situ.entity.Activity;
import com.situ.entity.Activity_Time;
import com.situ.entity.FeedBack;
import com.situ.utils.FeedBackSearchInfo;

public interface FeedBack_Service {
	public FeedBack ifExit(FeedBack feedBack);
	public int insert(FeedBack feedBack);
	public List<FeedBack> selectAll(FeedBackSearchInfo info);
	public int selectMax(FeedBackSearchInfo info);
	public int selectSize(FeedBackSearchInfo info);
	public List<Activity> activity(FeedBackSearchInfo info);
	public int updateStatus(FeedBack feedBack);
	public FeedBack selectById(int id);
	public int updateResult(FeedBack feedBack);
	public List<Activity_Time> selectByAcid(int activity_id);
	public int selectMaxDate(int activity_id);
	public List<FeedBack> selectByUserid(int user_id);
	public int userSize(int user_id);
}
