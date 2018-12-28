package com.situ.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.situ.entity.College;
import com.situ.entity.School;
import com.situ.service.College_Service;
import com.situ.service.School_Service;
import com.situ.utils.CollegeSearchInfo;
import com.situ.utils.JsonInfo;
@Controller
@RequestMapping("Activity_College")
public class College_Controller {
	@Autowired
	College_Service cservice;
	@Autowired
	School_Service sservice;
	
	
	//进入新增页面
	@RequestMapping("add")
	@ResponseBody
	public ModelAndView add(Integer school_id) throws Exception {
		ModelAndView mv=new ModelAndView();
		mv.addObject("schoolName", sservice.getbyid(school_id));
		mv.setViewName("activity_college/edit");
		return mv;
	}
	
	//进入修改页面
		@RequestMapping("edit")
		@ResponseBody
		public ModelAndView edit(Integer id) throws Exception {
			ModelAndView mv=new ModelAndView();
			mv.addObject("collegeList",cservice.getbyid(id));
			mv.setViewName("activity_college/edit");
			return mv;
		}
	
	//json自动填充数据
	@RequestMapping("index_json")
	@ResponseBody
	public HashMap<String, Object> select(CollegeSearchInfo info) throws Exception {
		HashMap<String, Object> m = new HashMap<String, Object>();
		ArrayList<College> list = new ArrayList<College>();
		
		//获取条件
		String name=info.getName();
		Integer select=info.getSelect();
		
		//拼接where
		if(select==null&&name==null) {
			info.setWhere("  where school_id=(select max(id) from activity_school) ");
		}else if(select!=null&&name==null){
			info.setWhere(" where school_id="+select+" ");
		}else if(select==null&&name!=null){
			info.setWhere(" where name like '%"+name+"%'");
		}else {
			info.setWhere(" where name like '%"+name+"%' and school_id="+select+"");
		}
		
		//查询
		list = (ArrayList<College>) cservice.select(info);
		int count = cservice.getcount(info);
		m.put("data", list);
		m.put("count", count);
		m.put("msg", "");
		m.put("code", 0);
		return m;
	}
	
	//json自动填充学校
	@RequestMapping("school")
	@ResponseBody
	public List<School> school() throws Exception {
		return sservice.selectall();
	}
	
	
	//新增
	@RequestMapping("insert")
	@ResponseBody
	public JsonInfo insert(College c) {
		cservice.insert(c);
		return new JsonInfo(1,"");
	}
	
//修改
	@RequestMapping("update")
	@ResponseBody
	public JsonInfo update(College c) {
		cservice.update(c);
		return new JsonInfo(1,"");
	}
		
//删除
	@RequestMapping("delete")
	@ResponseBody
	public JsonInfo delete(Integer id) {
		cservice.delete(id);
		return new JsonInfo(1,"");
	}

}
