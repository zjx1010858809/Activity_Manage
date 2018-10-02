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
import com.situ.service.Evaluation_Service;
import com.situ.utils.EvaluationSearchInfo;
import com.situ.utils.JsonInfo;

@Controller
@RequestMapping("Evaluation")
public class Evaluation_Controller {
	@Autowired
	Evaluation_Service eservice;

	@RequestMapping("index")
	@ResponseBody
	public HashMap<String, Object> index(EvaluationSearchInfo info) throws Exception {
		HashMap<String, Object> m = new HashMap<String, Object>();
		Integer activity_id = info.getActivity_id();		
		// data
		ArrayList<Evaluation> list = new ArrayList<Evaluation>();
		String whereSize = "";
		String where;
		
		System.out.println("a_id:"+activity_id);

		//学生测评表生成判断
		if (activity_id != null) {
			info.setWhere("where id = " + activity_id);
			List<Activity> la = eservice.selectIds(info);
			String user_ids = la.get(0).getUser_ids();
			String[] ids = user_ids.split(",");	
			for (int i = 0; i < ids.length; i++) {
				Integer user_id = Integer.parseInt(ids[i]);
				// where2
				info.setWhere("where activity_id = " + activity_id + " and user_id = " + user_id);
				Evaluation e = eservice.s_evaluation(info);
				if (e == null) {
					e = new Evaluation();
					e.setActivity_id(activity_id);
					e.setUser_id(user_id);
					eservice.insert(e);
				}
				info.setWhere("where activity_id = " + activity_id);
			}
		}else if (activity_id == null) {
			where = "where ae.activity_id=(select MAX(id) from activity)";
			whereSize = "where ae.activity_id=(select MAX(id) from activity)";
			info.setWhere(where);
		}
		
		// data
		where = info.getWhere();
		System.out.println("where:----"+where);
		list = (ArrayList<Evaluation>) eservice.index(info);

		// count
		info.setWhere(whereSize);
		int count = eservice.selectSize(info).get(0).getCount();
		m.put("data", list);
		m.put("count", count);
		m.put("msg", "");
		m.put("code", 0);
		return m;
	}

	@RequestMapping("activity")
	@ResponseBody
	public ArrayList<Activity> selectActivity() throws Exception {
		ArrayList<Activity> listActivity = new ArrayList<Activity>();
		listActivity = (ArrayList<Activity>) eservice.selectActivity();
		return listActivity;
	}

	// 跳修改页
	@RequestMapping("evaluationEdit")
	public ModelAndView evaluationUpdate(int id) throws Exception {
		ModelAndView mv = new ModelAndView();
		Evaluation e = eservice.getById(id);
		mv.addObject("evaluationEdit", e);
		mv.setViewName("evaluation/evaluationEdit");
		return mv;
	}

	// 修改分数
	@RequestMapping("update")
	public @ResponseBody JsonInfo update(Evaluation e, HttpSession session) {
		int i = eservice.update(e);
		if (i > 0) {
			return new JsonInfo(1, "修改成功！");
		} else {
			return new JsonInfo(0, "修改失败！");
		}
	}

	// 批量打分
	@RequestMapping("batchScore")
	public @ResponseBody JsonInfo batchScore(Evaluation e, HttpSession session) {
		int i = eservice.batchScore(e);
		if (i > 0) {
			return new JsonInfo(1, "修改成功！");
		} else {
			return new JsonInfo(0, "修改失败！");
		}
	}

}
