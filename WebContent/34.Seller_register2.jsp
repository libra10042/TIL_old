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
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/seller.css">
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
	<h1 class="title">02.입점신청</h1>

	<div class="o_step">
		<ul>
			<li class="step2_1"><img src="images/step_buy2.png"><br>
				<br>01.약관 동의서</li>
			<li class="step2_2"><img src="images/step_buy2.png"><br>
				<br>02.입점신청</li>
			<li class="step2_3"><img src="images/step_buy3.png"><br>
				<br>03.입점완료</li>
		</ul>
	</div>

	<div class="join_chang">
		<h2 style="text-align: center">MARKET REGISTER</h2>
		<p style="color: gray; text-align: center">비트 마켓 입점 신청서 입니다..</p>
	</div>

	<br>
	<!-- ------------------------------------------------------------------------------------ -->
	<!--내용항목-->
	<form method="post" id="seller_register" action="35.Seller_register3.jsp">
		<div class="form_group">

			<!--상호법인명-->
			<div class="form_name" style="text-align: center">
				<label class="label">상호(법인명)</label>
				<!--입력하는 네모창 -->
				<input type="text" class="form_ele" style="margin-left: 50px;" id="sr_idx" name="sr_idx"><br>
			</div>

			<br> <br>
			<div class="line"></div>

			<!--대표자명-->
			<div class="form_name" style="text-align: center">
				<label class="label">대표자명</label>
				<!--입력하는 네모창 -->
				<input type="text" class="form_ele" style="margin-left: 50px;" id="sr_rname" name="sr_rname"><br>
			</div>
			<br> <br>
			<div class="line"></div>

			<!--사업자 전화번호-->
			<div class="form_name" style="text-align: center">
				<label class="label">사업자 전화번호</label>
				<!--입력하는 네모창 -->
				<input type="text" class="form_ele" style="margin-left: 50px;" name="sr_number" id="sr_number"><br>
			</div>
			<br> <br>
			<div class="line"></div>

			<!--사업장 주소-->
			<div class="form_name" style="text-align: center">
				<label class="label">사업장주소</label>
				<!--입력하는 네모창 -->
				<input type="text" class="form_ele" style="margin-left: 50px;" name="sr_address" id="sr_address"><br>
			</div>
			<br> <br>
			<div class="line"></div>

			<!--담당자 이름-->
			<div class="form_name" style="text-align: center">
				<label class="label">담당자이름</label>
				<!--입력하는 네모창 -->
				<input type="text" class="form_ele" style="margin-left: 50px;" name="sr_name" id="sr_name"><br>
			</div>
			<br> <br>
			<div class="line"></div>

			<!--담당자 이메일 주소-->
			<div class="form_name" style="text-align: center">
				<label class="label">담당자 이메일 주소</label>
				<!--입력하는 네모창 -->
				<input type="text" class="form_ele" style="margin-left: 50px;"name="sr_email" id="sr_email"><br>
			</div>
			<br> <br>
			<div class="line"></div>

			<!--담당자 전화번호-->
			<div class="form_name" style="text-align: center">
				<label class="label">담당자 전화번호</label>
				<!--입력하는 네모창 -->
				<input type="text" class="form_ele" style="margin-left: 50px;" name="sr_phone" id="sr_phone"><br>
			</div>
			<br> <br>
			<div class="line"></div>

			<!--회원/비회원 구매,  회원만 구매-->
			<div class="form_enter" style="text-align: center">
				<label class="label">회원만 구매</label> 
					<input type="radio" name="sr_check" value="okay" checked="checked" style="margin-left: 40px;"> 
					<span style="font-weight: bold; color: gray;">회원/비회원 구매.</span>
					 <input type="radio" name="sr_check" value="not" style="margin-left: 40px;">
				<span style="font-weight: bold; color: gray;">회원만 구매 </span>
			</div>
			<br> <br>
			<div class="line"></div>

			<div class="div_o_button1" style="text-align: center">
				<input type="button" value="입점신청" id="c_button3" onclick="sellerRegist(this.form)" />&nbsp;&nbsp; 
				<input type="button" value="취소" id="c_button1" onclick="goLoginForm(this.form)" />
			</div>
			<input type="hidden" name="userid" value="<%=userid %>">
		</div>
	</form>
	<%@ include file="common/footer.jsp"%>
	
