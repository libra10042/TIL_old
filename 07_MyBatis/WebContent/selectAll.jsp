<%@page import="com.mystudy.mybatis.MemberVO"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="com.mystudy.mybatis.DBService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 전체 데이터 보여주기(DB에서 가져다가) --%>
<%
	/*
	openSession(true) : 자동커밋상태로 세션 객체 생성(SQL문장 실행후 자동 commit처리됨)
	openSession(), openSession(false) : Auto Commit 해제 상태(트랜잭션 처리 필요)
		- insert, update, delete 작업 후 명시적으로 commit 처리 필요
	*/
	// SqlSession 객체를 얻기
	SqlSession ss = DBService.getFactory().openSession();
	
	//SqlSession.selectList(mapper의id명) : select 결과 여러개인 경우 List형태로 받기
	//SqlSession.selectOne(mapper의id명) : select 결과 하나(1,0) 경우
	List<MemberVO> memberList = ss.selectList("member2.selectAll"); //member2 네임스페이스에 있는 selectAll
	ss.close();
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 데이터 검색</title>
<script type="text/javascript" src="includee/event.js"></script>
</head>
<body>
	<%@ include file="includee/menu.jspf" %>
	
	<h1>전체 데이터 조회</h1>
	<ul>
<%
	if (memberList.size() > 0) { //데이터가 있으면
		for (MemberVO vo : memberList) { %>
			<li>
				<%=vo.getIdx() %> ::
				<%=vo.getId() %> :: 
				<%=vo.getName() %> ::
				<%=vo.getAddress() %>
			</li>
<%		
		}
	} else { //데이터가 없으면
		out.print("<li>조회된 데이터가 없습니다</li>");
	}
%>
	</ul>
</body>
</html>










