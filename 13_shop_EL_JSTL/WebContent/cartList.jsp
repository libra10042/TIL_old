<%@page import="com.bc.mybatis.Cart"%>
<%@page import="com.bc.mybatis.ShopVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<%-- 장바구니(cart)에 있는 제품목록을 화면에 표시 --%>
	<jsp:useBean id="cart" class="com.bc.mybatis.Cart" scope="session" />
	<c:set var="list" value="${cart.getList() }" />
<%
	//장바구니에서 제품목록 꺼내기
	//List<ShopVO> list = cart.getList();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니(cart)보기</title>
<link href="css/menu.css" rel="stylesheet" type="text/css">
<style>
	table {
		width: 800px;
		margin: 30px auto 0; /* 상 좌우 하 */
		border: 1px solid navy;
		border-collapse: collapse;
		fon-size: 0.8em;
	}
	th, td { border: 1px solid navy; padding: 4px;}
	th { background-color: #ddd; }
	.red { color: red; }
	
	tfoot { height: 3em; text-align: center; font-size: 1.5em; font-weight: bold; }
	.title { width: 30%; }
	.center { text-align: center; }
</style>
</head>
<body>
	<%@include file="common/menu.jspf" %>
	
	<table>
		<thead>
			<tr>
				<td colspan="6">::장바구니 내용</td>
			</tr>
			<tr>
				<th>제품번호</th>
				<th>제품명</th>
				<th>가격</th>
				<th>수량</th>
				<th>금액</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>

		<%--if (list == null || list.size() < 1) { --%>
		<c:if test="${empty list }">
			<tr>
				<td colspan="6">장바구니가 비었습니다</td>
			</tr>
		</c:if>
		
		<c:if test="${not empty list }">
			<c:forEach var="vo" items="${list }">
			<tr>
				<td>${vo.getP_num() }</td>
				<td>${vo.getP_name() }</td>
				<td><span class="red">판매가:${vo.getP_saleprice() }원</span>
					(정가:${vo.getP_price() }원)</td>
				<td>
				<form action="editQuant.jsp" method="get">
					<input type="number" name="su" size="3" 
						value="${vo.getQuant() }">
					<input type="submit" value="수정">
					<input type="hidden" name="p_num" value="${vo.getP_num() }">
				</form>
				</td>
				<td>${vo.getTotalprice() }원</td>
				<td>
					<input type="button" value="삭제" onclick="delProduct('${vo.getP_num() }')">
				</td>
			</tr>
			</c:forEach>
		</c:if>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="6">총 결재금액 : ${cart.getTotal() }원</td>
			</tr>
		</tfoot>
		
	</table>
<script>
	function delProduct(pNum) {
		location.href='delProduct.jsp?p_num=' + pNum;
	}
	//delProduct("vC-13"); //문자열인 경우
	//delProduct(111); //숫자인 경우
</script>	
</body>
</html>






