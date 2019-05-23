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
import com.situ.entity.College;
import com.situ.entity.School;
import com.situ.entity.User;
import com.situ.service.Activity_Service;
import com.situ.service.College_Service;
import com.situ.service.FeedBack_Service;
import com.situ.service.School_Service;
import com.situ.utils.ActivitySearchInfo;
import com.situ.utils.JsonInfo;

@Controller
@RequestMapping("Activity")
public class Activity_Controller {

	@Autowired
	Activity_Service service;

	@Autowired
	School_Service school_service;

	@Autowired
	College_Service college_service;

	@Autowired
	FeedBack_Service feedBack_service;

	@RequestMapping("index")
	@ResponseBody
	public HashMap<String, Object> selectAll(ActivitySearchInfo info) {
		HashMap<String, Object> m = new HashMap<String, Object>();
		String where;
		String whereSize;
		Integer type = info.getType();
		String school = info.getSchool();
		if (type != null) {
			where = "where a.type = " + type;
			whereSize = "where a.type = " + type;
		} else if (school != null) {
			where = "where a.school like '%" + school + "%'";
			whereSize = "where a.school like '%" + school + "%'";
		} else {
			where = "where a.type = 0";
			whereSize = "where a.type = 0";
		}

		// 数据详细
		info.setWhere(where);
		ArrayList<Activity> list = (ArrayList<Activity>) service.selectAll(info);
		// 数据总数
		info.setWhere(whereSize);
		int count = service.selectSize(info);

		// Response部分
		m.put("data", list);
		m.put("count", count);
		m.put("msg", "");
		m.put("code", 0);
		return m;
	}

	@RequestMapping("school")
	@ResponseBody
	public ArrayList<School> selectSchool() {
		ArrayList<School> listSchool = new ArrayList<School>();
		listSchool = (ArrayList<School>) school_service.selectall();
		return listSchool;
	}

	@RequestMapping("college")
	@ResponseBody
	public ArrayList<College> selectCollege(int school_id) {
		ArrayList<College> listCollege = new ArrayList<College>();
		listCollege = (ArrayList<College>) college_service.selectBySchool(school_id);
		return listCollege;
	}

	@RequestMapping("cancel")
	@ResponseBody
	public JsonInfo cancel(int id) {
		service.cancel(id);
		return new JsonInfo(0, "取消成功");
	}

	@RequestMapping("selectInSeven")
	@ResponseBody
	public List<Activity> selectInSeven() {
		List<Activity> list = service.selectInSeven();
		return list;
	}

	@RequestMapping("student")
	@ResponseBody
	public List<User> student(ActivitySearchInfo info) {
		String where = "";
		if (info.getIds() != null && info.getIds() != "") {
			where = "and id not in (" + info.getIds() + ")";
		}
		info.setWhere(where);
		ArrayList<User> list = new ArrayList<User>();
		list = (ArrayList<User>) service.student(info);
		return list;
	}

	@RequestMapping("activityStudent")
	@ResponseBody
	public HashMap<String, Object> activityStudent(ActivitySearchInfo info) {
		HashMap<String, Object> m = new HashMap<String, Object>();
		ArrayList<User> list = new ArrayList<User>();
		int count = 0;
		if (info.getAdd_ids() == "") {
			list = null;
		} else if (info.getAdd_ids() != null) {
			String where = "and au.id in (" + info.getAdd_ids() + ")";
			info.setWhere(where);
			list = (ArrayList<User>) service.activityStudent(info);
			count = list.size();
		} else if (info.getIds() == "") {
			list = null;
		} else if (info.getIds() != null) {
			// ids不为空时才有查询结果
			String where = "and au.id in (" + info.getIds() + ")";
			info.setWhere(where);
			list = (ArrayList<User>) service.activityStudent(info);
			count = list.size();
		}

		m.put("data", list);
		m.put("count", count);
		m.put("msg", "");
		m.put("code", 0);
		return m;
	}

	@RequestMapping("insert")
	@ResponseBody
	public JsonInfo insert(Activity activity) {
		activity.setInstructor_user_id(0);
		int i = service.insert(activity);
		if (i > 0) {
			return new JsonInfo(0, "新增成功");
		} else {
			return new JsonInfo(1, "新增异常");
		}
	}

	@RequestMapping("addStudent")
	@ResponseBody
	public Integer addStudents(Activity activity) {
		int i = service.addStudents(activity);
//		if (i > 0) {
//			// 每个参与活动的学生生成一张效果反馈表
//			FeedBack feedBack = new FeedBack();
//			FeedBack fexit = new FeedBack();
//			feedBack.setActivity_id(activity.getId());
//			String ids = activity.getUser_ids();
//			if (ids.length() > 0) {
//				String user_id[] = ids.split(",");
//				// 判断每个学生是否有学生反馈
//				for (int j = 0; j < user_id.length; j++) {
//					feedBack.setUser_id(Integer.valueOf(user_id[j]));
//					fexit = feedBack_service.ifExit(feedBack);
//					if (fexit == null) {
//						int m = feedBack_service.insert(feedBack);
//					} 
//				}
//			}
//			return 0;
//		} else {
//			return 1;
//		}
		return i;
	}

	@RequestMapping("Optioins")
	@ResponseBody
	public String option(int id) {
		return service.getOption(id);
	}

	@RequestMapping("setOptioins")
	@ResponseBody
	public JsonInfo setOptioins(Activity activity) {
		int i = service.setOption(activity);
		if (i > 0) {
			return new JsonInfo(0, "增加成功");
		} else {
			return new JsonInfo(1, "增加异常");
		}
	}

	@RequestMapping("edit")
	@ResponseBody
	public ModelAndView edit(int id, ActivitySearchInfo info) {
		info.setWhere("where a.id = " + id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("activity", service.selectAll(info).get(0));
		mv.setViewName("activity/edit");
		return mv;
	}
	
	@RequestMapping("update")
	public @ResponseBody JsonInfo update(Activity activity) {
		service.updateall(activity);
		return new JsonInfo(0, "修改成功");
	}
}
