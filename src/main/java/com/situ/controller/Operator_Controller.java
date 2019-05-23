package com.situ.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.situ.entity.Login;
import com.situ.entity.Operator;
import com.situ.entity.User;
import com.situ.service.Operator_Service;
import com.situ.utils.JsonInfo;
import com.situ.utils.SearchInfo;

@Controller
@RequestMapping("Operator")
public class Operator_Controller {

	@Autowired
	Operator_Service oservice;

	@RequestMapping("index")
	@ResponseBody
	public HashMap<String, Object> index(String name, SearchInfo info) throws Exception {
		HashMap<String, Object> m = new HashMap<String, Object>();
		// data
		ArrayList<Operator> list = new ArrayList<Operator>();
		String where = "";
		if (name == null) {
			where = "";
		} else if (name == "") {
			where = "";
		} else {
			where = "where nike like '%" + name + "%'";
			info.setWhere(where);
		}
		list = (ArrayList<Operator>) oservice.index(info);
		// count
		int count = oservice.selectSize(info).get(0).getCount();
		m.put("data", list);
		m.put("count", count);
		m.put("msg", "");
		m.put("code", 0);
		return m;
	}

	// 添加管理员
	@RequestMapping("insert")
	protected @ResponseBody JsonInfo insert(Operator o) {
		int i = oservice.insert(o);
		if (i > 0) {
			return new JsonInfo(1, "添加成功！");
		} else {
			return new JsonInfo(0, "添加失败！");
		}
	}
	
	//修改管理员
	@RequestMapping("update")
	protected @ResponseBody JsonInfo update(Operator oper, ModelMap m) {
		oservice.update(oper);
		return new JsonInfo(1, "修改成功！");
	}
	
	@RequestMapping("updatePass")
	protected @ResponseBody JsonInfo updatePass(int id, String password) {
		oservice.updatePass(id);
		return new JsonInfo(1, "密码重置成功!");
	}

	@RequestMapping("operatorEdit")
	public ModelAndView testFreemarker(int id) throws Exception {
		ModelAndView mv = new ModelAndView();
		Operator oper = oservice.getById(id);
		mv.addObject("oper", oper);
		mv.setViewName("operator/operatorUpdate");
		return mv;
	}
	
	//用户查看个人信息
	@RequestMapping("personView")
	public ModelAndView personView(HttpSession sesssion) throws Exception {
		ModelAndView mv = new ModelAndView();
		Login registers = (Login) sesssion.getAttribute("registers");
		int id = registers.getId();
		Operator u = oservice.getById(id);
		/*if(u.getType() == 0) {
			mv.addObject("userView", u);
			mv.setViewName("users/studentView");
		}else {*/
			mv.addObject("userView", u);
			mv.setViewName("users/teacherView");
		/*}*/
		return mv;
	}
}
