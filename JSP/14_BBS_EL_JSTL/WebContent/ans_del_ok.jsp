<%@page import="com.bc.mybatis.DAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 전달받은 파라미터 값을 사용해서 DB데이터 삭제 처리
	삭제 후 화면전환 : 게시글 상세페이지(view.jsp)로 이동 --%>
<%
	request.setCharacterEncoding("UTF-8");

	String c_idx = request.getParameter("c_idx");
	String b_idx = request.getParameter("b_idx");
	
	// DB데이터 삭제 처리(c_idx 값 사용)
	DAO.deleteComment(c_idx);
	
	// 화면전환 : view.jsp(게시글번호, 페이지번호)
	// 게시글번호 : 파라미터값 사용
	// 페이지번호 : 세션에 저장된 "cPage" 속성값 사용
	String cPage = (String) session.getAttribute("cPage");
	
	response.sendRedirect("view.jsp?b_idx=" + b_idx + "&cPage=" + cPage);
%>












