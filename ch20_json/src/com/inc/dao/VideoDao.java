package com.inc.dao;

import java.util.ArrayList;

import com.inc.vo.VideoVo;

public class VideoDao {
	
	private static VideoDao videoDao;
	
	private VideoDao() {}
	
	public static VideoDao getInstance() {
		if(videoDao == null) {
			videoDao = new VideoDao();
		}
		return videoDao;
	}
	
	public ArrayList<VideoVo> selectList(){
		ArrayList<VideoVo> videoList = new ArrayList<>();
		
		VideoVo vvo1 = new VideoVo();
		vvo1.setTitle("포켓몬1");
		vvo1.setPath("video/poketmon1.mp4");
		videoList.add(vvo1);
		
		VideoVo vvo2 = new VideoVo();
		vvo2.setTitle("포켓몬2");
		vvo2.setPath("video/poketmon2.mp4");
		videoList.add(vvo2);
		
		return videoList;
	}
	
}
