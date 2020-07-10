<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 전달받은 데이터를 DB에 저장 
	입력성공시 : 목록페이지 이동(list.jsp)
	입력실패(예외) : 메시지 표시 후 이전화면(입력페이지) 이동
--%>
<%
	//(실습)순서에 따라 입력(insert) 작업 처리
	//0. 한글처리(POST 방식으로 데이터 받았을 때)
	
	//1. 파라미터 값 추출해서 VO객체에 저장(guestbookVO)
	
	//2. SqlSession 객체 생성 - 자동커밋 상태로
	
	//3. 매퍼(mapper)의 SQL의 "insert" id 사용해서 DB입력처리(insert)
	
	//4. 페이지 이동 처리(list.jsp)
%>











