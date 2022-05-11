<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<style>
td img {
	width:200px;
	height:200px;
}
</style>
<script>
	function insertProduct2(frm){
		frm.action = "controller?type=insertProduct2";
		frm.submit();
	}
</script>
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
	<!----------------------- 상품등록/현황 ---------------------------------->

	<h1 class="title">상품등록</h1>

	<div class="div_k">
		<%@ include file="common/seller.jsp" %>
		<h1 class="title">판매중인 상품 정보</h1>
		<div class="div_order2">
			<table class="table_list">
				<colgroup>
					<col width="5%">
					<col width="20%">
					<col width="20%">
					<col width="20%">
					<col width="20%">
					<col width="20%">
				</colgroup>
				<c:choose>
					<c:when test="${empty pvo }">
						<tr class="not_regist">
							<th colspan="6">등록된 상품이 없습니다.</th>
						</tr>
						<tr>
							<td colspan="6">
								<form method="post">
									<input type="button" value="상품 등록하러 가기" style="text-align:center" onclick="insertProduct2(this.form)">
									<input type="hidden" name="userid" value="<%=(String)session.getAttribute("userid") %>">
								</form>
							</td>
						</tr>
					</c:when>
					<c:otherwise>
						<tr>
							<th><input type="checkbox" name="wish"></th>
							<th>상품고유코드</th>
							<th>사진</th>
							<th>상품이름</th>
							<th>상품가격</th>
							<th>상품등록일</th>
						</tr>
						<c:forEach var="vo" items="${pvo }">
							<tr>
								<td><input type="checkbox" name="wish"></td>
								<td>${vo.p_idx }</td>
								<td><img src="images/${vo.p_thumbnail }"></td>
								<td>${vo.p_name }</td>
								<td>${vo.p_price }원</td>
								<td>${vo.p_date }</td>
							</tr>
						</c:forEach>
							<tr>
								<td colspan="6">
									<form method="post">
										<input type="button" value="상품 등록하러 가기" style="text-align:center" onclick="insertProduct2(this.form)">
										<input type="hidden" name="userid" value="<%=(String)session.getAttribute("userid") %>">
									</form>
								</td>
							</tr>
					</c:otherwise>
				</c:choose>
			</table>
		</div>
	</div>
	<%@ include file="common/footer.jsp"%>
</body>
</html>