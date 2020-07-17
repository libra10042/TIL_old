<%@page import="com.bc.vo.PersonVO"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL forEach</title>
</head>
<body>
	<h1>JSTL forEach : List, Set, Map</h1>
	<h2>Array 출력</h2>
	<p>출력대상 : {"a", "ab", "abc", "abcd"}</p>
<%
	String[] strs = {"a", "ab", "abc", "abcd"};
	pageContext.setAttribute("arr", strs);
%>		
	<c:forEach var="str" items="${arr }">
		<p>${str }</p>
	</c:forEach>
	<hr>
	
	<h3>배열(Array) 일부 데이터만 사용(2,3번째: 1,2번 인덱스)</h3>
	<ul>
	<c:forEach var="str" items="${arr }" begin="1" end="2">
		<li>${str }</li>
	</c:forEach>	
	</ul>
	<hr><hr>
	
	<%-- ===== List 출력 ========== --%>
	<h2>List 출력</h2>
<%
	List<Integer> list = new ArrayList<Integer>();
	list.add(123);
	list.add(45);
	list.add(678);
	list.add(90);
	pageContext.setAttribute("alist", list);
%>	
	<ul>
	<c:forEach var="listItem" items="${alist }">
		<li>${listItem }</li>
	</c:forEach>
	</ul>
	<hr><hr>
	
	<%--============ Set 출력 ============ --%>
	<h2>Set 출력</h2>
<%
	Set<String> set = new HashSet<>();
	set.add("홍길동");
	set.add("김유신");
	set.add("강감찬");
	set.add("을지문덕");
	set.add("을지문덕");
	pageContext.setAttribute("hset", set);
	System.out.println("set.size() : " + set.size());
	System.out.println("set.contains(\"홍길동\") : " + set.contains("홍길동"));
%>
	<p>hset.size() : ${hset.size() }</p>
	<p>hset.contains("홍길동") : ${hset.contains("홍길동") }</p>
	<ol>
	<c:forEach var="name" items="${hset }">
		<li>${name }</li>
	</c:forEach>
	</ol>
	<hr><hr>
	
	<%-- ========== Map key-value 데이터 출력 ============ --%>
	<h1>Map key-value 데이터 출력</h1>
<%
	Map<String, String> map = new HashMap<>();
	map.put("k1", "a");
	map.put("k2", "ab");
	map.put("k3", "abc");
	map.put("k4", "abcd");
	pageContext.setAttribute("hmap", map); //page scope에 저장
%>	
	<c:forEach var="aaa" items="${hmap }">
		<p>${aaa.key } - ${aaa.value }</p>
	</c:forEach>
	<hr><hr>
	
	<%-- ==================================== --%>
	<h1>VO 가 담긴 List 사용</h1>
<%
	List<PersonVO> listBean = new ArrayList<>();
	listBean.add(new PersonVO("홍길동", "27"));
	listBean.add(new PersonVO("김유신", "30"));
	listBean.add(new PersonVO("강감찬", "40"));
	listBean.add(new PersonVO("을지문덕", "50"));
	pageContext.setAttribute("persons", listBean);
%>
	<%--(실습) persons에 있는 PersonVO 객체의 이름, 나이 화면 출력 --%>
	<c:forEach var="person" items="${persons }">
		<p>이름 : ${person.name }, 나이 : ${person.age }</p>
	</c:forEach>
	<hr>
	<c:forEach var="person" items="${persons }">
		<p>이름 : ${person.getName() } - 나이 : ${person.getAge() }</p>
	</c:forEach>
	
	
	
	<br><br><br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br><br><br>
</body>
</html>


























