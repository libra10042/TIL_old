<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//한글 깨짐을 방지하기 위한 인코딩 처리
	request.setCharacterEncoding("UTF-8");
%>
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
	<h1 class="title">상품매출 현황</h1>
	<%@ include file="common/seller.jsp" %>

		<!-- --------------------------------------------------------------------------- -->

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
				<tr>
					<th><input type="checkbox" name="wish"></th>
					<th>구매아이디</th>
					<th>상품명</th>
					<th>상품수량</th>
					<th>금액</th>
					<th>판매일</th>
				</tr>
				<tr>
					<td><input type="checkbox" name="wish"></td>
					<td></td>
					<td>eclipse</td>
					<td>2500원</td>
					<td><input type="text" value="1" id="l_text"></td>
					<td>2020/08/04</td>
				</tr>
				<tr>
					<td><input type="checkbox" name="wish"></td>
					<td></td>
					<td>eclipse</td>
					<td>2500원</td>
					<td><input type="text" value="1" id="l_text"></td>
					<td>2020/08/04</td>
				</tr>
				<tr>
					<td><input type="checkbox" name="wish"></td>
					<td></td>
					<td>eclipse</td>
					<td>2500원</td>
					<td><input type="text" value="1" id="l_text"></td>
					<td>2020/08/04</td>
				</tr>
				<tr>
					<td><input type="checkbox" name="wish"></td>
					<td></td>
					<td>eclipse</td>
					<td>10000원</td>
					<td><input type="text" value="1" id="l_text"></td>
					<td>2020/08/04</td>
				</tr>

				<tr>
					<td colspan="6" onclick='javascript:location.href="37.Seller_productRegist.jsp"'>
					통계확인
					</td>
				</tr>
			
			</table>
		</div>
	</div>

	<%@ include file="common/footer.jsp"%>
</body>
</html>