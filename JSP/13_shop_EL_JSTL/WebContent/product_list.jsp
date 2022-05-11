<%@page import="com.bc.mybatis.ShopVO"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="com.bc.mybatis.DBService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<%-- 전달받은 제품분류목록(category) 값에 해당하는 제품정보를 DB에서 조회
	화면에 목록형태(테이블)로 표시
--%>
	<jsp:useBean id="dao" class="com.bc.mybatis.ShopDAO" scope="session"/>
<%
	//전달받은 파라미터 값 추출
	String category = request.getParameter("category");
	pageContext.setAttribute("list", dao.list(category));
%>	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품목록</title>
<link href="css/menu.css" rel="stylesheet" type="text/css">
<style>
	table {
		width: 600px;
		margin: 30px auto 0; /* 상 좌우 하 */
		border: 1px solid navy;
		border-collapse: collapse;
		fon-size: 0.8em;
	}
	th, td { border: 1px solid navy; padding: 4px;}
	th { background-color: #ddd; }
	.red { color: red; }
</style>
</head>
<body>
	<%@include file="common/menu.jspf" %>
	<table>
		<thead>
			<tr>
				<th width="15%">제품번호</th>
				<th width="10%">이미지</th>
				<th width="20%">제품명</th>
				<th width="20%">판매가격</th>
				<th>비고</th>
			</tr>
		</thead>
		<tbody>
<%-- 		
			<tr>
				<td>rc-113</td>
				<td>
					<img src="images/pds1.jpg" width="100px" height="95px">
				</td>
				<td>제품명</td>
				<td>할인가:1150원<br>
					<span>(할인율:40%)</span>
				</td>
				<td>가격(원가)</td>
			</tr>
--%>			
	<%--등록된 제품이 없는 경우 --%>
	<c:if test="${empty list }">
		<tr>
			<td colspan='5'>현재 등록된 제품이 없습니다</td>
		</tr>
	</c:if>
	<%--등록된 제품이 있는 경우 --%>
	<c:if test="${not empty list }">
		<c:forEach var="vo" items="${list }">
			<tr>
				<td>${vo.getP_num() }</td>
				<td>
					<img src="images/${vo.getP_image_s() }" width="100px" height="95px">
				</td>
				<td>
					<a href="product_content.jsp?p_num=${vo.getP_num() }">${vo.getP_name() }</a>
				</td>
				<td>할인가 : ${vo.getP_saleprice() }원<br>
					<span class="red">(할인율 : ${vo.getPercent() }%)</span>
				</td>
				<td>시중가격 : ${vo.getP_price() }원</td>
			</tr>
		</c:forEach>
	</c:if>
		
		</tbody>
	</table>
	
</body>
</html>






