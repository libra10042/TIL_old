<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSON 데이터 요청처리</title>
</head>
<body>
	<h1>JSON 데이터 요청처리</h1>
<script>
	// JavaScript에서 Ajax를 사용할 때 XMLHttpRequest 객체 사용
	//1. XMLHttpRequest 객체생성
	var request = new XMLHttpRequest();
	
	request.onreadystatechange = function(){
		if (request.readyState == 4 && request.status == 200) { //응답완료&정상처리된 경우
			//받은 데이터 확인
			alert("리턴받은 값(문자열) : \n" + request.responseText);
			
			//JSON.parse() 사용 : 문자열 -> JS객체화
			var json = JSON.parse(request.responseText);
			alert("JSON.parse() 처리후 : " + json);
			
			//JSON 객체 데이터 추출
			var output = "";
			for (let i=0; i<json.length; i++) {
				output += "<h2>";
				output += json[i].name + " : " + json[i]["price"]
				output += "</h2>";
			}
			output += "<hr><hr>";
			
			document.body.innerHTML += output;
		}
	};
	
	//2. open("전송방식", "요청정보", "비동기여부")
	request.open("GET", "data.json", false);
	
	//3. send() : 실행
	request.send();
	
	
</script>	



	<br><br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br><br>
</body>
</html>












