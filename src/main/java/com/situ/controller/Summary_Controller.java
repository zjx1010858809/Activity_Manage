package com.situ.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.situ.entity.Activity;
import com.situ.entity.Evaluation;
import com.situ.entity.Login;
import com.situ.entity.Operator;
import com.situ.entity.Summary;
import com.situ.service.Activity_Service;
import com.situ.service.Evaluation_Service;
import com.situ.service.Operator_Service;
import com.situ.service.Summary_Service;
import com.situ.utils.JsonInfo;
import com.situ.utils.OperatorInfo;
import com.situ.utils.SearchInfo;
import com.situ.utils.SummarySearchInfo;
@Controller
@RequestMapping("Activity_Summary")
public class Summary_Controller {
	@Autowired
	Summary_Service rservice;
	@Autowired
	Operator_Service oservice;
	@Autowired
	Activity_Service aservice;
	@Autowired
	Evaluation_Service eservice;
	
	//进入新增页面
		@RequestMapping("add")
		@ResponseBody
		public ModelAndView add() throws Exception {
			ModelAndView mv=new ModelAndView();
			mv.addObject("activityList", rservice.selectActivity());
			mv.setViewName("activity_summary/edit");
			return mv;
		}
	
	//进入修改页面
		@RequestMapping("edit")
		@ResponseBody
		public ModelAndView edit(Integer id) throws Exception {
			ModelAndView mv=new ModelAndView();
			mv.addObject("summaryList",rservice.getbyid(id));
			mv.setViewName("activity_summary/edit");
			return mv;
		}
	
	//json自动填充数据
	@RequestMapping("index_json")
	@ResponseBody
	public HashMap<String, Object> select(SummarySearchInfo info) throws Exception {
		HashMap<String, Object> m = new HashMap<String, Object>();
		ArrayList<Summary> list = new ArrayList<Summary>();
		
		//获取条件
		Integer operatorselect=info.getOperatorselect();
		String dateselect=info.getDateselect();
		
		
		//拼接where
		if(operatorselect==null&&dateselect=="") {
			info.setWhere("");
		}else if(operatorselect==null&&dateselect==null) {
			info.setWhere("");
		}else if(operatorselect!=null&&dateselect==""){
			info.setWhere(" where asu.operator_id="+operatorselect+" ");
		}else if(operatorselect==null&&dateselect!="") {
			info.setWhere(" where asu.createdate='"+dateselect+"' ");
		}else if(operatorselect!=null&&dateselect!=""){
			info.setWhere(" where asu.operator_id="+operatorselect+" and asu.createdate='"+dateselect+"' ");
		}
		
		//查询
		list = (ArrayList<Summary>) rservice.select(info);
		int count = rservice.getcount(info);
		m.put("data", list);
		m.put("count", count);
		m.put("msg", "");
		m.put("code", 0);
		return m;
	}
	
//json自动填充活动
	@RequestMapping("operator")
	@ResponseBody
	public List<Operator> school(OperatorInfo info){
		String where="";
		where = "where type = 0 ";
		info.setWhere(where);
		List<Operator> l = oservice.index(info);
		return l;
	}

//新增
	@RequestMapping("insert")
	@ResponseBody
	public JsonInfo insert(Summary c,HttpSession session) {
		
		Login oper=(Login) session.getAttribute("registers");
		c.setOperator_id(oper.getId());
		
		rservice.insert(c);
		return new JsonInfo(1,"");
	}
	
//修改
	@RequestMapping("update")
	@ResponseBody
	public JsonInfo update(Summary c) {
		c.setOperator_id(1);
		rservice.update(c);
		return new JsonInfo(1,"");
	}
	
//生成测评表
	@RequestMapping("evaluation")
	@ResponseBody
	public JsonInfo addevaluation(Integer id,SearchInfo info) {
	//获取活动中所有学生
		Activity userList=aservice.getbyid(id);
		String[] user=userList.getUser_ids().split(",");
	//循环判断
		
		for(int i=0;i<user.length;i++) {
			info.setWhere(" where ae.activity_id="+id+" and user_id="+Integer.parseInt(user[i])+"");
			if(eservice.index(info).size()>0) {
				continue;
			}else {
	//新增
				Evaluation n=new Evaluation();
				n.setActivity_id(id);
				n.setUser_id(Integer.parseInt(user[i]));
				
				eservice.insert(n);
			}
		}
		return new JsonInfo(1,"");
	}
	
	
//查看
	
	@RequestMapping("info_json")
	@ResponseBody
	public ModelAndView seeinfo(Integer id) throws Exception {
		ModelAndView mv=new ModelAndView();
		mv.addObject("activityList", rservice.selectActivity());
		mv.addObject("infoList",rservice.getbyid(id));
		mv.setViewName("activity_summary/infoView");
		return mv;
	}


}
