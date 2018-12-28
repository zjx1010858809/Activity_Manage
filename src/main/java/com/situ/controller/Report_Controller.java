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
import com.situ.entity.Report;
import com.situ.entity.User;
import com.situ.service.Activity_Service;
import com.situ.service.Report_Service;
import com.situ.service.User_Service;
import com.situ.utils.CheckWorkSearchInfo;
import com.situ.utils.JsonInfo;
import com.situ.utils.UserSearchInfo;

@Controller
@RequestMapping("Activity_Report")
public class Report_Controller {
	@Autowired
	Report_Service rservice;
	@Autowired
	Activity_Service aservice;
	@Autowired
	User_Service uservice;

	// 进入修改页面
	@RequestMapping("edit")
	@ResponseBody
	public ModelAndView edit(Report r, CheckWorkSearchInfo info) throws Exception {
		ModelAndView mv = new ModelAndView();
		int id = r.getId();
		Integer activity_id = r.getActivity_id();
		String date = r.getDate();
		r.setOperator_id(5);
		if (activity_id != null && date != null) {
			info.setWhere("where ar.activity_id = " + activity_id + " and ar.date='" + date + "'");
			List<Report> l = rservice.select(info);
			if (l.size() > 0) {
				mv.addObject("reportList", l.get(0));
			} else {
				r.setJson("[]");
				rservice.insert(r);
				List<Report> l2 = rservice.select(info);
				mv.addObject("reportList", l2.get(0));
			}
		} else {
			mv.addObject("reportList", rservice.getbyid(id));
		}

		mv.setViewName("activity_report/edit");
		return mv;
	}

	// json自动填充数据
	@RequestMapping("index_json")
	@ResponseBody
	public HashMap<String, Object> select(CheckWorkSearchInfo info) throws Exception {
		HashMap<String, Object> m = new HashMap<String, Object>();
		ArrayList<Report> list = new ArrayList<Report>();

		// 获取条件
		Integer activityselect = info.getActivityselect();

		// 拼接where
		if (activityselect == null) {
			info.setWhere(" where activity_id=(select max(id) from activity) ");
		} else {
			info.setWhere(" where activity_id=" + activityselect + " ");
		}

		// 查询
		list = (ArrayList<Report>) rservice.select(info);
		int count = rservice.getcount(info);
		m.put("data", list);
		m.put("count", count);
		m.put("msg", "");
		m.put("code", 0);
		return m;
	}

	// json自动填充活动
	@RequestMapping("activity")
	@ResponseBody
	public List<Activity> school() throws Exception {
		return rservice.selectActivity();
	}

	// 修改
	@RequestMapping("update")
	@ResponseBody
	public JsonInfo update(Report r) {

		r.setOperator_id(1);
		rservice.update(r);
		return new JsonInfo(1, "");
	}

	//获取学生
		@RequestMapping("userlist")
		@ResponseBody
		public List<User> userlist(Integer id,UserSearchInfo info) throws Exception {
			Report reportlist=rservice.getbyid(id);
			
			Activity activitylist=aservice.getbyid(reportlist.getActivity_id());
			
			String ids=activitylist.getUser_ids();
			
			info.setWhere(" where u.id in ("+ids+")");
			
			return uservice.select(info);
		}
		
		
}
