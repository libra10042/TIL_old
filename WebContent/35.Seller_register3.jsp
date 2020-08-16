<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String userid = (String)session.getAttribute("userid");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>02.입점신청</title>
<script src="//code.jquery.com/jquery-1.12.4.min.js"></script>
<link rel="stylesheet" href="ccs/seller_register.css">
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/main.css">
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
	<!-- --------------------------------------------------------------------------- -->
	<h1 class="title" style="top-margin: 50px;">03.입점완료</h1>

	<div class="o_step">
		<ul>
			<li class="step2_1"><img src="images/step_buy2.png"><br>
				<br>01.약관 동의서</li>
			<li class="step2_3"><img src="images/step_buy2.png"><br>
				<br>02.입점신청</li>
			<li class="step2_2"><img src="images/step_buy3.png"><br>
				<br>03.입점완료</li>

		</ul>
	</div>
	<div style="text-align: center; margin-bottom: 20px;">
		<h2>입점 완료되었습니다.</h2>
		<br>
		<h4>"상점등록을 해주세요. 상점 등록이 완료 되면 상품등록을 할 수 있습니다."</h4>
	</div>
	<br>
	<br>
	<!-- ------------------------------------------------------------------- -->
	<form method="post" id="shop_register" action="31.Seller_register.jsp">
		<div class="line"></div>
		<H2 style="text-align: center; margin-bottom: 50px;">상점
			정보를등록해주세요.</H2>
		<!--상점번호 -->
		<div class="form_name" style="text-align: center;">
			<div style="text-align: center;">
				<label class="label"><h4>상점이름 : </h4></label>
			</div>
			<!--상점이름-->
			<input type="text" class="form_ele"
				style="margin-left: 50px; width: 100px" name="s_idx" id="S_IDX"><br>
		</div>
		<br> <br>

		<div class="div_o_button1" style="text-align: center">
			<input type="text" value="상점등록하기" id="c_button3" onclick="shopRegister(this.form)" />&nbsp;&nbsp; 
			<!-- <input type="button" value="상점정보확인하기" id="c_button1" onclick="showShopInfo(this.form)" /> -->
		</div>
		<input type="hidden" name="sr_idx" value="${sr_idx }">
		<input type="hidden" name="userid" value="<%=userid%>">
	</form>
	<!-- ------------------------------------------------------------------ -->
	<%@ include file="common/footer.jsp"%>
	<script>
		function shopRegister(frm){
			frm.action = "controller?type=shopRegister";
			frm.submit();
		}

		function showShopInfo(frm){
			frm.action ="controller?type=showShopInfo";
			frm.submit(); 
		}
	</script>
</body>
</html>