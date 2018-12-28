package com.situ.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.situ.entity.Activity;
import com.situ.entity.Activity_Time;
import com.situ.entity.FeedBack;
import com.situ.entity.Login;
import com.situ.service.Activity_Service;
import com.situ.service.FeedBack_Service;
import com.situ.utils.FeedBackSearchInfo;

@Controller

@RequestMapping("FeedBack")
public class FeedBack_Controller {
	@Autowired
	FeedBack_Service service;
	@Autowired
	Activity_Service activity_service;
	
	@RequestMapping("info")
	@ResponseBody
	public HashMap<String, Object> selectAll(FeedBackSearchInfo info) {
		HashMap<String,Object> m = new HashMap<String,Object>();
		String where="";
		//活动，获取id最大的
		int max = service.selectMax(info);
		//活动日期，获取当前活动日期最大的
		int ac_time_id = service.selectMaxDate(max);
		where = "where af.activity_time_id = " + ac_time_id;
		if(info.getActivity_time_id() != null) {
			where = "where af.activity_time_id = " + info.getActivity_time_id();
		}
		info.setWhere(where);
		
		// 数据详细
		ArrayList<FeedBack> list = (ArrayList<FeedBack>) service.selectAll(info);
		
		// 数据总数
		int count = service.selectSize(info);
		
		// Response部分
		m.put("data", list);
		m.put("count", count);
		m.put("msg", "");
		m.put("code", 0);
		return m;
	}
	
	@RequestMapping("activity")
	@ResponseBody
	public List<Activity> activity(FeedBackSearchInfo info){
		List<Activity> list = activity_service.selectInSeven();
		return list;
	}
	
	@RequestMapping("date")
	@ResponseBody
	public List<Activity_Time> date(int activity_id){
		List<Activity_Time> list = service.selectByAcid(activity_id);
		return list;
	}
	
	@RequestMapping("status")
	@ResponseBody
	public int status(FeedBack feedBack) {
		int i = service.updateStatus(feedBack);
		if(i>0) {
			return 0;
		}else {
			return 1;
		}		
	}
	
	@RequestMapping("result")
	@ResponseBody
	public int result(FeedBack feedBack) {
		int i = service.updateResult(feedBack);
		if(i>0) {
			return 0;
		}else {
			return 1;
		}		
	}
	
	@RequestMapping("ById")
	@ResponseBody
	public FeedBack ById(int id) {
		FeedBack feedBack = service.selectById(id);
		return feedBack;
	}
	
	@RequestMapping("User")
	@ResponseBody
	public HashMap<String, Object> user(HttpSession session){
		HashMap<String, Object> m = new HashMap<String, Object>();
		Login user = (Login) session.getAttribute("user");
		int user_id = user.getId();
		//数据
		ArrayList<FeedBack> list = (ArrayList<FeedBack>) service.selectByUserid(user_id);
		//数据尺寸
		int count = service.userSize(user_id);
		m.put("data", list);
		m.put("count", count);
		m.put("msg", "");
		m.put("code", 0);
		return m;
	}
	
}
