<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax JSON members</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script>
	$(function(){
		$("#getDataBtn").click(function(){
			getJsonMembers();
		});
	});
	function getJsonMembers() {
		// $.ajax(요청URL, {설정값들})
		$.ajax("getJsonMembers", {
			type : "get",
			dataType : "json",
			success : function(data){
				alert("Ajax 처리 성공!!! data :" + data);
				var tbody = "";
				var alist = data.list; //JSON 객체의 속성명 "list"의 값 추출.  (Array리스트 값을 넘겨 받았다.)
				$.each(alist, function(index, member){
					tbody += "<tr>";
					tbody += "<td>" + this["idx"] + "</td>";
					tbody += "<td>" + this["name"] + "</td>";
					tbody += "<td>" + this["age"] + "</td>";
					tbody += "<td>" + this["addr"] + "</td>";
					tbody += "<td>" + this["regdate"] + "</td>";
					tbody +="<\tr>"
					
					
				});
				$("#tbody").html(tbody);
				
				
				
			},
			error : function(jqXHR, textStatus, errorThrown){
				alert("Ajax 처리 실패 : \n"
					+ "jqXHR.readyState : " + jqXHR.readyState + "\n"
					+ "textStatus : " + textStatus + "\n"
					+ "errorThrown : " + errorThrown);
			}
		});
	}
</script>
</head>
<body>
	<h1>Ajax JSON 데이터 요청처리</h1>
	<button id="getDataBtn">JSON 데이터 가져오기</button>
	<hr>
	<table border>
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>나이</th>
				<th>주소</th>
				<th>날짜</th>
			<tr>
		</thead>
		<tbody id="tbody">
			<tr>
				<td>1</td>
				<td>홍길동</td>
				<td>27</td>
				<td>서울</td>
				<td>2020-07-23</td>
			</tr>
		</tbody>
	</table>
	<hr>



	<br><br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br><br>
</body>
</html>





















