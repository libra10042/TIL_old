<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forEach varStatus</title>
</head>
<body>
	<%
	List<String> list = new ArrayList<>();
	list.add("홍길동-1");
	list.add("홍길동-2");
	list.add("홍길동-3");
	list.add("홍길동-4");
	pageContext.setAttribute("alist", list);
	System.out.println("list : " + list);
	%>
	<h2>forEach List 데이터 표시</h2>
	<p>List 데이터 :
	<c:forEach items="${alist }" var="listItem">
		${listItem }&nbsp;&nbsp;
	</c:forEach> 
	</p>
	<hr><hr>
	<ol>
	<c:forEach var="listItem" items="${alist }"
		varStatus="status"
		begin="0" end="${alist.size() }" step="1">
		<li>
		var 값 : ${listItem }<br>
		current : ${status.current }<br> <%-- 현재 처리중 데이터 --%>
		count : ${status.count }<br> <%-- 처리되는 데이터 건수 --%>
		index : ${status.index }<br> <%-- 인덱스 번호 --%>
		first : ${status.first }<br> <%-- 첫번째 데이터 여부 --%>
		last : ${status.last }<br> <%-- 마지막 데이터 여부 --%>
		
		begin : ${status.begin }<br> <%-- 마지막 데이터 여부 --%>
		end : ${status.end }<br> <%-- 마지막 데이터 여부 --%>
		step : ${status.step }<br> <%-- 마지막 데이터 여부 --%>
		
		status : ${status }<br>
		</li>
	</c:forEach>
	</ol>
	
	
	
</body>
</html>










