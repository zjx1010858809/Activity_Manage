package com.situ.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.situ.entity.Activity;
import com.situ.entity.Activity_Time;
import com.situ.entity.FeedBack;
import com.situ.entity.Operator;
import com.situ.service.Activity_Service;
import com.situ.service.Activity_Time_Service;
import com.situ.service.FeedBack_Service;
import com.situ.service.Operator_Service;
import com.situ.utils.ActivitySearchInfo;
import com.situ.utils.JsonInfo;
import com.situ.utils.OperatorInfo;

@Controller
@RequestMapping("Activity_Time")
public class Activity_Time_Controller {
	@Autowired
	Activity_Time_Service service;
	@Autowired
	Operator_Service operator_Service;
	@Autowired
	Activity_Service activity_Service;
	@Autowired
	FeedBack_Service feedBack_service;

	Date date = new Date();
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	@RequestMapping("index")
	@ResponseBody
	public HashMap<String, Object> selectAll(ActivitySearchInfo info) throws ParseException {
		HashMap<String, Object> m = new HashMap<String, Object>();
		ArrayList<Activity_Time> list = new ArrayList<Activity_Time>();
		Integer activity_id = info.getActivity_id();
		Integer teacher_id = info.getTeacher_id();
		Integer maxId = service.maxId();
		String where = "";
		String whereSize = "";
		int count;
		list = null;
		count = 0;

		if (activity_id != null) {
			where = "where at.activity_id = " + activity_id;
			whereSize = "where at.activity_id = " + activity_id;
		} else if (teacher_id != null) {
			where = "where at.operator_id = " + teacher_id;
			whereSize = "where at.operator_id = " + teacher_id;
		} else {
			where = "where at.activity_id = " + maxId;
			whereSize = "where at.activity_id = " + maxId;
		}
		info.setWhere(where);

		if (info.getWhere() == "") {

		} else {
			// 数据部分
			list = (ArrayList<Activity_Time>) service.selectAll(info);
			// 加工list状态属性
			for (Activity_Time l : list) {
				// 获取当前活动的状态
				Integer status = l.getStatus();
				// 如果状态为未开始或进行中，代表活动状态会随时间改变
				if (status != 2 && status != 3) {
					// 获取当前活动的日期和时间段
					String activity_date = l.getDate();
					String time1 = l.getTime1();
					String time2 = l.getTime2();
					String time3 = l.getTime3();
					String time4 = l.getTime4();
					String time5 = l.getTime5();
					String time6 = l.getTime6();
					// 判断最早时间
					Date minTime = sdf.parse(getMinTime(activity_date, time1, time3, time5));
					// 判断最晚时间
					Date maxTime = sdf.parse(getMaxTime(activity_date, time2, time4, time6));
					// 获取当前北京时间
					Date currentTime = sdf.parse(getBeijingTime());
					// 将北京时间时间与最早、最晚时间比较
					Integer begin = currentTime.compareTo(minTime);
					Integer end = currentTime.compareTo(maxTime);
					// 获取当前活动状态
					Integer currentStatus = status;
					if (begin < 0) {
						currentStatus = 0;
					} else if (begin > 0 && end < 0) {
						currentStatus = 1;
					} else if (end > 0) {
						currentStatus = 2;
					}
					// 如果状态改变，数据库表状态改变
					while (status != currentStatus) {
						l.setStatus(currentStatus);
						service.updateStatus(l);
						break;
					}
				}
			}

			// 数据尺寸部分
			info.setWhere(whereSize);
			count = service.selectSize(info).get(0).getCount();
		}
		// Response返回部分
		m.put("data", list);
		m.put("count", count);
		m.put("msg", "");
		m.put("code", 0);
		return m;
	}

