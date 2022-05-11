<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String userid = (String)session.getAttribute("userid");
	System.out.println("메인페이지 현재 아이디 : " + userid);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/seller.css">
</head>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript">	
	function go_productlist(frm) {
		frm.action="controller";
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
		<h2 style="text-align:center" >마켓 방문하기</h2>
		<div class="container">
		<div class="row">
			<div class="col-md-4">
				<div class="card">
					<img src="images/model1.jpg" class="card-img-top">
					<div class="card-body">
						<h5 class="card-title">크림치즈마켓</h5>
						<p class="card-text">#10대#20대#심플베이직#러블리</p>
						<a href="#" class="btn btn-primary" style="background-color : orange; border: 1px solid orange">방문하기</a>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="card">
					<img src="images/model2.jpg" class="card-img-top">
					<div class="card-body">
						<h5 class="card-title">쇼퍼랜드</h5>
						<p class="card-text">#10대#20대#심플베이직#캠퍼스룩</p>
						<a href="#" class="btn btn-primary" style="background-color : orange; border: 1px solid orange">방문하기</a>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="card">
					<img src="images/model3.jpg" class="card-img-top">
					<div class="card-body">
						<h5 class="card-title">런앱썸</h5>
						<p class="card-text">#20대#러블리#캐주얼</p>
						<a href="#" class="btn btn-primary" style="background-color : orange; border: 1px solid orange">방문하기</a>
					</div>
				</div>
			</div>
		</div>
	</div>	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<div class="card">
					<img src="images/model4.jpg" class="card-img-top">
					<div class="card-body">
						<h5 class="card-title">기프티박스</h5>
						<p class="card-text">#10대#20대#페미닌#심플베이직</p>
						<a href="#" class="btn btn-primary" style="background-color : orange; border: 1px solid orange">방문하기</a>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="card">
					<img src="images/model11.jpg" class="card-img-top" style="height:445px">
					<div class="card-body">
						<h5 class="card-title">베이델리</h5>
						<p class="card-text">#10대#20대#페미닌#심플베이직</p>
						<a href="#" class="btn btn-primary" style="background-color : orange; border: 1px solid orange">방문하기</a>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="card">
					<img src="images/model6.jpg" class="card-img-top">
					<div class="card-body">
						<h5 class="card-title">무아무아</h5>
						<p class="card-text">#10대#20대#심플베이직#러블리</p>
						<a href="#" class="btn btn-primary" style="background-color : orange; border: 1px solid orange">방문하기</a>
					</div>
				</div>
			</div>
		</div>
	</div>



	<h1 class="sub1" style="text-align:center">Today Salay</h1>
	<div class="container">
	<div class="row">
		<div class="col-md-4">
			<div class="card">
			<form method="post">
				<img src="images/image5.jpg" class="card-img-top" style="height:384px">
				<div class="card-body">
					<h5 class="card-title">반팔</h5>
                    <p class="card-text">#10대#20대#심플베이직#골져스#한복아님</p>
					<input class="btn btn-primary" style="background-color : orange; color: black; border: 1px solid orange"
						type="button" value="방문하기" onclick="go_productlist(this.form)">
					<input type="hidden" name="p_idx" value="1">
					<input type="hidden" name="type" value="productlist">
					<input type="hidden" name="userid" value="${userid }">
				</div>
			</form>
			</div>
		</div>
		<div class="col-md-4">
			<div class="card">
			<form method="post">
				<img src="images/image6.jpg" class="card-img-top" style="height:384px">
				<div class="card-body">
					<h5 class="card-title">슬랙스</h5>
                    <p class="card-text">#10대#20대#롱다리쓰#김현정#8090</p>
					<input class="btn btn-primary" style="background-color : orange; color: black; border: 1px solid orange"
						type="button" value="방문하기" onclick="go_productlist(this.form)">
					<input type="hidden" name="p_idx" value="2">
					<input type="hidden" name="type" value="productlist">
					<input type="hidden" name="userid" value="${userid }">
				</div>
			</form>
			</div>
		</div>
		<div class="col-md-4">
			<div class="card">
			<form method="post">
				<img src="images/image8.jpg" class="card-img-top" style="height:384px">
				<div class="card-body">
					<h5 class="card-title">반지</h5>
                    <p class="card-text">#20대#30대#심플베이직하우스#절대반지#사우론</p>
					<input class="btn btn-primary" style="background-color : orange; color: black; border: 1px solid orange"
						type="button" value="방문하기" onclick="go_productlist(this.form)">
					<input type="hidden" name="p_idx" value="3">
					<input type="hidden" name="type" value="productlist">
					<input type="hidden" name="userid" value="${userid }">
				</div>
			</form>
			</div>
		</div>
		</div>
	</div>
	<h1 class="sub2" style="text-align:center">Best Item</h1>
	<div class="container">
	<div class="row">
		<div class="col-md-4">
			<div class="card">
			<form method="post">
				<img src="images/tiger.jpg" class="card-img-top" style="height:384px">
				<div class="card-body">
					<h5 class="card-title">어흥빤스</h5>
                    <p class="card-text">#40대#50대#아버지들#아우터#푹신#따뜻#자신감</p>
					<input class="btn btn-primary" style="background-color : orange; color: black; border: 1px solid orange;"
						type="button" value="방문하기" onclick="go_productlist(this.form)">
					<input type="hidden" name="p_idx" value="128">
					<input type="hidden" name="type" value="productlist">
					<input type="hidden" name="userid" value="${userid }">
				</div>
			</form>
			</div>
		</div>
		<div class="col-md-4">
			<div class="card">
			<form method="post">
				<img src="images/이클립스패키지.PNG" class="card-img-top" style="height:390px">
				<div class="card-body">
					<h5 class="card-title">이클립스패키지</h5>
					<p class="card-text">#10대#20대#충진사마#필수템</p>
					<input class="btn btn-primary" style="background-color : orange; color: black; border: 1px solid orange;"
						type="button" value="방문하기" onclick="go_productlist(this.form)">
					<input type="hidden" name="p_idx" value="14">
					<input type="hidden" name="type" value="productlist">
					<input type="hidden" name="userid" value="${userid }">
				</div>
			</form>
			</div>
		</div>
		<div class="col-md-4">
			<div class="card">
			<form method="post">
				<img src="images/이클립스파랑.PNG" class="card-img-top" style="height:390px">
				<div class="card-body">
					<h5 class="card-title">이클립스파랑</h5>
					<p class="card-text">#10대#20대#충진사마#필수템#시푸</p>
					<input class="btn btn-primary" style="background-color : orange; color: black; border: 1px solid orange;"
						type="button" value="방문하기" onclick="go_productlist(this.form)">
					<input type="hidden" name="p_idx" value="13">
					<input type="hidden" name="type" value="productlist">
					<input type="hidden" name="userid" value="${userid }">
				</div>
			</form>
			</div>
		</div>
	</div>
	</div>
	
	<%@ include file="common/footer.jsp" %>
</body>
</html>