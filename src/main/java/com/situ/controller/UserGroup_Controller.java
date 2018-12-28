package com.situ.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.situ.entity.Activity;
import com.situ.entity.User;
import com.situ.entity.UserGroup;
import com.situ.service.Activity_Service;
import com.situ.service.Operator_Service;
import com.situ.service.UserGroup_Service;
import com.situ.service.User_Service;
import com.situ.utils.CollegeSearchInfo;
import com.situ.utils.JsonInfo;
import com.situ.utils.SearchInfo;
import com.situ.utils.UserSearchInfo;
@Controller
@RequestMapping("Activity_UserGroup")
public class UserGroup_Controller {
	@Autowired
	UserGroup_Service ugservice;
	@Autowired
	Operator_Service oservice;
	@Autowired
	Activity_Service aservice;
	@Autowired
	User_Service uservice;
	
	
	//进入新增页面
	@RequestMapping("add")
	@ResponseBody
	public ModelAndView add(Integer activity_id,UserSearchInfo info) throws Exception {
		ModelAndView mv=new ModelAndView();
		//获取活动中所有成员
		Activity list=aservice.getbyid(activity_id);
		info.setWhere(" where u.id in("+list.getUser_ids()+")");
		List<User> userList=uservice.select(info);
		
		mv.addObject("userList",userList);
		mv.addObject("activityList",list);
		mv.setViewName("activity_usergroup/edit");
		return mv;
	}
	
	//进入修改页面
	@RequestMapping("edit")
	@ResponseBody
	public ModelAndView edit(Integer id,UserSearchInfo info) throws Exception {
		ModelAndView mv=new ModelAndView();
		UserGroup usergroup=ugservice.getbyid(id);
		//获取活动中所有成员
		Activity list=aservice.getbyid(usergroup.getActivity_id());
		info.setWhere(" where u.id in("+list.getUser_ids()+")");
		List<User> userList=uservice.select(info);
		
		mv.addObject("userList",userList);
		mv.addObject("usergroupList",usergroup);
		mv.setViewName("activity_usergroup/edit");
		return mv;
	}
		
	//进入打分页面
	@RequestMapping("score")
	@ResponseBody
	public ModelAndView score(Integer id,SearchInfo info) throws Exception {
		ModelAndView mv=new ModelAndView();
		mv.addObject("usergroupList",ugservice.getbyid(id));
		mv.setViewName("activity_usergroup/score");
		return mv;
	}
	
	//进入详情页面
	@RequestMapping("details")
	@ResponseBody
	public ModelAndView details(Integer id,UserSearchInfo info) throws Exception {
		ModelAndView mv=new ModelAndView();
		UserGroup usergroup=ugservice.getbyid(id);
		//获取活动中所有成员
		Activity list=aservice.getbyid(usergroup.getActivity_id());
		info.setWhere(" where u.id in("+list.getUser_ids()+")");
		List<User> userList=uservice.select(info);
		
		mv.addObject("userList",userList);
		mv.addObject("usergroupList",usergroup);
		mv.setViewName("activity_usergroup/details");
		return mv;
	}
	
	//json自动填充数
	@RequestMapping("index_json")
	@ResponseBody
	public HashMap<String, Object> select(CollegeSearchInfo info) throws Exception {
		HashMap<String, Object> m = new HashMap<String, Object>();
		ArrayList<UserGroup> list = new ArrayList<UserGroup>();
		
		//获取查询条件
		String name=info.getName();
		Integer select=info.getSelect();
		
		//拼接where
		if(select==null&&name==null) {
			info.setWhere(" where activity_id=(select max(id) from activity) ");
		}else if(select!=null&&name==null){
			info.setWhere(" where activity_id="+select+" ");
		}else if(select==null&&name!=null){
			info.setWhere(" where au.name like '%"+name+"%'");
		}else {
			info.setWhere(" where au.name like '%"+name+"%' and activity_id="+select+"");
		}
		//查询
		list = (ArrayList<UserGroup>) ugservice.select(info);
		
		int count = ugservice.getcount(info);
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
		return ugservice.selectActivity();
	}
	
	
	//新增
	@RequestMapping("insert")
	@ResponseBody
	public JsonInfo insert(UserGroup u) {
		u.setCreatedate(new Date().toLocaleString());
		u.setOperator_id(1);
		
		ugservice.insert(u);
		return new JsonInfo(1,"");
	}
	
//修改
	@RequestMapping("update")
	@ResponseBody
	public JsonInfo update(UserGroup u) {
		ugservice.update(u);
		return new JsonInfo(1,"");
	}
		
//删除
	@RequestMapping("delete")
	@ResponseBody
	public JsonInfo delete(Integer id) {
		ugservice.delete(id);
		return new JsonInfo(1,"");
	}
	
//打分
	@RequestMapping("upscore")
	@ResponseBody
	public JsonInfo score(UserGroup u) {
		ugservice.upscore(u);
		return new JsonInfo(1,"");
	}


}
