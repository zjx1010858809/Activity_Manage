package com.situ.entity;

public class Activity {
	private Integer id;
	private String courseinfo; // 课程信息
	private String planinfo; // 计划安排信息
	private String dateinfo; // 时间信息
	private String name; // 活动名称
	private Integer count; // 人数
	private Integer classcount; // 班级数量
	private String options; // 010 - 对应 - 投影，话筒，插排(状态为0/1)
	private String attention; // 注意事项
	private Integer type; // 实训，宣讲，比赛
	private String createdate; // 创建时间
	private Integer status; // 状态 - 正常/取消
	private String comments; // 备注
	private Integer Instructor_user_id; // 活动参与的辅导员
	private Integer source_operator_id; // 来源人
	private Integer operator_id; // 添加人
	private Integer charge_operator_id; // 负责人
	private String user_ids; // 活动参与的学生
	private String[] typeinfo = { "实训", "宣讲", "比赛" };
	private String typeName;
	private String[] statusinfo = { "正常", "取消" };
	private String statusName;
	private String school;
	private String college;

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public Integer getSource_operator_id() {
		return source_operator_id;
	}

	public void setSource_operator_id(Integer source_operator_id) {
		this.source_operator_id = source_operator_id;
	}

	public String getUser_ids() {
		return user_ids;
	}

	public void setUser_ids(String user_ids) {
		this.user_ids = user_ids;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatusName() {
		return statusinfo[status];
	}

	public String getTypeName() {
		return typeinfo[type];
	}

	public String getCourseinfo() {
		return courseinfo;
	}

	public void setCourseinfo(String courseinfo) {
		this.courseinfo = courseinfo;
	}

	public String getPlaninfo() {
		return planinfo;
	}

	public void setPlaninfo(String planinfo) {
		this.planinfo = planinfo;
	}

	public String getDateinfo() {
		return dateinfo;
	}

	public void setDateinfo(String dateinfo) {
		this.dateinfo = dateinfo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getClasscount() {
		return classcount;
	}

	public void setClasscount(Integer classcount) {
		this.classcount = classcount;
	}

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	public String getAttention() {
		return attention;
	}

	public void setAttention(String attention) {
		this.attention = attention;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getCreatedate() {
		return createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
	public Integer getInstructor_user_id() {
		return Instructor_user_id;
	}

	public void setInstructor_user_id(Integer instructor_user_id) {
		this.Instructor_user_id = instructor_user_id;
	}

	public Integer getOperator_id() {
		return operator_id;
	}

	public void setOperator_id(Integer operator_id) {
		this.operator_id = operator_id;
	}

	public Integer getCharge_operator_id() {
		return charge_operator_id;
	}

	public void setCharge_operator_id(Integer charge_operator_id) {
		this.charge_operator_id = charge_operator_id;
	}

}
