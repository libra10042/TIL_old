<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String userid = (String)session.getAttribute("userid"); 
	System.out.println("현재 Q&A페이지 아이디 : " + userid);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>REVIEW 작성</title>
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/style.css">
<style>
td, th{
	padding:15px;
}
</style>
<script>
	function writeReview_ok(frm) {
		frm.action = "controller?type=writeReview_ok";
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
<div id="writeQna" class="div_cart_2_2">
	<h1 class="title">REVIEW 작성</h1>
	<form method="post">
		<table class="table_cart_2_2">
			<thead>
				<tr>
					<th>사이즈</th>
					<td><input type="text" name="r_size" value="비공개" id="m_text"></td>
					<th>만족도</th>
					<td>
						<select id="m_address" name="r_satisfaction">
							<option value="매우만족">매우만족</option>
							<option value="만족">만족</option>
							<option value="보통">보통</option>
							<option value="불만족">불만족</option>
							<option value="매우불만족">매우불만족</option>
						</select>
					</td>
					<th>색상유사도</th>
					<td>
						<select id="m_address" name="r_colorsimiliarity">
							<option value="★★★★★">★★★★★</option>
							<option value="★★★★☆">★★★★☆</option>
							<option value="★★★☆☆">★★★☆☆</option>
							<option value="★★☆☆☆">★★☆☆☆</option>
							<option value="★☆☆☆☆">★☆☆☆☆</option>
						</select>
					</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th>내용</th>
					<td colspan="5" style="text-align:center">
						<textarea rows="10" cols="30" id="text_area" style="width:800px"
							name="r_content"></textarea>
					</td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="6" style="text-align:right">
						<input type="button" value="리뷰작성" id="c_button3" onclick="writeReview_ok(this.form)">
						<input type="button" value="목록으로" id="c_button1" onclick="javascript:history.go(-1)">
					</td>
				</tr>
			</tfoot>
		</table>
		<input type="hidden" name="userid" value="${userid }">
		<input type="hidden" name="p_idx" value="${p_idx }">
	</form>
</div>
<%@ include file="common/footer.jsp" %>
</body>
</html>