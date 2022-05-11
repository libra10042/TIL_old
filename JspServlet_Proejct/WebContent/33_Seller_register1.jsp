<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/seller.css">
<title>상점 입점 신청페이지</title>
<script>
	$(document).click(function(){
		$("#c_button3").click(function(){
			if($("#agree1").is(":checked") == false){
				alert("bitshop 쇼핑이용약관(필수)에 동의 하여야 다음 단계로 진행이 가능합니다.");
				return;
			}else if($("#agree2").is(":checked") == false){
				alert("개인정보 수집 및 이용에대한 안내(필수)에 동의 하여야 다음 단계로 진행이 가능합니다.");
				return;
			}else if($("#agree3").is(":checked") == false){
				alert("개인정보 수집 및 이용에대한 안내(필수)에 동의 하여야 다음 단계로 진행이 가능합니다.");
				return;	
			}else{
				$("#agree_form").submit();
			}
		});
	});
	
	function goLoginForm(frm){
		frm.location.href="01_mainLogin.jsp";
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
	<!------------------------------------------------------------------->
	<h1 class="title">01.입점 신청 약관 동의서</h1>

	<div class="o_step">
		<ul>
			<li class="step1_1"><img src="images/step_buy2.png"><br>
				<br>01.약관동의서</li>
			<li class="step1_2"><img src="images/step_buy2.png"><br>
				<br>02.입점신청</li>
			<li class="step1_3"><img src="images/step_buy3.png"><br>
				<br>03.입점완료</li>
		</ul>
	</div>
	<form id="agree_form" method="post" action="34.Seller_register2.jsp">
		<div id="container">
			<div class="cp_contract">
				<h3 class="tot fist" style="text-align: center;">bitshop 쇼핑
					이용약관(필수)</h3>
				<div class="view scroll">
					<p class="dsc first">제 1조(목적)</p>
					<p class="des">"이 약관은 bit 주식회사(이하 "회사"라 함)가 운영하는 인터넷 사이트
						bitshop(http://www.bitshop.com; 이하 "bitshop 쇼핑"이라 함)에 광고 게재 요청에 따라
						광고주가 판매하는 광고를 게재함에 있어 "회사"와 "광고주" 간의 권리, 의무 및 책임사항을 규정함을 목적으로 한다."

					</p>
					<hr>
					<p class="des">제 2조(정의)</p>
					<p class="des">
						"서비스"란 회사가 bitshop 또는 bitshop에 광고주의 상품 또는 사이버몰(본 조 제3항의 스토어팜 판매자가
						운영하는 스토어팜물을 포함하여 이하 "사이버몰"이라 함)을 광고하는 문자, 이미지(Banner), 상품 DB등을
						게재하고 이용자가 이를 쉽게 이용할 수 있도록 url Linkage를 제공하는 것을 말한다. 회사는 이용자가 서비스를
						통하여 광고주의 사이버몰로 이동할 수 있는 기능만을 제공한다." <br> "광고주"란 본 약관에 따라
						회사로부터 서비스를 제공받은 사업자를 말한다. 회사는 광고주가 적법한 사업자인지 여부를 확인하기 위하여 관련 증빙자료의
						제공을 요구할 수 있다." <br> "스토어팜 판매자"란 회사가 운영하는 스토어팜 서비스의 판매자 이용약관에
						동의하고 스토어팜에 입점하여 상품을 판매하는 자를 말합니다." <br> "호스팅 사업자"란 서비스 제공을 위해
						회사와 업무협약이 체결된 인터넷 호스팅(Internet hosting) 사업자로서 광고주에게 EC호스팅 용역을 제공하는
						사업자를 말한다." <br> "입점"이란 광고주가 회사에 서비스 제공을 요청하고 회사가 이를 승낙하여 네이버
						또는 쇼핑 내 세버시를 게시하는 것으로 가격비교 방식 또는 단순 리스팅(Listing) 방식을 포함하는 것이며, 회사가
						네이버 쇼핑에 상품 광고(또는 정보; 이하 같다)를 게재할 수 있도록 광고주에게 전산장치 또는 프로그램 (이하
						"시스템"이라 함)을 통해 광고주가 상품 광고를 개재하는 회원를 지칭하기도 합나다. 단, 상품의 광고주가 독자적으로
						수행하는 것이며, 입점으로 인해 회사가 판매를 대행하거나 보조하는 것은 아님을 확인한다." <br>
					</p>
					<p>
						<br> " 본 약관은 2020년 8월 7일 부터 시행됩니다."
					</p>
				</div>

			</div>
		</div>
		
		<div class="agree" style="text-align: right">
			<input type="checkbox" name="agree1" id="agree1"> <label
				for="agree1">개인정보 제3자 제공에 동의합니다.</label>
		</div>
		<br>
		<br>
		<hr>
		<div class="cp_contract">
			<h3 class="title first" style="text-align: center">개인정보 수집 및 이용에
				대한 안내(필수)</h3>
			<div class="view scroll">
				<p class="dsc first">
					"bit shop 주식회사(이하 '회사'라 함)는 이용자의 개인정보를 중요시하며, '정보통신망 이용 촉진 및 정보보호
					등에 관한 법뷸', 개인정보 보호법 등 관계법령에 의거하여 개인정보를 관리 및 보호하고 있습니다." <br>
					"회사의 bitshop 쇼핑 "쇼핑파트너센터" 서비스에서는 개인정보의 수집, 이용 등 처리에 있어 아래의 사항을
					정보주체에게 안내합니다." <br> 정보주체는 개인정보의 수집 및 이용 동의를 거부할 권리가 있으나 본 동의는
					서비스 제공을 위한 최소한의 개인정보 수집으로서 거부하실 경우, 서비스 이용이 불가능합니다.

				</p>
				<p class="dsc">
					" 1. 개인정보의 수집 이용목적" <br> "회사는 수집한 개인정보를 다음의 목적을 위해 이용합니다." <br>
					"가. 서비스 제공에 관한 계약 이행 및 서비스 제공에 따른 요금정산" <br> " - 컨텐츠 제공, 특정 맞춤
					서비스 제공, 물품배송 또는 청구서 등 발송, 본인인증, 구매 및 요금 결제, 요금추심, 판매자와 이용자가 거래의 원활한
					진행" <br> "나. 회원 관리 및 부정이용방지" <br> - 회원제 서비스 제공, 개인식별, 가입
					및 회원 달퇴 의사의 확인, 불만처리 등 민원처리, 고지사항 전달"
				</p>


			</div>

		</div>

		<div class="agree" style="text-align: right">
			<input type="checkbox" name="agree2" id="agree2"> <label
				for="agree2">개인정보 수집 및 이용에 동의합니다.</label>
		</div>
		<hr>
		
		<br>
		<br>
		<hr>
		<div class="cp_contract">
			<h3 class="tit first" style="text-align: center">개인정보 제3자 제공에 대한
				안내 (필수)</h3>
			<div class="view scroll">
				<p class="dsc first">bit 주식회사는 bit shop입점 신청자 중 쇼핑파트너사를 이용하는
					쇼핑몰의 개인정보를 정보통신망 이용촉진 및 정보보호 등에 관한 법류 제24조의(개인정보의 제공 동의 등)에 따라 아래와
					같은 사항을 알리고 동의를 받아 쇼핑파트너사에 제공합니다.</p>
				<p class="dsc">
					1. 개인정보를 제공받는 자 <br> - bitshop 공식 쇼핑파트너사 중 입점 쇼핑몰이 이용하고 있는 쇼핑
					파트너사" <br>
				</p>
				<p class="dsc">
					"2. 제공하는 개인정보 항목" <br> - 쇼핑몰 정보(쇼핑몰 ID, 대표자명), 담당자 정보(이름,
					휴대폰번호, 이메일), 서비스 이용기록" <br>
				</p>
				<p class="dsc">
					"3. 개인정보를 제공받는 자의 개인정보 이용목적" <br> -쇼핑몰의 호스팅, 상품 및 판매 관리 업무 대행"
					<br>
				</p>
				<p class="dsc">
					"4. 개인정보를 제공받는 자의 개인정보 보유 및 이용기간" <br> - 네이버 쇼핑 탈퇴 시까지 또는
					쇼핑파트너사의 EC 호스팅 이용 시간 동안" <br>

				</p>
			</div>
		</div>

		<div class="agree" style="text-align: right">
			<input type="checkbox" id="agree3" name="agree3"> <label
				for="agree3">개인정보 제3자 제공에 동의합니다.</label>
		</div>
		<hr style="border:1px color= silver;" width="90%">

		<br>
		<br>
		<div class="caution_area">
			<li>bitshop 쇼핑 서비스를 이용약관에 동의하시면 서비스를 등록하실 수 있습니다.</li> <br>
			<li>본 이용약관 및 서비스 의무 규정은 계약기간 동안 준수하셔야 합니다.</li>
		</div>
<!-- 		<div class="agree" style="text-align: right">
			<input type="checkbox" name="agreeAll" id="agreeAll"> <label
				for="agree2">모두 동의하기.</label>
		</div>  -->



		</div>

		<br> <br>
		<div class="div_o_button1" style="text-align: center">
			<!-- 	<input type="button" value="약관동의" id="c_button3"
				onclick=location.href="34.Seller_register2.jsp" />&nbsp;&nbsp; <input type="button"
				value="취소" id="c_button1" onclick=location.href="01_main.jsp" /> -->

			<input type="button" value="약관동의" id="c_button3" onclick="javascript:location.href='34.Seller_register2.jsp'"/>&nbsp;&nbsp; 
			<input type="button" value="취소" id="c_button1" onclick="goLoginForm(this.form)" />
		</div>

		<br>
	</form>
	<%@ include file="common/footer.jsp" %>
</body>
</html>


