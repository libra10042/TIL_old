<%@page import="com.bc.mybatis.CommVO"%>
<%@page import="java.util.List"%>
<%@page import="com.bc.mybatis.DAO"%>
<%@page import="com.bc.mybatis.BBSVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<%-- 전달받은 파라미터 값 b_idx
	1. 게시글 조회수 1증가(실습)
	2. 게시글(b_idx) 데이터 조회 후 화면 표시
	3. 게시글(b_idx)에 딸린 댓글이 있으면 화면 표시
--%>
<%
	// 파라미터 값 추출
	String b_idx = request.getParameter("b_idx");
	String cPage = request.getParameter("cPage");

	//1. 게시글 조회수 1증가 처리(실습)
	
	//2. 게시글(b_idx) 데이터 조회
	BBSVO bvo = DAO.selectOne(b_idx);
	System.out.println("> bvo : " + bvo);
	
	//3. 게시글(b_idx)에 딸린 댓글이 있으면 가져오기
	List<CommVO> list = DAO.getCommList(b_idx);
	
	// EL, JSTL 사용을 위한 scope상에 속성 등록하고 화면 표시
	session.setAttribute("bvo", bvo);
	pageContext.setAttribute("c_list", list);
	session.setAttribute("cPage", cPage);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세</title>
<script>
	function modify_go() {
		document.frm.action = "modify.jsp";
		document.frm.submit();
	}
	function delete_go() {
		document.frm.action = "delete.jsp";
		document.frm.submit();
	}
	function list_go() {
		document.frm.action = "list.jsp";
		document.frm.submit();
	}
</script>
</head>
<body>

<div id="bbs">
<%-- 게시글 내용 표시 --%>
<form method="post" name="frm">
	<table>
		<caption>상세보기</caption>
		<tbody>
			<tr>
				<th>제목</th>
				<td>${bvo.subject }</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${bvo.writer }</td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td>
					<c:if test="${empty bvo.file_name }">
						첨부파일 없음
					</c:if>
					<c:if test="${not empty bvo.file_name }">
						<a href="download.jsp?f_name=${bvo.file_name }">${bvo.file_name }</a>
					</c:if>
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>${bvo.content }</td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="2">
					<input type="button" value="수정" onclick="modify_go()">
					<input type="button" value="삭제" onclick="delete_go()">
					<input type="button" value="목록" onclick="list_go()">
					<input type="hidden" name="cPage" value="${cPage }">
				</td>
			</tr>
		</tfoot>
	</table>
</form>

<%-- 게시글에 대한 댓글 작성 영역 --%>
<form action="ans_write_ok.jsp" method="post">
	<p>이름 : <input type="text" name="writer">
		비밀번호 : <input type="password" name="pwd">
	</p>
	<p>내용 : <textarea name="content" rows="4" cols="55"></textarea></p>
	<input type="submit" value="댓글저장">
	<input type="hidden" name="b_idx" value="${bvo.b_idx }">
</form>

<%-- 게시글에 작성된 댓글 표시영역 --%>

</div>


	<br><br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br><br>
</body>
</html>












