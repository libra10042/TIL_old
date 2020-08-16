<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="css/reset.css">
	<link rel="stylesheet" href="css/main.css">
	<link rel="stylesheet" href="css/style.css">
    <title>메인화면</title>
<body>
<% if(session.getAttribute("userid") == null) { %>
	<%@ include file="common/header.jsp" %> 
<%
	} else { %>
	<%@ include file="common/headerLogin.jsp" %>	
<%
	}
%>
    <h1 class="title">할인쿠폰</h1>
    
    <div class="div_k">
        <%@ include file="common/mypage.jsp" %>

        <div class="div_order2">
            <table class="table_list">
                <colgroup>
                    <col width=10%>
                    <col width=25%>
                    <col width=15%>
                    <col width=20%>
                    <col width=15%>
                    <col width=15%>
                </colgroup>
                <tr>
                    <th>쿠폰번호</th>
                    <th>쿠폰이름</th>
                    <th>쿠폰전용품목</th>
                    <th>사용가능금액</th>
                    <th>할인금액</th>
                    <th>사용기간</th>
                </tr>
                <tr>
                    <td colspan="6">쿠폰내역이 없습니다</td>
                </tr>
            </table>
        </div>
        
        <div class="div_coupon">
            <input type="button" value="쿠폰등록" id="cp_button">
        </div>
        
    </div>
    <%@ include file="common/footer.jsp" %>
</body>
</html>