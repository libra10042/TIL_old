<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String userid = (String)session.getAttribute("userid");
	System.out.println("현재 장바구니 아이디 : " + userid);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/style.css">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery-1.12.4.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
	function editQuantity(frm) {
		frm.action="controller?type=editQuan";
		frm.submit();
	}
	
	function delCartlist(frm) {
		frm.action="controller?type=delCartlist";
		frm.submit();
	}
	function deleteAll(frm) {
		frm.action="controller?type=deleteAll";
		frm.submit();
		alert("삭제가 완료되었습니다.");
	}
	function goOrderlist(frm) {
		frm.action="controller?type=goOrderlist";
		frm.submit();
	}
	
	function wishList(frm) {
		alert("현재 준비중입니다.");
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
    <h1 class="title">장바구니</h1>
    
    <div class="o_step">
        <ul>
            <li class="step1_1">
                <img src="images/step_buy1.png"><br><br>01.장바구니
            </li>
            <li class="step1_2">
                <img src="images/step_buy2.png"><br><br>02.주문서작성
            </li>
            <li class="step1_3">
                <img src="images/step_buy3.png"><br><br>03.주문완료
            </li>
        </ul>
    </div>
    <div class="div_k2">
        <div class="div_cart">
            <table class="table_cart">
                <colgroup>
                    <col width=5%>
                    <col width=20%>
                    <col width=30%>
                    <col width=10%>
                    <col width=5%>
                    <col width=10%>
                    <col width=10%>
                    <col width=10%>
                </colgroup>
                <tr>
                    <th>
                        <input type="checkbox">
                    </th>
                    <th>사진</th>
                    <th>상품명</th>
                    <th>수량</th>
                    <th>적립금</th>
                    <th>가격</th>
                    <th>배송비</th>
                    <th>처리</th>
                </tr>
                
                <c:choose>
                <c:when test="${empty cList }">
                	<tr>
                		<td colspan="8">현재 장바구니엔 상품이 없습니다.</td>
                	</tr>
                </c:when>
                <c:otherwise>
                <c:forEach var="vo" items="${cList}">
                <tr>
                    <td>
                        <input type="checkbox">
                    </td>
                    <td>
                		<input type="hidden" name="p_idx" value="${vo.p_idx }">
                        <img src="images/${vo.p_thumbnail }" alt="dog2" style="width:220px; height:202px">
                    </td>
                    <td>${vo.p_name } <span style="color:gray">(${vo.o_option })</span></td>
                    <td>
               			<form method="post">
	                        <input type="text" name="quantity" value="${vo.c_quantity }" id="l_text">
	                		<input type="hidden" name="p_idx" value="${vo.p_idx }">
	    		            <input type="hidden" name="price" value="${vo.p_price }">
		        	        <input type="hidden" name="reserve" value="${vo.c_reserve }">
			                <input type="hidden" name="userid" value="${vo.userid }">
	                        <input type="button" value="변경" id="l_button2" onclick="editQuantity(this.form)">
             			</form>
                    </td>
                    <td>${vo.c_reserve }원</td>
                    <td>${vo.p_price }원</td>
                    <td>무료배송</td>
                    <td>
                    	<form method="post">
	                        <input type="button" value="관심상품" id="l_button1" onclick="wishList(this.form)"><br>
	                        <input type="hidden" name="p_idx" value="${vo.p_idx }">
	                        <input type="hidden" name="userid" value="${vo.userid }">
	                        <input type="button" value="삭제" id="l_button2" onclick="delCartlist(this.form)">
                        </form>
                    </td>
                </tr>
                <input type="hidden" name="userid" value="${vo.userid }">
                <input type="hidden" name="price" value="${vo.p_price }">
                <input type="hidden" name="reserve" value="${vo.c_reserve }">
                <c:set var="totalPrice" value="${totalPrice + vo.p_price}"/>
                <c:set var="totalReserve" value="${totalReserve + vo.c_reserve}"/>
                </c:forEach>
                </c:otherwise>
                </c:choose>
                
            </table>
        </div>
        <div class="div_cart2">
            <hr class="hr_line">
            <table class="table_price">
                <tr>
                    <th>총 금액</th>
                    <td>${totalPrice }원</td>
                </tr>
                <tr>
                    <th>총 결제금액</th>
                    <td>${totalPrice }원</td>
                </tr>
                <tr>
                    <td colspan="2">(적립금 : ${totalReserve }원)</td>
                </tr>
            </table>
            <hr class="hr_line">
        </div>
        <div class="div_cart37">
            <table>
                <tr>
                    <th>
                        <div>
                            <input  type="button" value="계속 쇼핑하기" id="c_button1" onclick="javascript:location.href='main.jsp'">&nbsp;&nbsp;
                        </div>
                    </th>
                    <th>
                        <div>
                            <form method="post">
                                <input type="hidden" name="userid" value="<%=userid%>">
                                <input type="button" value="장바구니 비우기" id="c_button2" onclick="deleteAll(this.form)">&nbsp;&nbsp;
                            </form>
                        </div>
                    </th>
                    <th>
                        <div>
                            <form method="post">
                                    <input type="hidden" name="userid" value="<%=userid%>">
                                    <input type="button" value="주문하기" id="c_button3" onclick="goOrderlist(this.form)">
                            </form>
                        </div>
                    </th>
                </tr>
            </table>
        </div>
    </div>
<%@ include file="common/footer.jsp" %>
</body>
</html>