<%@page import="com.mystudy.mybatis.DBService"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 전달받은 id값으로 DB데이터 삭제 후 전체조회 페이지로 이동 --%>
<%
	//파라미터 값 추출
	String id = request.getParameter("id");

	//openSession(true) : 자동커밋 상태
	SqlSession ss = DBService.getFactory().openSession(true);
	
	int result = ss.delete("deleteMember", id);
	ss.close();
	
	response.sendRedirect("selectAll.jsp");
%>










