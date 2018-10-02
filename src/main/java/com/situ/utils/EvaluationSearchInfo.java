package com.situ.utils;

public class EvaluationSearchInfo extends SearchInfo{
	String nameText;
	Integer activity_id;
	Integer activitySelect;
	Integer user_id;
	
	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getActivitySelect() {
		return activitySelect;
	}

	public void setActivitySelect(Integer activitySelect) {
		this.activitySelect = activitySelect;
	}

	public Integer getActivity_id() {
		return activity_id;
	}

	public void setActivity_id(Integer activity_id) {
		this.activity_id = activity_id;
	}

	public String getNameText() {
		return nameText;
	}

	public void setNameText(String nameText) {
		this.nameText = nameText;
	}

	
}
