package com.situ.entity;

public class UserGroup {
	private int id;
	private int activity_id;
	private String name;
	private String ids;
	private String project;
	private String path="";
	private int point1=0;
	private int point2=0;
	private int point3=0;
	private int point4=0;
	private int point5=0;
	private int point6=0;
	private String createdate;
	private int operator_id;
	private String comments="";
	
	private String oname;
	
	
	
	
	
	
	public String getOname() {
		return oname;
	}
	public void setOname(String oname) {
		this.oname = oname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	public int getPoint1() {
		return point1;
	}
	public void setPoint1(int point1) {
		this.point1 = point1;
	}
	public int getPoint2() {
		return point2;
	}
	public void setPoint2(int point2) {
		this.point2 = point2;
	}
	public int getPoint3() {
		return point3;
	}
	public void setPoint3(int point3) {
		this.point3 = point3;
	}
	public int getPoint4() {
		return point4;
	}
	public void setPoint4(int point4) {
		this.point4 = point4;
	}
	public int getPoint5() {
		return point5;
	}
	public void setPoint5(int point5) {
		this.point5 = point5;
	}
	public int getPoint6() {
		return point6;
	}
	public void setPoint6(int point6) {
		this.point6 = point6;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
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
	
	

}
