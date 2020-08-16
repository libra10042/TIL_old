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
	<h1 class="title">관심상품</h1>
    
    <div class="div_k">
        <%@ include file="common/mypage.jsp" %>

        <div class="div_order2">
            <table class="table_list">
                <colgroup>
                    <col width="5%">
                    <col width="20%">
                    <col width="25%">
                    <col width="10%">
                    <col width="10%">
                    <col width="10%">
                    <col width="10%">
                    <col width="10%">
                </colgroup>
                <tr>
                    <th>
                        <input type="checkbox" name="wish">
                    </th>
                    <th>사진</th>
                    <th>상품명</th>
                    <th>수량</th>
                    <th>재고</th>
                    <th>적립금</th>
                    <th>가격</th>
                    <th>장바구니</th>
                </tr>
                <tr>
                    <td>
                        <input type="checkbox" name="wish">
                    </td>
                    <td><img src="images/dog01.png" alt="dog"></td>
                    <td>포메(사지말고 입양하세요)</td>
                    <td>
                        <input type="text" value="1" id="l_text">
                    </td>
                    <td>있음</td>
                    <td>270원</td>
                    <td>27,000원</td>
                    <td>
                        <input type="button" value="장바구니" id="l_button1"><br>
                        <input type="button" value="삭제" id="l_button2">
                    </td>
                </tr>
            </table>
        </div>
    </div>
<%@ include file="common/footer.jsp" %>
</body>
</html>