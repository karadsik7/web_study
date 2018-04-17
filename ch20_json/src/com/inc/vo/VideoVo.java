package com.inc.vo;

import org.json.simple.JSONAware;

public class VideoVo implements JSONAware{
	
	private String title;
	private String path;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	@Override
	public String toJSONString() {
		return String.format("{\"title\" : \"%s\", \"path\" : \"%s\"}", title, path);
	}
	
	
	
}
