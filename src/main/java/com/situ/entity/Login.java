package com.situ.entity;

import com.situ.utils.md5Utils;

public class Login {
	private int id;
	private int myid;
	private int type;
	private String nike;
	private String pass;
	private String md5pass;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getMyid() {
		return myid;
	}
	public void setMyid(int myid) {
		this.myid = myid;
	}
	public String getNike() {
		return nike;
	}
	public void setNike(String nike) {
		this.nike = nike;
	}
	
	public String getMd5pass() {
		return md5Utils.MD5(pass);
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
		this.md5pass=md5Utils.MD5(this.pass);
	}
	
	
}
