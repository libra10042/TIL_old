<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="com.mystudy.mybatis.DBService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 전달받은 데이터 DB에 입력처리
	1. 파라미터 값을 MemberVO 타입의 객체(memberVO)에 저장
	2. mapper 에 memberVO 전달해서 DB입력처리
	3. 페이지 이동 : selectAll.jsp
--%>
	<jsp:useBean id="memberVO" class="com.mystudy.mybatis.MemberVO"/>
	<jsp:setProperty property="*" name="memberVO"/>
<%
	System.out.println("memberVO : " + memberVO);

	//SqlSession 객체생성
	//openSession() : 자동커밋 아님(명시적 커밋필요)
	//openSession(true) : 자동커밋
	SqlSession ss = DBService.getFactory().openSession(); 
	
	int result = 0;
	
	try {
		result = ss.insert("member2.insertMember", memberVO);
		ss.commit(); //명시적 커밋처리.
	} catch(Exception e) {
		ss.rollback(); //명시적 롤백 처리
		result = -1;
		
	} finally {
		ss.close();
	}
	
	System.out.println("result : " + result);
	if ( result < 0) {
		response.sendRedirect("error.jsp");
	} else {
		response.sendRedirect("selectAll.jsp");	
	}
	
%>
	















