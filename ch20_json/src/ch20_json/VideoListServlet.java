package ch20_json;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import com.inc.dao.VideoDao;
import com.inc.vo.VideoVo;

@WebServlet("/video/list")
public class VideoListServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<VideoVo> videoList = VideoDao.getInstance().selectList();
		
		response.setContentType("application/plain; charset=utf-8");
		response.getWriter().print(JSONArray.toJSONString(videoList));
		System.out.println(JSONArray.toJSONString(videoList));
		
		
	}

}
