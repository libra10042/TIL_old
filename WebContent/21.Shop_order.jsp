<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <h1 class="title">주문조회</h1>
    
    <div class="div_k">
        <%@ include file="common/mypage.jsp" %>

        <div class="div_order2">
            <table class="table_list">
                <colgroup>
                    <col width=10%>
                    <col width=15%>
                    <col width=15%>
                    <col width=35%>
                    <col width=15%>
                    <col width=10%>
                </colgroup>
                <tr>
                    <th>주문번호</th>
                    <th>상점이름</th>
                    <th>주문일자</th>
                    <th>상품명</th>
                    <th>결제금액</th>
                    <th>주문상태</th>
                </tr>
                <c:if test="${not empty order }">
                	<c:forEach var="order" items="${order }">
	               		<tr>
	                		<td>${order.o_num }</td>
	                		<td>${order.s_idx }</td>
	                		<td>${order.o_date }</td>
	                		<td>${order.o_product }</td>
	                		<td>${order.p_price }원</td>
	                		<td>${order.o_con }</td>
	                	</tr>
	                </c:forEach>
                </c:if>
                <c:if test="${empty order }">
	                <tr>
	                    <td colspan="6">주문내역이 없습니다</td>
	                </tr>
				</c:if>
            </table>
        </div>
    </div>
    <%@ include file="common/footer.jsp" %>
</body>
</html>