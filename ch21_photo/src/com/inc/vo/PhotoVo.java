package com.inc.vo;

public class PhotoVo {
	
	private int id;
	private String title, filename, password, regdate;
	
	public PhotoVo(int id, String title, String filename, String password, String regdate) {
		this.id = id;
		this.title = title;
		this.filename = filename;
		this.password = password;
		this.regdate = regdate;
	}
	
	public PhotoVo() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	
}
