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
<title>상품등록페이지</title>
</head>
<script>
	function sellerRegist(frm) {
		frm.action="controller?type=insertProduct3";
		frm.submit();
	}
</script>
<body>
<% if(session.getAttribute("userid") == null) { %>
	<%@ include file="common/header.jsp" %> 
<%
	} else { %>
	<%@ include file="common/headerLogin.jsp" %>	
<%
	}
%>
	<!----------------------- 포동애비 ---------------------------------->
	<h1 class="title">01.상품등록 하기</h1>

	<div class="o_step">
		<ul>
			<li class="step1_1"><img src="images/step_buy2.png"><br>
				<br>01.상품등록하기</li>
			<li class="step1_2"><img src="images/step_buy2.png"><br>
				<br>02.심사중</li>
			<li class="step1_3"><img src="images/step_buy3.png"><br>
				<br>03.상품 등록완료</li>
		</ul>
	</div>
	<!-- ------------------------------------------------------------------------------------ -->

	<!--내용항목-->
	<form method="post" id="seller_register"
		action="35.Seller_register3.jsp">
		<div class="form_group">

			<!--상품고유코드-->
			<div class="form_name" style="text-align: center">
				<label class="label">카테고리</label>
				<!--입력하는 네모창 -->
				<select name="option">
					<c:forEach var="vo" items="${cavo }">
						<option value="${vo.c_num }">${vo.c_name } > ${vo.c_sub }</option>
					</c:forEach>
				</select>
				<br>
			</div>

			<br> <br>
			<div class="line"></div>
			
			<!--상품이름-->
			<div class="form_name" style="text-align: center">
				<label class="label">상품 이름</label>
				<!--입력하는 네모창 -->
				<input type="text" class="form_ele" style="margin-left: 50px;"
					id="sr_idx" name="p_name"><br>
			</div>
			<br> <br>
			<div class="line"></div>
			
			<!--상품이름-->
			<div class="form_name" style="text-align: center">
				<label class="label">상품가격</label>
				<!--입력하는 네모창 -->
				<input type="text" class="form_ele" style="margin-left: 50px;"
					id="sr_rname" name="p_price"><br>
			</div>
			<br> <br>
			<div class="line"></div>
			
			<!--상품이름-->
			<div class="form_name" style="text-align: center">
				<label class="label">썸네일이미지</label>
				<!--입력하는 네모창 -->
				<input type="text" class="form_ele" style="margin-left: 50px;"
					id="sr_rname" name="p_thumbnail"><br>
			</div>
			<br> <br>
			<div class="line"></div>
			
			<!--상품이름-->
			<div class="form_name" style="text-align: center">
				<label class="label">상품상세이미지</label>
				<!--입력하는 네모창 -->
				<input type="text" class="form_ele" style="margin-left: 50px;"
					id="sr_rname" name="p_image"><br>
			</div>
			<br> <br>
			<div class="line"></div>


			<div class="div_o_button1" style="text-align: center">
				<input type="button" value="상품등록" id="c_button3"
					onclick="sellerRegist(this.form)" />&nbsp;&nbsp; <input
					type="button" value="취소" id="c_button1"
					onclick="goLoginForm(this.form)" />
			</div>
		</div>
		<input type="hidden" name="userid" value="<%=(String)session.getAttribute("userid")%>">
		<input type="hidden" name="s_idx" value="${s_idx }">
	</form>
	<%@ include file="common/footer.jsp"%>
</body>
</html>