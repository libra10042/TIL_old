<%@page import="com.bc.mybatis.ShopVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 전달받은 제품번호를 사용해서 DB데이터 조회 후 화면 표시 --%>
<%
	//전달받은 값 추출(파라미터 값)
	String pNum = request.getParameter("p_num");
%>
	<%-- 액션태그 userBean scope상에 id명의 속성값이 
		있으면 사용하고, 없으면 새로 생성 --%>
	<jsp:useBean id="dao" class="com.bc.mybatis.ShopDAO" scope="session" />
<%
	// DAO 객체(인스턴스) 사용해서 제품정보 조회 후 VO에 저장
	//ShopVO vo = dao.selectOne(pNum);
	//System.out.println("content vo : " + vo);
	
	//EL, JSTL 사용을 위한 속성값 설정
	pageContext.setAttribute("vo", dao.selectOne(pNum));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품상세정보</title>
<link href="css/menu.css" rel="stylesheet" type="text/css">
<style>
	table {
		width: 600px;
		margin: 30px auto 0; /* 상 좌우 하 */
		border: 1px solid navy;
		border-collapse: collapse;
		fon-size: 0.8em;
	}
	th, td { border: 1px solid navy; padding: 4px;}
	th { background-color: #ddd; }
	.red { color: red; }
	
	tfoot { height: 3em; text-align: center; }
	.title { width: 30%; }
	.center { text-align: center; }
</style>
</head>
<body>
<%@include file="common/menu.jspf" %>

	<table>
		<tbody>
			<tr>
				<th class="title">품목코드</th>
				<td>${vo.getCategory() }</td>
			</tr>
			<tr>
				<th>제품번호</th>
				<td>${vo.getP_num() }</td>
			</tr>
			<tr>
				<th>제품명</th>
				<td>${vo.getP_name() }</td>
			</tr>
			<tr>
				<th>제조사</th>
				<td>${vo.getP_company() }</td>
			</tr>
			<tr>
				<th>제품가격</th>
				<td>정가 : ${vo.getP_price() }원
					<span class="red">(할인가격:${vo.getP_saleprice() }원)</span></td>
			</tr>
			<tr>
				<th>제품설명</th>
				<td>${vo.getP_content() }</td>
			</tr>
			<tr>
				<td colspan="2" class="center">
					<img src="images/${vo.getP_image_l() }" alt="제품이미지">
				</td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="2" class="center">
					<input type="button" value="장바구니 담기"
						onclick="add()">
					<input type="button" value="장바구니 보기"
						onclick="javascript:location.href = 'cartList.jsp'">
				</td>
			</tr>
		</tfoot>
	</table>
<script>
	function add() {
		location.href = "addProduct.jsp?p_num=${vo.getP_num() }";
	}
	function cart_go() {
		location.href = 'cartList.jsp';
	}
</script>

	<br><br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br><br>
</body>
</html>









