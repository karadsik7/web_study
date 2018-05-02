package com.inc.servlet;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import com.inc.vo.PersonVo;

@WebServlet("/person/list")
public class PersonListServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String strURL = "http://localhost:9090/ch28_xml/person.xml";
		URL url = new URL(strURL);
		//List<PersonVo> pvoList = new ArrayList<>();
		SAXBuilder sb = new SAXBuilder();
		try {
			Document document = sb.build(url);
			Element persons = document.getRootElement();
			List<Element> personList = persons.getChildren("person");
			
			/*for(Element person : personList) {
				String name = person.getChildText("name");
				int age = Integer.parseInt(person.getChildText("age"));
				String phone = person.getChildText("phone");
				String type = person.getChild("phone").getAttributeValue("type");
				
				PersonVo pvo = new PersonVo();
				pvo.setAge(age);
				pvo.setName(name);
				pvo.setPhone(phone);
				pvo.setType(type);
				
				pvoList.add(pvo);
			}*/
			request.setAttribute("personList", personList);
			request.getRequestDispatcher("/person/list.jsp").forward(request, response);
		} catch (JDOMException e) {
			e.printStackTrace();
		}
		
		//request.setAttribute("pvoList", pvoList);
		
		
		
	}
}
