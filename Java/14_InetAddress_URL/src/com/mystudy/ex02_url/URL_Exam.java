package com.mystudy.ex02_url;

import java.net.MalformedURLException;
import java.net.URL;

public class URL_Exam {

	public static void main(String[] args) throws MalformedURLException {
		// https://sports.news.naver.com/news.nhn?oid=076&aid=0003566976
		// 프로토콜://호스트(서버):포트/경로(패스)?질의(query)
		URL url = new URL("http", "mystudy.com", 8080, 
				"aaa/bbb/test.jsp?id=hong&pw=1234#content");
		
		url = new URL("https://sports.news.naver.com/news.nhn?oid=076&aid=0003566976");
		String protocol = url.getProtocol();
		String host = url.getHost();
		int port = url.getPort();
		int defaultPort = url.getDefaultPort();
		String path = url.getPath();
		String query = url.getQuery();
		String ref = url.getRef();
		
		System.out.println("프로토콜(protocol) : " + protocol);
		System.out.println("호스트(host) : " + host);
		System.out.println("포트번호(port) : " + port);
		System.out.println("기본포트번호(default port) : " + defaultPort);
		System.out.println("경로-패스(path) : " + path);
		System.out.println("쿼리-질문(query) : " + query);
		System.out.println("참조(reference) : " + ref);
	}

}












