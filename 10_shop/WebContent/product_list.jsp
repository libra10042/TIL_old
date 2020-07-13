<%@page import="com.bc.mybatis.ShopVO"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="com.bc.mybatis.DBService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 전달받은 제품분류목록(category) 값에 해당하는 제품정보를 DB에서 조회
	화면에 목록형태(테이블)로 표시
--%>
<%
	//전달받은 파라미터 값 추출
	String category = request.getParameter("category");

	//DB 데이터 조회
	//SqlSession ss = DBService.getFactory().openSession();
	//List<ShopVO> list = ss.selectList("shop.list", category);
	
	// DAO를 사용하는 패턴
%>
	<jsp:useBean id="dao" class="com.bc.mybatis.ShopDAO" scope="session"/>
<%
	List<ShopVO> list = dao.list(category);
	for (ShopVO vo : list) {
		System.out.println("vo : " + vo);
	}
%>	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품목록</title>
</head>
<body>
	<jsp:include page="shop.jsp" />
	<table>
	</table>
	
</body>
</html>






