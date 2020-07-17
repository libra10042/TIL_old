<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL(Expression Language)</title>
</head>
<body>
<%-- EL(Expression Language) : 표현언어
	1. 표현식을 대신해서 사용 : ${ }
		<%=변수명 %> -----> ${변수명}, ${계산식} ...
	2. 변수값 표시할 경우 반드시 scope 안에 변수(속성)가 존재해야 함
		scope 객체 : pageContext, request, session, application
		해당 scope 상에 setAttribute 설정된 변수(속성) 값만 사용 가능
	3. 같은 이름이 다른 scope 상에 존재하는 경우 접근 우선순위가 적용됨
		pageContext -> request -> session -> application
		(단, scope 지정 없으면 page ---> application 순으로 찾고,
		scope 지정하면 해당 scope에서만 찾음)
 --%>
 	<h2>표현식(Expression) 산술연산 사용 예</h2>
 	<ul>
 		<li>15 + 7 = <%=15 + 7 %></li>
 		<li>15 - 7 = <%=15 - 7 %></li>
 		<li>15 * 7 = <%=15 * 7 %></li>
 		<li>15 / 7 = <%=15 / 7 %></li>
 		<li>15 % 7 = <%=15 % 7 %></li>
 	</ul>

 	<h2>EL(Expression Language) 산술연산 사용 예</h2>
 	<ul>
 		<li>15 + 7 = ${15 + 7 }</li>
 		<li>15 - 7 = ${15 - 7 }</li>
 		<li>15 * 7 = ${15 * 7 }</li>
 		<li>15 / 7 = ${15 / 7 } : double 형식 처리</li>
 		<li>15 % 7 = ${15 % 7 }</li>
 	</ul>
 	<hr><hr>
 	<h2>선언부, 스크립트릿 변수 사용시</h2>
 	<p>표현식은 가능하지만, EL에서는 사용못함</p>
 	<%! int num1 = 15 + 7; %>
 	<% int num2 = 15 + 7; %>
 	<ul>
 		<li>표현식(선언부변수) num1 : 15 + 7 = <%=num1 %></li>
 		<li>표현식(스크립트릿변수) num2 : 15 + 7 = <%=num2 %></li>
 	</ul>
 	<ol>
 		<li>EL(선언부변수) num1 : 15 + 7 = -${num1 }-</li>
 		<li>EL(스크립트릿변수) num2 : 15 + 7 = -${num2 }-</li>
 	</ol>
 	<hr><hr>
 	
 	<h2>EL에서 사용하려면 스코프(scope)에 속성 정의 후에 사용</h2>
 	<% pageContext.setAttribute("attr_num1", num1); %>
 	<ol>
 		<li>EL(속성) attr_num1 : 15 + 7 = ${attr_num1 }</li>
 	</ol>
 	<hr><hr>
 	
 	<%-- ====================================== --%>
 	<h2>동일한 이름의 속성명이 여러 scope 상에 존재할 때</h2>
 	<%
 	//pageContext.setAttribute("pc", "펜티엄 - pageScope");
 	//request.setAttribute("pc", "i3 - requestScope");
 	session.setAttribute("pc", "i5 - sessionScope");
 	application.setAttribute("pc", "i7 - applicationScope");
 	%>
 	<h3>scope 지정 없이 데이터 사용(pageContext -> request -> session -> application)</h3>
 	<ul>
 		<li>scope 지정 없이 사용 : ${pc }</li>
 	</ul>
 	
 	<h3>scope 명시적 지정 사용 : 해당 영역에서만 찾아서 사용</h3>
 	<ol>
 		<li>pageScope 지정 : ${pageScope.pc }</li>
 		<li>requestScope 지정 : ${requestScope.pc }</li>
 		<li>sessionScope 지정 : ${sessionScope.pc }</li>
 		<li>applicationScope 지정 : ${applicationScope.pc }</li>
 	</ol>
 	
 	<br><br><br><br><br><br><br><br><br><br><br><br>
 	<br><br><br><br><br><br><br><br><br><br><br><br>
</body>
</html>



















