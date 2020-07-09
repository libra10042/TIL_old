<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오류페이지</title>
<script>
	function go() {
		alert("[예외발생] 처리중 예외가 발생했습니다.\n"
				+ "이전페이지로 이동합니다.");
		history.back();
	}
</script>
</head>
<body onload="go()">

</body>
</html>








