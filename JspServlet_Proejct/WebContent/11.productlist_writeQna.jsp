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
<title>Q n A 작성</title>
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/style.css">
<style>
td, th{
	padding:15px;
}
</style>
<script>
	function writeQna_ok(frm) {
		frm.action="controller?type=writeQna_ok";
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
	<h1 class="title"> Q & A 작성</h1>
	<form method="post">
		<table class="table_cart_2_2">
			<thead>
				<tr>
					<th>HEADER</th>
					<td>
						<select id="m_address" name="i_category">
							<option value="기타문의">기타문의</option>
							<option value="배송문의">배송문의</option>
							<option value="상품문의">상품문의</option>
							<option value="교환/반품문의">교환/반품문의</option>
							<option value="주문취소문의">주문취소문의</option>
							<option value="입금문의">입금문의</option>
							<option value="해외배송문의">해외배송문의</option>
						</select>
					</td>
					<th>TITLE</th>
					<td colspan="3" style="text-align:center">
						<input type="text" name="i_title" value="" id="m_text" style="width:400px">
					</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th>
						CONTENT
					</th>
					<td colspan="3" style="text-align:center">
						<textarea rows="10" cols="30" id="text_area" style="width:800px"
							name="i_content"></textarea>
					</td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="4" style="text-align:right">
						<input type="button" value="글쓰기" id="c_button3" onclick="writeQna_ok(this.form)">
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