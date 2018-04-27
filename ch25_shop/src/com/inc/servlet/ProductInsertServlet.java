package com.inc.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.ProductDao;
import com.inc.vo.ProductVo;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/product/insert")
public class ProductInsertServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/views/product/insert.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String webPath = "/image/product";
		String realPath = request.getServletContext().getRealPath(webPath);
		
		MultipartRequest mr = new MultipartRequest(request, realPath, 3*1024*1024, "utf-8", new DefaultFileRenamePolicy());
		
		
		String category = mr.getParameter("category");
		String model = mr.getParameter("model");
		String manufacturer = mr.getParameter("manufacturer");
		int price = Integer.parseInt(mr.getParameter("price"));
		double retail_pct = (Double.parseDouble(mr.getParameter("retail_pct"))) / 100;
		System.out.println(retail_pct);
		String content = mr.getParameter("content");
		File image_s = mr.getFile("image_s");
		String image_s_path = webPath + "/" + image_s.getName();
		System.out.println(image_s_path);
		File image_l = mr.getFile("image_l");
		String image_l_path = webPath + "/" + image_l.getName();
		System.out.println(image_l_path);
		
		ProductVo pvo = new ProductVo();
		pvo.setCategory(category);
		pvo.setContent(content);
		pvo.setImage_l(image_l_path);
		pvo.setImage_s(image_s_path);
		pvo.setManufacturer(manufacturer);
		pvo.setModel(model);
		pvo.setPrice(price);
		pvo.setRetail_pct(retail_pct);
		
		ProductDao.getInstance().insert(pvo);
		
		response.sendRedirect(request.getContextPath() + "/product/list");
	}

}
