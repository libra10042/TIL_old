<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%
	String userid = (String) session.getAttribute("userid");
	System.out.println("메인페이지 현재 아이디 : " + userid);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/seller.css">
<title>상품등록페이지</title>
<script>
	function forwardMain() {
		location.href="01.main.jsp";
	}
	function insertProduct(frm) {
		frm.action="controller?type=insertProduct";
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
	<!----------------------- 포동애비 ---------------------------------->

	<h1 class="title" style="top-margin: 50px;">03.상품등록완료</h1>

	<div class="o_step">
		<ul>
			<li class="step2_1"><img src="images/step_buy2.png"><br>
				<br>01.상품등록하기</li>
			<li class="step2_3"><img src="images/step_buy2.png"><br>
				<br>02.심사중</li>
			<li class="step2_2"><img src="images/step_buy3.png"><br>
				<br>03.상품등록완료</li>

		</ul>
	</div>
	<!-- ------------------------------------------------------------------------------------ -->
	<div style="text-align: center">
		<h2>상품등록이 완료되었습니다.</h2>
		<br>
		<h4>"상품 등록이 완료되었습니다! 상품페이지에서 등록한 상품을 확인하세요. "</h4>
	</div>
	<div class="form_ps">
		<form method="post">
			<input type="button" value="메인페이지로 이동" id="ps_button1" onclick="forwardMain()"> 
			<input type="button" value="등록한 상품 확인" id="ps_button2" onclick="insertProduct(this.form)">
			<input type="hidden" name="userid" value="<%=userid %>">
		</form>
	</div>
	<%@ include file="common/footer.jsp"%>

</body>
</html>