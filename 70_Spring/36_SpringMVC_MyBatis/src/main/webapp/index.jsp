<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시작페이지</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script>
	function getJsonData() {
		alert("getJsonData() 실행~~~");
		$.ajax("dataTransform.do", {
			type : "get",
			dataType : "json",
			success : function(data){
				alert("성공~~~");
				console.log(data);
				var dispHtml = "";
				dispHtml += "<ul>";
				$.each(data, function(index, obj){
					dispHtml += "<li>";
					dispHtml += this.seq + ", ";
					dispHtml += this.title + ", ";
					dispHtml += this["writer"] + ", ";
					dispHtml += obj["regdate"] + ", ";
					dispHtml += obj["cnt"] + ", ";
					dispHtml += "</li>";
				});
				dispHtml += "</ul>";
				
				$("#listDisp").html(dispHtml);
			},
			error : function(){
				alert("실패!!!");
			}
		});
	}
</script>
</head>
<body>

<div id="container">
	<h1>게시판 프로그램</h1>
	<hr>
	<p><a href="login.do">로그인 페이지로 이동(GET)</a></p>
	<p><a href="getBoardList.do">글 목록 보러가기</a></p>
	<hr>
	<p><a href="dataTransform.do">데이터전환(JSON)</a></p>
	
	<hr><hr>
	<p><a href="javascript:getJsonData()">JSON 데이타 받아서 화면표시</a></p>
	
</div>
<hr>
<div id="listDisp">
	<ul>
		<li>데이타 가져와서 출력하기</li>
	</ul>
</div>


</body>
</html>






