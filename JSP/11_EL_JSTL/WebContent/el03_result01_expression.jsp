<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 파라미터 값 추출해서 화면 표시 --%>
<%
	//한글처리
	request.setCharacterEncoding("UTF-8");

	//파라미터 값 추출
	String name = request.getParameter("name");
	String age = request.getParameter("age");
	String gender = request.getParameter("gender");
	
	System.out.println("param hobby : " + request.getParameter("hobby"));
	
	String[] hobby = request.getParameterValues("hobby");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>표현식</title>
</head>
<body>
	<h2>결과보기(표현식으로 form 데이터 표시)</h2>
	<ul>
		<li>이름 : <%=name %></li>
		<li>나이 : <%=age %></li>
		<li>성별 : <%=gender %></li>
		<li>취미 : <%=hobby %></li>
		<li>취미(반복문) :
<%
		for (String h : hobby) {
			out.print(h + " ");
		}
%>		
		</li>
	</ul>
</body>
</html>









