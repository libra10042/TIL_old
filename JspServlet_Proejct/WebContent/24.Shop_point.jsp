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
<h1 class="title">적립금 내역</h1>
    
    <div class="div_k">
        <%@ include file="common/mypage.jsp" %>

        <div class="div_order2">
            <table class="table_list">
                <colgroup>
                    <col width=15%>
                    <col width=70%>
                    <col width=15%>
                </colgroup>
                <tr>
                    <th>날짜</th>
                    <th>적립내역</th>
                    <th>적립금</th>
                </tr>
                <c:choose>
                <c:when test="${not empty ovo }">
                	<c:forEach var="vo" items="${ovo }">
		                <tr>
		                    <td>${vo.o_date }</td>
		                    <td>${vo.o_product }</td>
		                    <td>${vo.c_reserve }</td>
		                </tr>
                	</c:forEach>
                </c:when>
                <c:otherwise>
                <tr>
                    <td colspan="6">적립내역이 없습니다</td>
                </tr>
                </c:otherwise>
                </c:choose>
            </table>
        </div>
    </div>
<%@ include file="common/footer.jsp" %>
</body>
</html>