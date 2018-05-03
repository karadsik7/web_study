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

import org.jdom2.JDOMException;

public class SearchUtilJSON {
	
	public static String search(String searchText, int start, int display) {
		String clientId = "ZGRvgbpPdlqTi18npCIX";
		String clientSecret = "HIDiG5oh77";
		StringBuffer sb = new StringBuffer();
		
		try {
			searchText = URLEncoder.encode(searchText, "utf-8");
			String strURL = String.format("https://openapi.naver.com/v1/search/shop.json"
					+ "?query=%s&start=%d&display=%d", searchText, start, display);
			URL url = new URL(strURL);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestProperty("X-Naver-Client-Id", clientId);
			conn.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			String line;
			while((line = br.readLine()) != null) {
				sb.append(line);
			}
			
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return sb.toString();
	
	}
}
