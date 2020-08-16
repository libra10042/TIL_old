<%@page import="com.bc.vo.S_shopVO"%>
<%@page import="com.bc.vo.S_sellerRegistVO"%>
<%@page import="com.bc.model.dao.ShopDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/seller.css">
<title>메인화면</title>
<script src="//code.jquery.com/jquery-1.12.4.min.js"></script>
<style>
tr, td {

}
</style>
</head>
<body>
<% if(session.getAttribute("userid") == null) { %>
	<%@ include file="common/header.jsp" %> 
<%
	} else { %>
	<%@ include file="common/headerLogin.jsp" %>	
<%
	}
%>

	<!----------------------- 상점소개 페이지 ---------------------------------->
	<h1 class="title">상점소개</h1>
	<div class="div_k">
		<%@ include file="common/seller.jsp" %>
		<!-- --------------------------------------------------------------- -->
		<div class="div_order2">
			<table class="table_list">
				<colgroup>
					<col width=50%>
				</colgroup>
				<c:choose>
					<c:when test="${empty svo }">
						<tr class="not_regist">
							<th colspan="6">등록되지 않은 상점입니다.</th>
						<tr>
						<tr>
							<td colspan="6" onclick='javascript:location.href="33_Seller_register1.jsp"'>
								입점신청하러 가기
							</td>
						</tr>
					</c:when>
					<c:otherwise>
						<tr>
							<th colspan="2">입점 정보</th>
						</tr>
						<tr>
							<th>상호법인명</th>
							<td>${svo.sr_idx }</td>
						</tr>
						<tr>
							<th>대표자명</th>
							<td>${svo.sr_rname }</td>
						</tr>
						<tr>
							<th>쇼핑몰명</th>
							<td>${s_idx }</td>
						</tr>
						<tr>
							<th>사업장전화번호</th>
							<td>${svo.sr_number }</td>
						</tr>
						<tr>
							<th>사업장주소</th>
							<td>${svo.sr_address }</td>
						</tr>
						<tr>
							<th>담당자이름</th>
							<td>${svo.sr_name }</td>
						</tr>
						<tr>
							<th>담당자이메일</th>
							<td>${svo.sr_email }</td>
						</tr>
						<tr>
							<th>담당자핸드폰</th>
							<td>${svo.sr_phone }</td>
						</tr>
						<tr>
							<th>회원제여부</th>
							<td>${svo.sr_check }</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</table>
		</div>
	</div>
	<%@ include file="common/footer.jsp"%>
</body>
</html>