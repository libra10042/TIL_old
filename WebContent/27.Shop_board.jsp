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
<h1 class="title">내 게시글</h1>
    
    <div class="div_k">
        <%@ include file="common/mypage.jsp" %>

        <div class="div_order2">
            
            <div class="div_board">
                <table class="table_board">
                    <tr>
                        <td>Q&A</td>
                        <td id="pg"></td>
                    </tr>
                </table>
            </div>
            
            <table class="table_list">
                <colgroup>
                    <col width=15%>
                    <col width=70%>
                    <col width=15%>
                </colgroup>
                <tr>
                    <th>카테고리</th>
                    <th>제목</th>
                    <th>날짜</th>
                </tr>
                <c:choose>
                <c:when test="${empty iList }">
	                <tr>
	                    <td colspan="6">작성된 게시글이 없습니다</td>
	                </tr>
                </c:when>
	                <c:otherwise>
	                	<c:forEach var="vo" items="${iList }">
			                <tr>
			                    <td>${vo.i_category }</td>
			                    <td>${vo.i_title }</td>
			                    <td>${vo.i_date }</td>
			                </tr>
		                </c:forEach>
	                </c:otherwise>
                </c:choose>
            </table>
            <br><br><br><br><br>
            <div class="div_board">
                <table class="table_board">
                    <tr>
                        <td>REVIEW</td>
                    </tr>
                </table>
            </div>
            <div class="div_ctrl">
            
                <table class="table_list">
                <colgroup>
                    <col width=10%>
                    <col width=10%>
                    <col width=10%>
                    <col width=60%>
                    <col width=10%>
                </colgroup>
                	<tr>
                		<th>사이즈</th>
                		<th>색상유사도</th>
                		<th>상품만족도</th>
                		<th>내용</th>
                		<th>날짜</th>
                	</tr>
                	<c:choose>
                		<c:when test="${empty rList }">
		                    <tr>
		                        <td colspan="5">아직 작성한 리뷰가 없습니다.</td>
		                    </tr>
	                    </c:when>
	                    <c:otherwise>
	                    	<c:forEach var="vo" items="${rList }">
	                    		<tr>
	                    			<td>${vo.r_size }</td>
	                    			<td>${vo.r_colorsimiliarity }</td>
	                    			<td>${vo.r_satisfaction }</td>
	                    			<td>${vo.r_content }</td>
	                    			<td>${vo.r_date }</td>
	                    		</tr>
	                    	</c:forEach>
	                    </c:otherwise>
                    </c:choose>
                </table>
            </div>
        </div>
    </div>
<%@ include file="common/footer.jsp" %>
</body>
</html>