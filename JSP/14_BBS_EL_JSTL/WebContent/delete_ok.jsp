<%@page import="com.bc.mybatis.DAO"%>
<%@page import="com.bc.mybatis.BBSVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 전달받은 데이터를 DB에서 삭제 후 목록페이지로 이동 --%>
<%
	request.setCharacterEncoding("UTF-8");

	//전달받은 데이터 추출
	//String b_idx = request.getParameter("b_idx");
	String b_idx = ((BBSVO)session.getAttribute("bvo")).getB_idx();
	
	// DB 데이터 삭제 처리
	try {
		DAO.delete(b_idx);
		//페이지 전환
		response.sendRedirect("list.jsp?cPage=" + session.getAttribute("cPage"));
	} catch (Exception e) {
		//삭제처리중 예외발생(댓글이 있는 경우)
%>
		<script>
			alert("댓글이 있는경우 삭제할 수 없습니다.\n"
					+ "게시글 내용을 삭제하거나, 관리자에게 문의하세요.");
			history.go(-2);
		</script>
<%
	}
%>












