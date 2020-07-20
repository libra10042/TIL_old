<%@page import="com.bc.mybatis.DAO"%>
<%@page import="com.bc.mybatis.BBSVO"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 전달받은 파라미터 값을 DB에 저장하고 list.jsp 이동 --%>
<%
	request.setCharacterEncoding("UTF-8");

	//파일저장 위치
	String path = "c:/MyStudy/temp";
	
	MultipartRequest mr = new MultipartRequest(
			request, path, (10 * 1024 * 1024),
			"UTF-8", new DefaultFileRenamePolicy());
	
	//전달받은 데이터 VO에 저장 후 DB에 입력처리(DB연동작업)
	BBSVO bvo = new BBSVO();
	bvo.setSubject(mr.getParameter("subject"));
	bvo.setWriter(mr.getParameter("writer"));
	bvo.setContent(mr.getParameter("content"));
	bvo.setPwd(mr.getParameter("pwd"));
	
	bvo.setIp(request.getRemoteAddr());
	
	//첨부파일 처리
	if (mr.getFile("file_name") != null) {
		bvo.setFile_name(mr.getFilesystemName("file_name"));
		bvo.setOri_name(mr.getOriginalFileName("file_name"));
	} else {
		bvo.setFile_name("");
		bvo.setOri_name("");
	}
	//DB에 입력(저장)처리
	DAO.insert(bvo);
	
	//화면전환(목록페이지로 이동)
	response.sendRedirect("list.jsp");
%>











