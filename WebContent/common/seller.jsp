<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script>
	function viewSeller(frm) {
		frm.action="controller?type=viewSeller";
		frm.submit();
	}
	function insertProduct(frm) {
		frm.action="controller?type=insertProduct";
		frm.submit();
	}
	function preparing() {
		alert("준비중입니다.");
	}
</script>
<div class="div_order">
	<form method="post">
		<table class="menubar">
			<tr>
				<!-- 상점이 등록되어 있지않으면 입점신청을 할 수 있고 상점이 등록되어 있다면 상점에 대한 정보가 나온다..  -->
				<th>
					<input type="button" class="menubar2" value="상점소개" onclick="viewSeller(this.form)">
				</th>
			</tr>
			<tr>
				<th>
					<input type="button" class="menubar2" value="상품등록/현황" onclick="insertProduct(this.form)">
				</th>
			</tr>
			<tr>
				<th>
					<input type="button" class="menubar2" value="상품 매출 정보" onclick="preparing()">
				</th>
			</tr>
			<tr>
				<!-- 고객센터, 결제 정보, 반품/ 교환 정보를 확인할 수 있다. -->
				<th>
					<input type="button" class="menubar2" value="상점 게시판" onclick="">
				</th>
			</tr>

			<tr>
				<!-- 고객센터, 결제 정보, 반품/ 교환 정보를 확인할 수 있다. -->
				<th>
					<input type="button" class="menubar2" value="반품 요청 목록" onclick="preparing()">
				</th>
			</tr>

			<tr>
				<!-- 기타 정보를 확인할 수 있다. -->
				<th>
					<input type="button" class="menubar2" value="기타" onclick="preparing()">
					<!-- <a href="#">기타</a> -->
				</th>
			</tr>
		</table>
		<input type="hidden" name="userid" value="<%=(String)session.getAttribute("userid")%>">
	</form>
</div>