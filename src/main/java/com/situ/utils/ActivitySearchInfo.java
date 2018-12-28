package com.situ.utils;

public class ActivitySearchInfo extends SearchInfo {
	private Integer activity_id;
	private Integer teacher_id;
	private String school;
	private Integer type;
	private String ids;
	private String add_ids;

	public String getAdd_ids() {
		return add_ids;
	}

	public void setAdd_ids(String add_ids) {
		this.add_ids = add_ids;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getActivity_id() {
		return activity_id;
	}

	public void setActivity_id(Integer activity_id) {
		this.activity_id = activity_id;
	}

	public Integer getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(Integer teacher_id) {
		this.teacher_id = teacher_id;
	}
}