	@RequestMapping("detail")
	@ResponseBody
	public ModelAndView selectDetails(int id) {
		ArrayList<Activity_Time> list = (ArrayList<Activity_Time>) service.selectDetails(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("roominfo", list.get(0).getRoominfo());
		mv.addObject("time1", list.get(0).getTime1());
		mv.addObject("time2", list.get(0).getTime2());
		mv.addObject("time3", list.get(0).getTime3());
		mv.addObject("time4", list.get(0).getTime4());
		mv.addObject("time5", list.get(0).getTime5());
		mv.addObject("time6", list.get(0).getTime6());
		mv.addObject("operator_name", list.get(0).getOperator_name());
		mv.setViewName("activity_time/details");
		return mv;
	}

	@RequestMapping("selectById")
	@ResponseBody
	public ModelAndView selectById(int id) {
		Activity_Time at = service.selectById(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("id", at.getId());
		mv.addObject("roominfo", at.getRoominfo());
		mv.addObject("dateinfo", at.getDate());
		mv.addObject("time1", at.getTime1());
		mv.addObject("time2", at.getTime2());
		mv.addObject("time3", at.getTime3());
		mv.addObject("time4", at.getTime4());
		mv.addObject("time5", at.getTime5());
		mv.addObject("time6", at.getTime6());
		mv.addObject("operator_id", at.getOperator_id());
		mv.setViewName("activity_time/edit");
		return mv;
	}

	@RequestMapping("Operators")
	@ResponseBody
	public List<Operator> Operators(OperatorInfo info) {
		String where="";
		where = "where type = 0 ";
		info.setWhere(where);
		List<Operator> l = operator_Service.index(info);
		return l;
	}

	@RequestMapping("teachers")
	@ResponseBody
	public List<Operator> teachers() {
		List<Operator> l = service.teacher();
		return l;
	}
	
	@RequestMapping("canlender")
	@ResponseBody
	public List<Activity_Time> canlender() {
		List<Activity_Time> l = service.canlender();
		return l;
	}

	@RequestMapping("Cancel")
	@ResponseBody
	public JsonInfo cancel(int id) {
		int i = service.cancel(id);

		if (i > 0) {
			return new JsonInfo(0, "取消成功");
		} else {
			return new JsonInfo(1, "取消异常");
		}
	}

	@RequestMapping("Add")
	@ResponseBody
	public JsonInfo add(Activity_Time activity_Time) {
		int id = service.add(activity_Time);
		int m = 0;
		//生成反馈表
		Activity activity = activity_Service.getbyid(activity_Time.getActivity_id());
		String ids = activity.getUser_ids();
		FeedBack feedBack = new FeedBack();
		feedBack.setActivity_time_id(id);
		if (ids.length() > 0) {
			String user_id[] = ids.split(",");
			// 为每个学生生成反馈表
			for (int j = 0; j < user_id.length; j++) {
				feedBack.setUser_id(Integer.valueOf(user_id[j]));
				m = m + feedBack_service.insert(feedBack);
			}
		}
		if(m>0) {
			return new JsonInfo(0, "新增成功");
		}else {
			return new JsonInfo(1, "新增异常");
		}
	}

	@RequestMapping("Alter")
	@ResponseBody
	public JsonInfo alter(Activity_Time activity_Time) {
		int i = service.updateDetails(activity_Time);
		if (i > 0) {
			return new JsonInfo(0, "修改成功");
		} else {
			return new JsonInfo(1, "修改异常");
		}
	}

	/**
	 * 获取北京时间
	 * 
	 * @return
	 */
	public String getBeijingTime() {
		return getFormatedDateString(8);
	}

	/**
	 * 获取某时区的当前时间
	 * 
	 * @param timeZoneOffset
	 * @return
	 */
	public static String getFormatedDateString(float timeZoneOffset) {
		if (timeZoneOffset > 13 || timeZoneOffset < -12) {
			timeZoneOffset = 0;
		}

		int newTime = (int) (timeZoneOffset * 60 * 60 * 1000);
		TimeZone timeZone;
		String[] ids = TimeZone.getAvailableIDs(newTime);
		if (ids.length == 0) {
			timeZone = TimeZone.getDefault();
		} else {
			timeZone = new SimpleTimeZone(newTime, ids[0]);
		}

		sdf.setTimeZone(timeZone);
		return sdf.format(new Date());
	}

	/**
	 * 获取活动最早开始时间
	 * 
	 * @param activity_date
	 * @param time1
	 * @param time3
	 * @param time5
	 * @return
	 */
	public String getMinTime(String activity_date, String time1, String time3, String time5) {
		if (time1.equals("") == false) {
			return activity_date + " " + time1;
		} else if (time3.equals("") == false) {
			return activity_date + " " + time3;
		} else if (time5.equals("") == false) {
			return activity_date + " " + time5;
		} else {
			return null;
		}
	}

	/**
	 * 获取活动最晚结束时间
	 * 
	 * @param activity_date
	 * @param time2
	 * @param time4
	 * @param time6
	 * @return
	 */
	public String getMaxTime(String activity_date, String time2, String time4, String time6) {
		if (time6.equals("") == false) {
			return activity_date + " " + time6;
		} else if (time4.equals("") == false) {
			return activity_date + " " + time4;
		} else if (time2.equals("") == false) {
			return activity_date + " " + time2;
		} else {
			return null;
		}
	}
}
