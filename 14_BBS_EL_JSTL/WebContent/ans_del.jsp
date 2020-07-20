<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 전달받은 파라미터 값 사용 비밀번호 확인 후 
	비밀번호 일치 : DB에서 댓글 삭제 요청 처리
	비밀번호 불일치 : 암호가 다르다 메시지 표시 --%>
<%
	request.setCharacterEncoding("UTF-8");

	String c_idx = request.getParameter("c_idx");
	//(개인별실습) 암호를 전달받지 않고 삭제요청시 서버측에서 암호확인 처리 
	String pwd = request.getParameter("pwd");
	
	String b_idx = request.getParameter("b_idx");
	
	//EL, JSTL 사용을 위해 scope에 속성 설정
	pageContext.setAttribute("c_idx", c_idx);
	pageContext.setAttribute("pwd", pwd);
	pageContext.setAttribute("b_idx", b_idx);
%>	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>댓글삭제(암호확인)</title>
<script>
	function ans_del(frm) {
		var pwd1 = frm.pwd.value; //새로 입력한 암호
		var pwd2 = "${pwd}";
		if (pwd1 != pwd2) {
			alert("비밀번호가 일치하지 않습니다.");
			frm.pwd.value ="";
			frm.pwd.focus();
			return false;
		}
		var isDelete = confirm("정말 삭제하시겠습니까?");
		if (isDelete) {
			frm.submit(); //삭제처리 진행
		} else {
			history.back(); //삭제취소하고 이전페이지로 이동
		}
	}
</script>
</head>
<body>

<form action="ans_del_ok.jsp" method="post">
	비밀번호 : <input type="password" name="pwd">
	<input type="button" value="삭제" onclick="ans_del(this.form)">
	<input type="hidden" name="c_idx" value="${c_idx }">
	<input type="hidden" name="b_idx" value="${b_idx }">
</form>



	<br><br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br><br>
</body>
</html>