<script type="text/javascript">
	//입점 신청서에 정보가 모두 입력되었는지 확인.
	function sellerRegist(frm) {
		frm.action = "controller?type=sellerRegister";
		frm.submit();
	}

	//취소 버튼 클릭 시 로그인 페이지로 이동
	function goLoginForm() {
		location.href = "01_mainLogin.jsp";
	}
</script>
</body>
</html>

<!--사업자전화번호-->
<!-- <div class="form_name" style="text-align: center">
				<label class="label">사업자 전화번호</label>
				입력하는 네모창
				<input type="text" class="form_ele" style="margin-left: 50px;" name="SR_NUMBER"><br>
			</div>
			<div class="line2"></div>
			<br> <br> <br>  -->

<!-- 사업장 주소-->
<!-- 	<div class="form_addr" style="text-align: center">
				<label class="label">사업장 주소</label>
				입력하는 네모창
				<input type="text" class="form_addr_in" style="margin-left: 53px;" name="SR_ADDRESS">&nbsp;&nbsp;&nbsp;-

				<div class="line2"></div>

			</div>
			<br> <br>



			담당자 이름
			<div class="form_name" style="text-align: center">
				<label class="label">담당자 이름</label>
				입력하는 네모창
				<input type="text" class="form_ele" style="margin-left: 50px;" name="SR_NAME"><br>
			</div>

			<br> <br>
			<div class="line"></div>

			담당자이메일 주소
			<div class="form_email" style="text-align: center">
				<label class="label">담장자 이메일 주소</label>
				입력하는 네모창
				<div name="SR_EMAIL">
					<input type="text" class="email_form" ><span style="color: gray;">&nbsp;@</span>
					입력하는 네모창
					<input type="text" class="email_form" style="margin-left: auto;">
				</div>
			</div>

			<br> <br>




			담당자전화번호
			<div class="from_ph" style="text-align: center" name="SR_PHONE">
				<label class="label">담당자 전화번호</label> <select
					style="margin-left: 10px; border: 1px solid gainsboro; width: 20%; padding: 8px;"
					name="PHONE">&nbsp;
					<option>선택</option>
					<option>010</option>
					<option>011</option>
					<option>016</option>
					<option>017</option>
					<option>018</option>
					<option>019</option>
				</select>&nbsp;-
				입력하는 네모창
				<input type="text"
					style="margin-left: 10px; border: 1px solid gainsboro; width: 20%; padding: 8px;"
					name="PHONE"> &nbsp;&nbsp;-
				입력하는 네모창
				<input type="text"
					style="margin-left: 6px; border: 1px solid gainsboro; width: 20%; padding: 8px;"
					name="PHONE">
				</li>
			</div>
			<div class="line2"></div>
			<br> <br> <br>



			회원/비회원 구매,  회원만 구매
			<div class="form_enter" style="text-align: center" name="SR_CHECK">
				<label class="label">회원만 구매</label> 
				<input type="radio" name="p_agree" value="okay" checked="checked" style="margin-left: 40px;"> 
				<span style="font-weight: bold; color: gray;">회원/비회원 구매.</span> 
				<input type="radio" name="p_agree" value="not" style="margin-left: 40px;">
				<span style="font-weight: bold; color: gray;">회원만 구매 </span>
			</div>
			<div class="line"></div>
			<br> <br>
			


			<div class="register" style="text-align: center">
				입점 신청
				<div class="form_btn">
					<input type="button" class="form_btn2" value="입점하기" id="c_button3" /> 
					<input type="button" class="form_btn1" value="취소" onclick="goLoginForm()">
				</div>

			</div> 
		</div>-->