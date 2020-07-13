<%@page import="com.bc.mybatis.GuestbookVO"%>
<%@page import="com.bc.mybatis.DBService"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 전달받은 데이터(idx)로 DB데이터 조회 후 화면 출력 --%>
<%
	//전달받은 idx값 추출
	String idx = request.getParameter("idx");
	
	//데이터베이스 연결 및 데이터 가져오기
	//1. SqlSession 객체 생성
	SqlSession ss = DBService.getFactory().openSession();
	
	//2. SqlSession 객체사용 SQL문 실행(idx값 전달)
	GuestbookVO vo = ss.selectOne("guestbook.one", idx);
	ss.close();
	System.out.println("> vo : " + vo);
	
	//3. 조회(검색)된 데이터 화면에 표시
	
	//검색한 데이터(vo)를 계속 사용하기 위해서 session에 등록
	//수정, 삭제 작업시 조회된 데이터 사용하기 위하여 session에 등록 처리
	session.setAttribute("guestbookVO", vo);
	
	//세션에 저장여부 확인
	System.out.println("session guestbookVO : " 
			+ session.getAttribute("guestbookVO"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세화면</title>
<link href="../css/guestbook.css" rel="stylesheet" type="text/css">
<script>
	function update_go(frm) {
		frm.action = "update.jsp";
		frm.submit();
	}
	function delete_go(frm) {
		frm.action = "delete.jsp";
		frm.submit();
	}
</script>
</head>
<body>

<div id="container">
	<h2>방명록 : 상세화면</h2>
	<hr>
	<p><a href="list.jsp">[목록으로 이동]</a></p>
	
	<form method="post">
	<table>
		<tbody>
			<tr>
				<th>작성자</th>
				<td><%=vo.getName() %></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><%=vo.getSubject() %></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><%=vo.getEmail() %></td>
			</tr>
			<tr>
				<td colspan="2"><%=vo.getContent() %></td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="2">
					<input type="button" value="수 정" onclick="update_go(this.form)">
					<input type="button" value="삭 제" onclick="delete_go(this.form)">
				</td>
			</tr>
		</tfoot>
	</table>
	
	</form>
</div>

	<br><br><br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br><br><br>
</body>
</html>