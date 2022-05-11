<%@page import="com.mystudy.mybatis.MemberVO"%>
<%@page import="com.mystudy.mybatis.DBService"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 전달받은 파라미터(id)를 사용 DB데이터 조회 후 화면 표시 --%>
<%
	//1. 파라미터 값 추출
	String id = request.getParameter("id");
	
	//2. DB연동 작업을 위한 SqlSession 객체 생성하고 DB연동 작업
	SqlSession ss = DBService.getFactory().openSession();
	MemberVO vo = ss.selectOne("member2.selectOne", id); //네임스페이스명.id명
	ss.close();
	
	//3. 조회된 데이터 화면 출력
	System.out.println("vo : " + vo);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="includee/event.js"></script>
</head>
<body>
	<%@ include file="includee/menu.jspf" %>
	
	<h1>ID검색 데이터 조회 결과</h1>
<%
	if (vo != null) { %>
	<ul>
		<li><%=vo.getIdx() %> :: 
			<%=vo.getId() %> ::
			<%=vo.getName() %>
		</li>
	</ul>
<%
	} else  { 
		out.println("<h2>검색된 데이터가 없습니다!!!</h2>");
	}
%>
</body>
</html>













