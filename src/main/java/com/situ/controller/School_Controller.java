package com.situ.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.situ.entity.School;
import com.situ.service.School_Service;
import com.situ.utils.CollegeSearchInfo;
import com.situ.utils.JsonInfo;
import com.situ.utils.SearchInfo;

@Controller
@RequestMapping("Activity_School")
public class School_Controller {
	@Autowired
	School_Service sservice;
	
	//进入正文
		@RequestMapping("index")
		public ModelAndView def() throws Exception {
			ModelAndView mv=new ModelAndView();
			mv.setViewName("activity_school/index");
			return mv;
		}
		//进入新增页面
		@RequestMapping("add")
		@ResponseBody
		public ModelAndView add(SearchInfo info) throws Exception {
			ModelAndView mv=new ModelAndView();
			mv.setViewName("activity_school/edit");
			return mv;
		}
		
		//进入修改页面
			@RequestMapping("edit")
			@ResponseBody
			public ModelAndView edit(Integer id,SearchInfo info) throws Exception {
				ModelAndView mv=new ModelAndView();
				mv.addObject("schoolList",sservice.getbyid(id));
				mv.setViewName("activity_school/edit");
				return mv;
			}
		
		//json自动填充数据
		@RequestMapping("index_json")
		@ResponseBody
		public HashMap<String, Object> select(CollegeSearchInfo info) throws Exception {
			HashMap<String, Object> m = new HashMap<String, Object>();
			ArrayList<School> list = new ArrayList<School>();
			//获取条件
			String name=info.getName();
			
			//拼接where
			if(name==null) {
				info.setWhere(" where id not in(1)");
			}else {
				info.setWhere(" where name like '%"+name+"%' and id not in(1)");
			}
			
			//查询
			list = (ArrayList<School>) sservice.select(info);
			int count = sservice.getcount(info);
			m.put("data", list);
			m.put("count", count);
			m.put("msg", "");
			m.put("code", 0);
			return m;
		}
		
		//新增
		@RequestMapping("insert")
		@ResponseBody
		public JsonInfo insert(School s) {
			sservice.insert(s);
			return new JsonInfo(1,"");
		}
		
	//修改
		@RequestMapping("update")
		@ResponseBody
		public JsonInfo update(School s) {
			sservice.update(s);
			return new JsonInfo(1,"");
		}
			
	//删除
		@RequestMapping("delete")
		@ResponseBody
		public JsonInfo delete(Integer id) {
			sservice.delete(id);
			return new JsonInfo(1,"");
		}
	
	
	

}
