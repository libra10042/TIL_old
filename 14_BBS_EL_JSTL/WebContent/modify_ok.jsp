<%@page import="com.bc.mybatis.DAO"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="com.bc.mybatis.BBSVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 전달받은 데이터를 사용해서 DB데이터 수정후 상세페이지로 이동 --%>
<%
	request.setCharacterEncoding("UTF-8");

//파일저장 위치
	String path = "c:/MyStudy/temp";
	BBSVO b = (BBSVO)session.getAttribute("bvo");
	String b_idx = b.getB_idx();
	
	MultipartRequest mr = new MultipartRequest(
			request, path, (10 * 1024 * 1024),
			"UTF-8", new DefaultFileRenamePolicy());
	
	//전달받은 데이터 VO에 저장 후 DB에 입력처리(DB연동작업)
	BBSVO bvo = new BBSVO();
	//bvo.setB_idx(((BBSVO)session.getAttribute("bvo")).getB_idx());
	bvo.setB_idx(b_idx);
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
	System.out.println(">> 수정요청 bvo : " + bvo);
	
	//DB데이터 수정작업(DAO에 bvo 전달해서 수정처리)
	DAO.update(bvo);
	
	//화면전환(상세페이지)
	response.sendRedirect("view.jsp?b_idx=" + b_idx
			+ "&cPage=" + session.getAttribute("cPage"));
	
%>
























