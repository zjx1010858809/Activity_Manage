package com.situ.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.situ.entity.Activity;
import com.situ.entity.Activity_Time;
import com.situ.entity.Checkwork;
import com.situ.entity.Evaluation;
import com.situ.entity.Login;
import com.situ.service.Activity_Service;
import com.situ.service.Activity_Time_Service;
import com.situ.service.CheckWork_Service;
import com.situ.service.Evaluation_Service;
import com.situ.utils.ActivitySearchInfo;
import com.situ.utils.CheckWorkSearchInfo;
import com.situ.utils.JsonInfo;
@Controller
@RequestMapping("Activity_CheckWork")
public class CheckWork_Controller {
	@Autowired
	CheckWork_Service cservice;
	@Autowired
	Activity_Service aservice;
	@Autowired
	Activity_Time_Service atservice;
	@Autowired
	Evaluation_Service eservice;
	
	
	
	//进入修改页面
			@RequestMapping("edit")
			@ResponseBody
			public ModelAndView edit(Integer id) throws Exception {
				ModelAndView mv=new ModelAndView();
				mv.addObject("checkworkList",cservice.getbyid(id));
				mv.setViewName("activity_checkwork/edit");
				return mv;
			}
	
	//json自动填充数据
	@RequestMapping("index_json")
	@ResponseBody
	public HashMap<String, Object> select(CheckWorkSearchInfo info) throws Exception {
		HashMap<String, Object> m = new HashMap<String, Object>();
		ArrayList<Checkwork> list = new ArrayList<Checkwork>();
		
		//获取条件
		Integer activityselect=info.getActivityselect();
		String dateselect=info.getDateselect();
		
		//拼接where
		if(activityselect==null&&dateselect==null) {
			info.setWhere(" where ack.activity_id=(select max(id) from activity) and ack.date=(select max(date) from activity_checkwork) ");
		}else if(activityselect!=null&dateselect==""){
			info.setWhere(" where ack.activity_id="+activityselect+" ");
		}else if(activityselect!=null&dateselect!="") {
			info.setWhere(" where ack.activity_id="+activityselect+" and ack.date='"+dateselect+"' ");
		}
		
		//查询
		list = (ArrayList<Checkwork>) cservice.select(info);
		int count = cservice.getcount(info);
		m.put("data", list);
		m.put("count", count);
		m.put("msg", "");
		m.put("code", 0);
		return m;
	}
	
	//json自动填充个人数据
	@RequestMapping("singleindex_json")
	@ResponseBody
	public HashMap<String, Object> selectsingle(CheckWorkSearchInfo info,HttpSession session) throws Exception {
		HashMap<String, Object> m = new HashMap<String, Object>();
		ArrayList<Checkwork> list = new ArrayList<Checkwork>();
		
		Login user=(Login) session.getAttribute("registers");
		
		//获取条件
		Integer activityselect=info.getActivityselect();
		
		//拼接where
		if(activityselect==null) {
			info.setWhere(" where ack.activity_id=(select max(activity_id) from activity_evaluation where user_id="+user.getId()+") and ack.user_id="+user.getId()+" ");
		}else if(activityselect!=null){
			info.setWhere(" where ack.activity_id="+activityselect+" and ack.user_id="+user.getId()+" ");
		}
		
		//查询
		list = (ArrayList<Checkwork>) cservice.select(info);
		int count = cservice.getcount(info);
		m.put("data", list);
		m.put("count", count);
		m.put("msg", "");
		m.put("code", 0);
		return m;
	}
	
	//json自动填充活动
	@RequestMapping("activity")
	@ResponseBody
	public List<Activity> activity(ActivitySearchInfo info) throws Exception {
		info.setWhere(" order by a.id desc ");
		
		return aservice.selectAll(info);
	}
	
	//json自动填充个人活动
	@RequestMapping("singleactivity")
	@ResponseBody
	public List<Evaluation> singleactivity(CheckWorkSearchInfo info,HttpSession session) throws Exception {
		Login user=(Login) session.getAttribute("registers");
		
		info.setWhere(" where ae.user_id="+user.getId()+" group by ae.activity_id order by ae.activity_id desc ");
		
		return eservice.selectsingle(info);
	}
	
	//json自动填充时间
	@RequestMapping("date")
	@ResponseBody
	public List<Checkwork> date(CheckWorkSearchInfo info,Integer activity_id) throws Exception {
		if(activity_id==null) {
			
			info.setWhere(" where activity_id=(select max(activity_id) from activity_checkwork group by activity_id) group by date ");
			return cservice.selectDate(info);
		}else {
			
			info.setWhere(" where activity_id="+activity_id+" group by date ");
			return cservice.selectDate(info);
		}
	}
	
	
//修改
	@RequestMapping("update")
	@ResponseBody
	public JsonInfo update(Checkwork c) {
		
		c.setLastdate(new Date().toLocaleString());
		c.setOperator_id(1);
		cservice.update(c);
		return new JsonInfo(1,"");
	}

	
//批量考勤--分时段
	@RequestMapping("updatecheck")
	@ResponseBody
	public JsonInfo updatecheck(Checkwork c) {
		c.setLastdate(new Date().toLocaleString());
		c.setOperator_id(1);
		cservice.updatecheck(c);
		return new JsonInfo(1,"");
	}

//循环遍历--生成考勤表
	@RequestMapping("add")
	@ResponseBody
	public JsonInfo addcheck(Integer id,CheckWorkSearchInfo info) {
		
		Activity_Time atlist=atservice.selectById(id);
		
		Activity alist=aservice.getbyid(atlist.getActivity_id());
		
		String ids=alist.getUser_ids();
		
		String[] idss=ids.split(",");
		
		
		for(int i=0;i<idss.length;i++) {
			
			info.setWhere(" where ack.user_id="+idss[i]+" and ack.date='"+atlist.getDate()+"' and ack.activity_id="+atlist.getActivity_id()+" ");
			if(cservice.select(info).size()>0) {
			}else {
				Checkwork c=new Checkwork();
				
				c.setActivity_id(atlist.getActivity_id());
				c.setUser_id(Integer.parseInt(idss[i]));
				c.setDate(atlist.getDate());
				c.setLastdate(new Date().toLocaleString());
				c.setOperator_id(1);
				
				cservice.insert(c);
			}
		}
		return new JsonInfo(1,"");
	}
	
}
