<%@page import="com.mystudy.InfoVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파라미터값 처리</title>
</head>
<body>
<%
	//한글처리 설정
	request.setCharacterEncoding("UTF-8");

	//파라미터 값 추출
	String name = request.getParameter("name");
	String age = request.getParameter("age");
%>
	<h2>일반적인 파라미터 처리 방법</h2>
	이름 : <%=name %><br>
	나이 : <%=age %>
	<hr>
	
	<h2>속성(attribute)을 이용(request scope)</h2>
<%
	request.setAttribute("attr_name", name + "(attr)");
	request.setAttribute("attr_age", age + "(attr)");
%>	
	<p>이름 : <%=request.getAttribute("attr_name") %></p>
	<p>나이 : <%=request.getAttribute("attr_age") %></p>
	<hr><hr>
	
	<%-- ============================================= --%>
<%-- 액션태그 : <jsp:useBean></jsp:useBean>
	자바빈(Bean)을 이용해서 파라미터 값을 저장 사용
	자바빈(Bean)은 데이터를 저장할 목적으로 JSP에서 제공하는 저장소
	<useBean 액션태그의 역할 및 사용법>
	1. VO 객체(인스턴스) 생성(자바클래스)
	2. 자바빈 생성(useBean 액션태그 사용)
		id : 사용할 변수명(속성명)
		class : 실제 클래스의 위치(패키지 + 클래스명)
		scope : page(default), request, session, application
--%>	
<%--
<%	
	//아래의 useBean 태그가 실제 구현되는 코드 형태
	InfoVO person = (InfoVO) request.getAttribute("person");
	if (person == null) {
		person = new InfoVO();
		request.setAttribute("person", person);
	}
%> 
<%
	person.setName(name);
	person.setAge(age);
%>	
--%>
	<jsp:useBean id="person" class="com.mystudy.InfoVO" scope="request" />
	<%-- setProperty : person 객체의 setName() 메소드에 파라미터 name 값 설정 --%>
	<jsp:setProperty property="name" name="person"/>
	<jsp:setProperty property="age" name="person"/>
	
	<h2>표현식 값 표시</h2>
	<h2>이름(표현식) : <%=person.getName() %></h2>
	<h2>나이(표현식) : <%=person.getAge() %></h2>
	<hr>
	
	<h2>자바빈 객체의 getter 이용해서 값 표시(EL)</h2>
	<h2>이름(EL) : ${person.name }</h2>
	<h2>나이(EL) : ${person.age }</h2>
	<hr>
	<h2>이름(EL get메소드)) : ${person.getName() }</h2>
	<h2>나이(EL get메소드) : ${person.getAge() }</h2>
<%
	System.out.println("person : " + person);
	System.out.println("request person : " + request.getAttribute("person"));
%> 


	<br><br><br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br><br><br>
</body>
</html>














