package com.situ.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.situ.entity.Activity;
import com.situ.entity.Market;
import com.situ.entity.User;
import com.situ.service.Activity_Service;
import com.situ.service.Market_Service;
import com.situ.service.User_Service;
import com.situ.utils.CheckWorkSearchInfo;
import com.situ.utils.JsonInfo;
import com.situ.utils.UserSearchInfo;
@Controller
@RequestMapping("Activity_Market")
public class Market_Controller {
	@Autowired
	Market_Service mservice;
	@Autowired
	Activity_Service aservice;
	@Autowired
	User_Service uservice;
	
	
	
	//进入修改页面
		@RequestMapping("edit")
		@ResponseBody
		public ModelAndView edit(Market m,CheckWorkSearchInfo info) throws Exception {
			ModelAndView mv=new ModelAndView();
			
			int id = m.getId();
			Integer activity_id = m.getActivity_id();
			String date = m.getDate();
			m.setOperator_id(5);
			if (activity_id != null && date != null) {
				info.setWhere("where am.activity_id = " + activity_id + " and am.date='" + date + "'");
				List<Market> l = mservice.select(info);
				if (l.size() > 0) {
					mv.addObject("marketList", l.get(0));
				} else {
					m.setJson("[]");
					mservice.insert(m);
					List<Market> l2 = mservice.select(info);
					mv.addObject("marketList", l2.get(0));
				}
			} else {
			mv.addObject("marketList",mservice.getbyid(id));
			}
			
			mv.setViewName("activity_market/edit");
			return mv;
		}
	
	//json自动填充数据
	@RequestMapping("index_json")
	@ResponseBody
	public HashMap<String, Object> select(CheckWorkSearchInfo info) throws Exception {
		HashMap<String, Object> m = new HashMap<String, Object>();
		ArrayList<Market> list = new ArrayList<Market>();
		
		//获取条件
		Integer activityselect=info.getActivityselect();
		
		//拼接where
		if(activityselect==null) {
			info.setWhere(" where activity_id=(select max(activity_id) from activity_market) ");
		}else{
			info.setWhere(" where activity_id="+activityselect+" ");
		}
		
		//查询
		list = (ArrayList<Market>) mservice.select(info);
		int count = mservice.getcount(info);
		m.put("data", list);
		m.put("count", count);
		m.put("msg", "");
		m.put("code", 0);
		return m;
	}
	
	//json自动填充活动
	@RequestMapping("activity")
	@ResponseBody
	public List<Activity> school() throws Exception {
		return mservice.selectActivity();
	}
	
//修改
	@RequestMapping("update")
	@ResponseBody
	public JsonInfo update(Market c) {
		
		c.setOperator_id(1);
		mservice.update(c);
		return new JsonInfo(1,"");
	}
	
//获取学生
	@RequestMapping("userlist")
	@ResponseBody
	public List<User> userlist(Integer id,UserSearchInfo info) throws Exception {
		Market reportlist=mservice.getbyid(id);
				
		Activity activitylist=aservice.getbyid(reportlist.getActivity_id());
				
		String ids=activitylist.getUser_ids();
				
		info.setWhere(" where u.id in ("+ids+")");
				
		return uservice.select(info);
	}


}
