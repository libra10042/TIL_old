<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
	String userid = (String)session.getAttribute("userid");
	System.out.println("현재 상품상세페이지 아이디 : " + userid);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/productlist.css">
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/style.css">
<title>상품 상세</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script>
	//Q&A게시판 토글
	$().ready(function(){
 	 	$(".qnaSubject a").click(function(){
			$(this).next().toggle();
		})  
	});
	//카트리스트 이동
	function cartList(frm) {
		frm.action="controller?type=addCartlist";
		frm.submit();
	}
	//리뷰작성페이지 이동
	//구매완료가 떠야만 작성할 수 있으므로
	function writeReview(frm) {
		frm.action="controller?type=writeReview";
		frm.submit();
	}
	//Q&A작성페이지 이동
	//Q&A는 로그인이 필수이므로, 로그인 확인 후 작성
	function writeQnA(frm) {
		frm.action="controller?type=writeQna";
		frm.submit();
	}
	//장바구니 거치지 않고 바로 구매페이지 이동
	function directBuy(frm) {
		frm.action="25.directOrder2-2.jsp";
		frm.submit();
	}
	//위시리스트 이동
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
<div id="p_detail">
	<%-- 게시판 상단 썸네일, 상품정보 --%>
	<div id="p_upper">
		<form method="post">
		<div id="p_thumbnail" style="float:left">
			<img alt="썸네일 이미지" src="images/${pvo.p_thumbnail }" style="width:550px; height:550px">
		</div>
		<div id="p_summary" style="float:left; margin-left:100px">
			<table>
				<tr>
					<th colspan="2">
						<h2>${pvo.p_name }</h2>
					</th>
				</tr>
				<tr>
					<td>
						<h3 style="text-align: left">${pvo.p_price}원</h3>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<hr id="hr" style="margin: 30px">
					</td>
				</tr>
				<tr>
					<td>
						적립금
					</td>
					<td id="right">
						${pvo.p_reserve }%
					</td>
				</tr>
				<tr>
					<td>
						<br>
					</td>
				</tr>
				<tr>
					<td>옵션</td>
					<td>
						<select style="width:168px; height:22px" name="option" class="input" id="chkOp">
						<c:forEach var="vo" items="${oList }">
							<option>${vo.o_name }_${vo.o_size }</option>   
						</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						<br>
					</td>
				</tr>
				<tr>
					<td>수량</td>
					<td>
						<input type="number" name="quantity" class="input" id="quantity" dir="rtl" 
								value=1 min="1" style="width:160px">
					</td>
				</tr>
				<tr>
					<td>
						<br>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="button" class="button" value="♡" onclick="wishList(this.form)">
						<input type="button" class="button" value="ADD TO CART" onclick="cartList(this.form)">
						<input type="button" class="button" value="BUY" onclick="directBuy(this.form)">
					</td>
				</tr>
				<tr>
					<td>
						<br>
					</td>
				</tr>
			</table>
		</div>
			<input type="hidden" name="p_idx" value="${pvo.p_idx }">
			<input type="hidden" name="userid" value="<%=userid %>">
			<input type="hidden" name="p_thumbnail" value="${pvo.p_thumbnail }">
			<input type="hidden" name="p_name" value="${pvo.p_name }">
			<input type="hidden" name="p_price" value="${pvo.p_price }">
			<input type="hidden" name="p_reserve" value="${pvo.p_reserve }">
			<input type="hidden" name="s_idx" value="${pvo.s_idx }">
		</form>
	</div>
	<%-- 상품 내용 정보 --%>
	<div id="p_content">
		<hr id="hr">
		<br><br><br><br><br>
		<img src="images/${pvo.p_image }" alt="상품상세설명">
	</div>
	<%-- 리뷰게시판 --%>
	<div id="p_review">
		<div id="p_review_font">
			<span>리뷰</span><span>ㅣ</span><span id="gray">최신순</span>
		</div>
		<hr id="hr">
		<ul id="review_list">
			<%-- 리뷰글이 없을 때 --%>
			<c:choose>
				<c:when test="${empty rList }">
					<li id="gray" style="width:1100px; padding: 20px;">
						<p style="font-size: 1.5em; text-align: center">현재 등록된 리뷰가 없습니다.</p>
					</li>
				</c:when>
				<c:otherwise>
					<%-- 리뷰가 있을 때 --%>
					<c:forEach var="vo" items="${rList}">
						<li>
							<div id="review_list_detail" style="width:860px">
								<span id="gray">사이즈 : ${vo.r_size} ㅣ 색상유사도 : ${vo.r_colorsimiliarity} ㅣ 상품만족도 : ${vo.r_satisfaction}</span><br>
								<p id="p_review_contents">${vo.r_content}</p>
							</div>
						</li>
						<li>
							<div>
								<span id="gray">작성자<br></span>
								<span>${vo.userid}</span>
							</div>
						</li>
						<hr id="hr">
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</ul>
		<div id="p_writeReview">
		<form method="post">
			<input type="button" class="button"value="리뷰작성" onclick="writeReview(this.form)">
			<input type="hidden" name="userid" value="<%=userid %>">
			<input type="hidden" name="p_idx" value="${pvo.p_idx }">
		</form>
		</div>
	</div>
	<hr id="hr" style="margin-top:100px; margin-botton: 50px;">
	<%-- Q&A 게시판 --%>
	<div id="p_qna">
		<table>
			<colgroup>
				<col width="10%">
				<col width="60%">
				<col width="15%">
				<col width="15%">
			</colgroup>
			<tr>
				<td colspan="4"><hr id="hr"></td>
			<tr>
			<tr>
				<th>문의</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
			<c:choose >
				<%-- 게시판이 없을 때 --%>
				<c:when test="${empty iList }">
					<tr>
						<td colspan="4"><hr id="hr"></td>
					<tr>
					<tr>
						<td colspan="4">현재 등록된 Q&amp;A가 없습니다.</td>
					</tr>
				</c:when>
				<c:otherwise>
					<%-- 게시판이 있을 때 --%>
					<c:forEach var="vo" items="${iList }">
						<tr>
							<td colspan="4"><hr id="hr"></td>
						</tr>
						<tr >
							<td>${vo.i_category }</td>
							<td class="qnaSubject">
								<a>${vo.i_title } <br></a>
								<p class="qnaContent" style="display:none; text-align: left;">
									${vo.i_content}
								</p>
							</td>
							<td>${vo.userid }</td>
							<td>${vo.i_date }</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			<tr>
				<td colspan="4"><hr id="hr"></td>
			</tr>
			<tr>
				<td colspan="3"></td>
				<td>
					<form method="post">
						<input type="button" class="button" value="문의하기" onclick="writeQnA(this.form)">
						<input type="hidden" name="userid" value="<%=userid %>">
						<input type="hidden" name="p_idx" value="${pvo.p_idx }">
					</form>
				</td>
			</tr>
		</table>
	</div>
<%@ include file="common/footer.jsp" %>
</div>
</body>
</html>