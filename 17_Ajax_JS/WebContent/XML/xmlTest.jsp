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
		if (request.readyState == 4 && request.status == 200) { //정상처리된 경우
			//데이터 확인 : XML 오브젝트가 있음 - HTML의 DOM 처리와 동일하게 사용
			var xml = request.responseXML; 
			alert("xml : " + xml);
			
			// XML에서 데이터 추출
			var names = xml.getElementsByTagName("name");
			var prices = xml.getElementsByTagName("price");
			
			//데이터 사용
			let output = "";
			for (let i=0; i<names.length; i++) {
				console.log("name : " + names[i]);
				let name = names[i].childNodes[0].nodeValue;
				let price = prices[i].childNodes[0].nodeValue;
				
				output += "<h2>" + name + " : " + price + "</h2>";
			}
			document.body.innerHTML += output;
		}
	};
	
	//2. open("전송방식", "요청정보", "비동기여부")
	request.open("GET", "data.xml", false);
	
	//3. send() : 실행
	request.send();
	
	
</script>
	



	<br><br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br><br>
</body>
</html>












