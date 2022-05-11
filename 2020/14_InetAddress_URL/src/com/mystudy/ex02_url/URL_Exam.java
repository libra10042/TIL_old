package com.mystudy.ex02_url;

import java.net.MalformedURLException;
import java.net.URL;

public class URL_Exam {

	public static void main(String[] args) throws MalformedURLException {
		// https://sports.news.naver.com/news.nhn?oid=076&aid=0003566976
		// ��������://ȣ��Ʈ(����):��Ʈ/���(�н�)?����(query)
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
		
		System.out.println("��������(protocol) : " + protocol);
		System.out.println("ȣ��Ʈ(host) : " + host);
		System.out.println("��Ʈ��ȣ(port) : " + port);
		System.out.println("�⺻��Ʈ��ȣ(default port) : " + defaultPort);
		System.out.println("���-�н�(path) : " + path);
		System.out.println("����-����(query) : " + query);
		System.out.println("����(reference) : " + ref);
	}

}












