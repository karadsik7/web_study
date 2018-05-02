package com.inc.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import com.inc.vo.ProductVo;

public class SearchUtil {
	
	public static List<ProductVo> search(String searchText, int start, int display) {
		List<ProductVo> productList = new ArrayList<>();
		String clientId = "ZGRvgbpPdlqTi18npCIX";
		String clientSecret = "HIDiG5oh77";
		
		try {
			searchText = URLEncoder.encode(searchText, "utf-8");
			String strURL = String.format("https://openapi.naver.com/v1/search/shop.xml"
					+ "?query=%s&start=%d&display=%d", searchText, start, display);
			URL url = new URL(strURL);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestProperty("X-Naver-Client-Id", clientId);
			conn.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			conn.setRequestProperty("Content-Type", "application/xml");
			
			/*int i = 0;
			while((i = conn.getInputStream().read()) != -1) {
				System.out.print((char)i);
			}*/
			/*int responseCode = conn.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            System.out.println(response.toString());
			
			*/
			SAXBuilder sb = new SAXBuilder();
			Document document = sb.build(conn.getInputStream());
			Element root = document.getRootElement();
			List<Element> elementList = root.getChild("channel").getChildren("item");
			for(Element element : elementList) {
				String title = element.getChildText("title");
				String link = element.getChildText("link");
				String image = element.getChildText("image");
				int lowPrice = Integer.parseInt(element.getChildText("lprice"));
				int highPrice = Integer.parseInt(element.getChildText("hprice"));
				String mallName = element.getChildText("mallName");
				System.out.println(highPrice);
				
				ProductVo pvo = new ProductVo();
				pvo.setTitle(title);
				pvo.setLink(link);
				pvo.setImage(image);
				pvo.setLowPrice(lowPrice);
				pvo.setHighPrice(highPrice);
				pvo.setMallName(mallName);
				
				productList.add(pvo);
			}
			
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JDOMException e) {
			e.printStackTrace();
		}
		
		
		
		return productList;
	}
	
}
