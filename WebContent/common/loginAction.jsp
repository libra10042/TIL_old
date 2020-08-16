<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int result = (int)request.getAttribute("result");
	String userid = (String)request.getAttribute("userid");
	System.out.println("result : " + result);
	if(result==0) {
		
        PrintWriter script = response.getWriter();

        script.println("<script>");
        script.println("alert('로그인에 실패하였습니다.')");
        script.println("history.back()");
        script.println("</script>");

        out.flush();
	} else {
		session.setAttribute("userid", userid);
		PrintWriter script = response.getWriter();

        script.println("<script>");
        script.println("location.href='01.main.jsp'");
        script.println("</script>");
	}
%>