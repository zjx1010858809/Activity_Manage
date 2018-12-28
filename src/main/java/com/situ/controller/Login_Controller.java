package com.situ.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.situ.entity.Login;
import com.situ.service.login_service;
import com.situ.utils.JsonInfo;

@Controller
public class Login_Controller {

	@Autowired
	login_service lservice;

	@RequestMapping("logins")
	public @ResponseBody JsonInfo login(Login log, String code, HttpSession session) {
		System.out.println(log.getMd5pass());
		int myid = log.getMyid();
		if (session.getAttribute("randomCode").toString().equalsIgnoreCase(code)) {
			if (myid == 0) {
				Login user = lservice.userLogin(log);
				if (user != null) {
					session.setMaxInactiveInterval(100000000);
					session.setAttribute("myid",0);
					session.setAttribute("registers", user);
					int type = user.getType();
					if (type == 0) {
						return new JsonInfo(10, "");
					} else if (type == 1) {
						return new JsonInfo(11, "");
					} else
						return new JsonInfo(12, "");
				} else {
					return new JsonInfo(0, "用户密码错误");
				}

			} else {
				Login oper = lservice.operLogin(log);
				if (oper != null) {
					session.setMaxInactiveInterval(100000000);
					session.setAttribute("myid",1);
					session.setAttribute("registers", oper);
					int type = oper.getType();
					if (type == 0) {
						return new JsonInfo(20, "");
					} else if (type == 1) {
						return new JsonInfo(21, "");
					}
				} else {
					return new JsonInfo(0, "用户密码错误");
				}
			}
		} else {
			return new JsonInfo(00, "验证码错误！");
		}
		return new JsonInfo(000,"输入有误！");
	}
	
	@RequestMapping("signOut")
	public String signOut(HttpSession session) {
		session.removeAttribute("registers");
		return "redirect:login.html";
	}
	
	@RequestMapping("sessionCode")
	@ResponseBody
	public Integer sessionCode(HttpSession session) {
		Integer myid = (Integer) session.getAttribute("myid");
		if(myid == 1) {
			return 1;
		}else if(myid == 0) {
			return 1;
		}else {
			//signOut(session);
			return -1;
		}
	}
	
}