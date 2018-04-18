package com.inc.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/upload")
public class UploadServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//저장 경로 설정
		//1. webPath 가져오기
		//2. webPath를 파라미터로 받는 realPath를 생성하기 위해서 ServletContext객체를 생성
		//2-1. ServletContext 객체는 request.getServletContext();로 초기화
		//3. realPath는 2-1의 객체의 getRealPath메서드에 webPath를 파라미터로 넣어 만듦
		//4. MultipartRequest 객체를 생성하고 저장정책을 파라미터로 설정함
		//** 일반적인 서블릿의 전송방법으로는 파일을 전송할 수 없기 때문임
		
		String webPath = "/upload/";
		//프로젝트 정보를 가지고 있는 객체
		ServletContext application = request.getServletContext();
		
		String realPath = application.getRealPath(webPath);
		System.out.println(realPath);
		//MultipartRequest 파라미터 설명
		//(request객체, 저장실제경로(realPath), 파일최대용량(byte), 인코딩 방식, 파일중복정책 객체)
		//MultipartRequest 객체 생성 도중에 서버에 파일이 저장됨
		
		MultipartRequest mr = new MultipartRequest(request, realPath, 10*1024*1024, "utf-8",
				new DefaultFileRenamePolicy());
		
		String title = mr.getParameter("title"); //폼태그의 name 키값
		System.out.println(title);
		//파일에 대한 정보(이름, 경로)를 저장하고 있는 파일 객체
		File file = mr.getFile("photo"); //폼태그의 name 키값
		String fileName = file.getName();
		System.out.println(fileName);
		
		request.setAttribute("title", title);
		request.setAttribute("fileName", fileName);
		
		request.getRequestDispatcher("result.jsp").forward(request, response);
		
		
		
	}

}

