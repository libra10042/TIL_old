<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function goMypage(frm) {
	frm.action="controller?type=goMypage";
	frm.submit();
}
function myPoint(frm) {
	frm.action="controller?type=myPoint";
	frm.submit();
}
function viewCartlist(frm) {
	frm.action="controller?type=viewCartlist";
	frm.submit();
}
function myBoard(frm) {
	frm.action="controller?type=myBoard";
	frm.submit();
}
function alert1() {
	alert("준비중입니다.");
}
</script>
</head>
<body>
	<div class="div_order">
	<form method="post">
        <table class="menubar">
            <tr>
                <th>
                <input type="button" class="menubar2" value="주문조회" onclick="goMypage(this.form)">
                </th>
            </tr>
            <tr>
                <th>
                <input type="button" class="menubar2" value="할인쿠폰" onclick="alert1()">
                </th>
            </tr>
            <tr>
                <th>
                <input type="button" class="menubar2" value="적립금내역" onclick="myPoint(this.form)">
                </th>
            </tr>
            <tr>
                <th>
                <input type="button" class="menubar2" value="장바구니" onclick="viewCartlist(this.form)">
                </th>
            </tr>
            <tr>
                <th>
                <input type="button" class="menubar2" value="관심상품" onclick="alert1()">
                </th>
            </tr>
            <tr>
                <th>
                <input type="button" class="menubar2" value="회원정보" onclick="alert1()">
                </th>
            </tr>
            <tr>
                <th>
                <input type="button" class="menubar2" value="내 게시글" onclick="myBoard(this.form)">
                </th>
            </tr>
        </table>
        <input type="hidden" name="userid" value="<%=(String)session.getAttribute("userid")%>">
        </form>
	</div>
</body>
</html>