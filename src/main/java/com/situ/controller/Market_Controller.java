package com.situ.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.situ.entity.Activity;
import com.situ.entity.Market;
import com.situ.service.Market_Service;
import com.situ.utils.CheckWorkSearchInfo;
import com.situ.utils.JsonInfo;
@Controller
@RequestMapping("Activity_Market")
public class Market_Controller {
	@Autowired
	Market_Service rservice;
	
	
	
	//进入修改页面
		@RequestMapping("edit")
		@ResponseBody
		public ModelAndView edit(Integer id) throws Exception {
			ModelAndView mv=new ModelAndView();
			mv.addObject("marketList",rservice.getbyid(id));
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
			info.setWhere(" where activity_id=(select max(id) from activity) ");
		}else{
			info.setWhere(" where activity_id="+activityselect+" ");
		}
		
		//查询
		list = (ArrayList<Market>) rservice.select(info);
		int count = rservice.getcount(info);
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
		return rservice.selectActivity();
	}
	
	//json自动填充时间
	@RequestMapping("date")
	@ResponseBody
	public List<Market> date(Integer activity_id) throws Exception {
		return rservice.selectDate(activity_id);
	}
	
	
//修改
	@RequestMapping("update")
	@ResponseBody
	public JsonInfo update(Market c) {
		
		c.setOperator_id(1);
		rservice.update(c);
		return new JsonInfo(1,"");
	}
	
	
	
//查看
	
	@RequestMapping("info_json")
	@ResponseBody
	public ModelAndView seeinfo(Integer id) throws Exception {
		ModelAndView mv=new ModelAndView();
		System.out.println(rservice.getbyid(id).getJson());
		
		String aaa=rservice.getbyid(id).getJson();
		
		System.out.println(JSON.parse(aaa));
		mv.addObject("infoList",rservice.getbyid(id));
		mv.setViewName("activity_market/infoView");
		return mv;
	}


}
