package com.situ.entity;

public class Report {
	
	private int id;
	private int activity_id;
	private int operator_id;
	private String date;
	private String tprogress="";
	private String sprogress="";
	private String cprogress="";
	private String json="";
	private String comments="";
	
	private String oname;
	
	
	
	
	
	public String getOname() {
		return oname;
	}
	public void setOname(String oname) {
		this.oname = oname;
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
	public int getOperator_id() {
		return operator_id;
	}
	public void setOperator_id(int operator_id) {
		this.operator_id = operator_id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTprogress() {
		return tprogress;
	}
	public void setTprogress(String tprogress) {
		this.tprogress = tprogress;
	}
	public String getSprogress() {
		return sprogress;
	}
	public void setSprogress(String sprogress) {
		this.sprogress = sprogress;
	}
	public String getCprogress() {
		return cprogress;
	}
	public void setCprogress(String cprogress) {
		this.cprogress = cprogress;
	}
	public String getJson() {
		return json;
	}
	public void setJson(String json) {
		this.json = json;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	
	

}
