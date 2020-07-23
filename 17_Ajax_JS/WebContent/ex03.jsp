<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JS Ajax</title>
</head>
<body>
	<h1>서버로부터 응답 받은 결과</h1>
<script>
	// JavaScript에서 Ajax를 사용할 때 XMLHttpRequest 객체 사용
	//1. XMLHttpRequest 객체생성
	var request = new XMLHttpRequest();
	
	request.onreadystatechange = function(){
		if (request.readyState == 4) { //응답완료상태
			if (request.status == 200) { //정상처리된 경우
				//4. 응답데이터 처리(서버로 부터 전달받은 데이터)
				document.body.innerHTML += request.responseText;
			} else {
				alert("예외발생(상태값) : " + request.status);
			}
		}
	};
	
	//2. open("전송방식", "요청정보", "비동기여부")
	request.open("GET", "data2.html", false);
	
	//3. send() : 실행
	request.send();
	
	
</script>
	



	<br><br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br><br>
</body>
</html>












