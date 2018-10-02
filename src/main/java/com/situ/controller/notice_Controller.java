package com.situ.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.situ.entity.Notice;
import com.situ.entity.Operator;
import com.situ.entity.Activity;
import com.situ.service.Notice_Service;
import com.situ.utils.JsonInfo;
import com.situ.utils.SearchInfo;

@Controller
@RequestMapping("Notice")
public class notice_Controller {
	@Autowired
	Notice_Service nservice;

	@RequestMapping("index")
	@ResponseBody
	public ModelAndView index(SearchInfo info) throws Exception {
		ModelAndView mv = new ModelAndView();
		List<Notice> n = nservice.select(info);
		mv.addObject("noticeIndex", n);
		mv.setViewName("notice/notice_index");
		return mv;
	}
	
	@RequestMapping("select")
	@ResponseBody
	public HashMap<String, Object> select(SearchInfo info) throws Exception {
		HashMap<String, Object> m = new HashMap<String, Object>();
		String whereSize;
		whereSize = "";
		ArrayList<Notice> list = new ArrayList<Notice>();
		list = (ArrayList<Notice>) nservice.select(info);

		// count
		info.setWhere(whereSize);
		int count = nservice.selectSize(info).get(0).getCount();

		// Response
		m.put("data", list);
		m.put("count", count);
		m.put("msg", "");
		m.put("code", 0);
		return m;
	}
	
	//查看通知
	@RequestMapping("noticeView")
	public ModelAndView NoticeView(int id) throws Exception {
		ModelAndView mv = new ModelAndView();
		Notice n = nservice.getById(id);
		mv.addObject("noticeView", n);
		mv.setViewName("notice/noticeView");
		return mv;
	}
	
	//删除通知
	@RequestMapping("delete")
	@ResponseBody
	public int delete(int id) {
		System.out.println(id);
		int i = nservice.delete(id);
		if(i > 0) {
			return 1;
		}else {
			return 0;
		}
	}
	
	//修改页
	@RequestMapping("noticeEdit")
	public ModelAndView NoticeUpdate(int id) throws Exception {
		ModelAndView mv = new ModelAndView();
		Notice u = nservice.getById(id);
		mv.addObject("noticeEdit", u);
		mv.setViewName("notice/noticeEdit");
		return mv;
	}
	
	@RequestMapping("insert")
	public @ResponseBody JsonInfo insert(Notice n,HttpSession session) {
//		Operator oper = (Operator) session.getAttribute("registers");
//		int operator_id = oper.getId();
//		n.setOperator_id(operator_id);
		n.setOperator_id(1);
		int i = nservice.insert(n);
		if(i > 0) {
			return new JsonInfo(1,"添加成功！");
		}else {
			return new JsonInfo(0,"添加失败！");
		}
	}
	
	@RequestMapping("update")
	public @ResponseBody JsonInfo update(Notice n,HttpSession session) {
//		Operator oper = (Operator) session.getAttribute("registers");
//		int operator_id = oper.getId();
//		n.setOperator_id(operator_id);
		n.setOperator_id(1);
		int i = nservice.update(n);
		if(i > 0) {
			return new JsonInfo(1,"修改成功！");
		}else {
			return new JsonInfo(0,"修改失败！");
		}
	}
	
	@RequestMapping("activity")
	@ResponseBody
	public ArrayList<Activity> selectActivity() throws Exception {
		ArrayList<Activity> listActivity = new ArrayList<Activity>();
		listActivity = (ArrayList<Activity>) nservice.selectActivity();
		return listActivity;
	}
	
	@RequestMapping("operator")
	@ResponseBody
	public ArrayList<Operator> selectOperator() throws Exception {
		ArrayList<Operator> listActivity = new ArrayList<Operator>();
		listActivity = (ArrayList<Operator>) nservice.selectOperator();
		return listActivity;
	}
	
	
//	@RequestMapping("insert")
//	protected @ResponseBody JsonInfo insert(Notice u) {
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");//设置日期格式
//		String createdate = df.format(new Date());
//		u.setCreatedate(createdate);
//		u.setOperator_id(1);
//		int i = nservice.insert(u);
//		if (i > 0) {
//			return new JsonInfo(1, "添加成功！");
//		} else {
//			return new JsonInfo(0, "添加失败！");
//		}
//	}
//
//	

}
