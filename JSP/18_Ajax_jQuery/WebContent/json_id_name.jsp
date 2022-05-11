<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jQuery Ajax</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script>
	//$(document).ready(function(){});
	//$().ready(function(){});
	$(function(){
		$("#getDataBtn").click(function(){
			//alert("#getDataBtn 클릭~~");
			getIdName();
		});
	});
	function getIdName() {
		//alert("getIdName() 실행~~");
		/* jQuery.ajax({url,type,data, datatype});
		   $.ajax({url,type,data, datatype});
		   $.ajax(url, {type,data, datatype});
		   url : 서버 url (jsp, php, asp);
		   type : get, post
		   data : 서버쪽으로 전송되는 데이터
		   dataType : 응답결과의 데이터 형태 (xml, html, json, text, script,....)
		   success : 성공한 경우 
		   error : 실패한 경우*/
		$.ajax("getIdName", {
			type : "get",
			data : "id=hong&pwd=1234",
			dataType : "json",
			success : function(result){
				alert("Ajax 처리 성공!!!");
				alert("전달받은 결과값 : " + result + "\n"
						+ "문자열로 표시 : " + JSON.stringify(result));
				var output = "";
				output += "<h2>아이디 : " + result.id + "</h2>";
				output += "<h2>이름 : " + result.name + "</h2>";
				
				//HTML 출력 영역에 표시
				$("#dataDisp").html(output);
				
			},
			error : function(){
				alert("[예외발생] Ajax 처리실패!!!");
			}
		});
	}
</script>
</head>
<body>
	<h1>(jQuery)Ajax JSON 요청 처리</h1>
	<button id="getDataBtn">JSON 데이터 가져오기(id, name)</button>
	<hr>
	<div id="dataDisp">가져온 데이터 출력될 영역</div>
	<hr>
	<h2>위쪽 영역에 Ajax에 의해 가져온 데이터 표시</h2>


	<br><br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br><br>
</body>
</html>












