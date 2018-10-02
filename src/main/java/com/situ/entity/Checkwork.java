package com.situ.entity;

public class Checkwork {
	
	private String[] check1list={"-","正常","迟到","早退","请假","未到"};
	private String[] check2list={"-","正常","迟到","早退","请假","未到"};
	private String[] check3list={"-","正常","迟到","早退","请假","未到"};
	
	private int id;
	private int activity_id;
	private int user_id;
	private String date;
	private int check1;
	private int check2;
	private int check3;
	private String lastdate;
	private int operator_id;
	private String comments="";
	
	private String uname;
	private String oname;
	
	private String check;
	private String ids;
	private Integer status;
	
	
	
	
	public String getCheck() {
		return check;
	}
	public void setCheck(String check) {
		this.check = check;
	}
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getOname() {
		return oname;
	}
	public void setOname(String oname) {
		this.oname = oname;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getActivity_id() {
		return activity_id;
	}
	public void setActivity_id(int activity_id) {
		this.activity_id = activity_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getCheck1() {
		return check1;
	}
	public void setCheck1(int check1) {
		this.check1 = check1;
	}
	public int getCheck2() {
		return check2;
	}
	public void setCheck2(int check2) {
		this.check2 = check2;
	}
	public int getCheck3() {
		return check3;
	}
	public void setCheck3(int check3) {
		this.check3 = check3;
	}
	public String getLastdate() {
		return lastdate;
	}
	public void setLastdate(String lastdate) {
		this.lastdate = lastdate;
	}
	public int getOperator_id() {
		return operator_id;
	}
	public void setOperator_id(int operator_id) {
		this.operator_id = operator_id;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getCheck1list() {
		return check1list[check1];
	}
	public String getCheck2list() {
		return check2list[check2];
	}
	public String getCheck3list() {
		return check3list[check3];
	}
	
	
	
	
}
