<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="delete_ok.jsp" method="post">
	비밀번호 : <input type="password" name="pwd">
	<input type="button" value="삭제" onclick="del_go(this.form)">
	<%-- <input type="hidden" name="b_idx" value="${bvo.b_idx }"> --%>
</form>

<script>
	function del_go(frm) {
		if (frm.pwd.value == "${bvo.pwd}") { //암호일치
			var isDelete = confirm("정말 삭제할까요?");
			if (isDelete) {
				frm.submit();
			} else {
				history.back();
			}
		} else {//암호 불일치
			alert("비밀번호가 일치하지 않습니다. 확인하세요");
			frm.pwd.value = "";
			frm.pwd.focus();
		}
	}
</script>


	<br><br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br><br>
</body>
</html>












