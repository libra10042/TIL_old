<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 아이디, 암호 사용해서 로그인 처리여부 판단 --%>
<%
	//1. 파라미터 값 추출
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	
	//2. 전달받은 아이디, 암호 사용 로그인 여부 판단 처리
	// DB연결을 안했으니, id: hong, pwd: 1234 이면 로그인 성공처리, 나머지 실패처리
	boolean loginSuccess = false;
	if ("hong".equals(id) && "1234".equals(pwd)) {
		loginSuccess = true;
	}
	
	//3. session에 성공/실패 값 설정
	if (loginSuccess) {
		session.setAttribute("login_chk", "ok");
		session.setAttribute("id", id);
	} else {
		session.setAttribute("login_chk", "fail");
	}
	System.out.println(">> login_chk: " + session.getAttribute("login_chk"));
	
	//4. 페이지 전환(로그인 페이지로 이동)
	response.sendRedirect("ex02_login.jsp");
%>











