<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- DB연결하고 GUEST 테이블에서 새로운 사번을 만들어 사번 항목에 설정 --%>
<%
	//JDBC 프로그램 사용해서 사번 구하기
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원등록</title>
</head>
<body>
	<h1>사원등록</h1>
	<form action="insert.jsp">
		<table>
			<tr>
				<th>사번</th>
				<td><input type="text" name="sabun" value="4444" readonly></td>
			</tr>
			<tr>
				<th>성명</th>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<th>금액</th>
				<td><input type="number" name="pay"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="사원등록">
					<input type="reset" value="초기화">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>









