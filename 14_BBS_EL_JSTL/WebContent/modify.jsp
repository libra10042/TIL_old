<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 전달받은 데이터를 화면에 표시하고, 수정버튼 클릭시 암호확인
	- 암호가 일치하면 : 수정요청처리(DB연동작업) - modify_ok.jsp
	- 암호가 불일치면 : 암호확인 메시지 표시 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
<script>
	function sendData() {
		var firstForm = document.forms[0];
		//게시글 항목에 값 유무 체크
		for (var i=0; i<firstForm.elements.length; i++) {
			if (firstForm.elements[i].value.trim() == "") {
				if (i == 3) continue; //파일은 제외
				alert(firstForm.elements[i].title + " 입력하세요");
				firstForm.elements[i].focus();
				return;
			}
		}
		
		//암호 일치여부 확인
		var pwd1 = document.myForm.pwd.value; //새로 입력된 값
		var pwd2 = "${bvo.pwd}"; //DB에 저장된 패스워드 값
		if (pwd1 != pwd2) {
			alert("암호가 일치하지 않습니다. 확인하세요");
			document.myForm.pwd.value = "";
			document.myForm.pwd.focus();
			return;
		}
		document.myForm.submit();
	}
	function list_go() {
		location.href = "list.jsp?cPage=${cPage}";
	}
</script>
</head>
<body>

<div id="bbs">
<form action="modify_ok.jsp" method="post"
		enctype="multipart/form-data" name="myForm">
	<table>
		<caption>게시글 수정</caption>
		<tbody>
			<tr>
				<th>제목</th>
				<td>
					<input type="text" name="subject" size="45" title="제목"
							value="${bvo.subject }">
				</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>
					<input type="text" name="writer" size="12" title="작성자"
							value="${bvo.writer }">
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<textarea name="content" rows="8" cols="50" title="내용">${bvo.content }</textarea>
				</td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td>
					<input type="file" name="file_name" >${bvo.file_name }
				</td>
			</tr>
			<tr>
				<th>패스워드</th>
				<td>
					<input type="password" name="pwd" size="12" title="패스워드">
				</td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="2">
					<input type="button" value="수정" onclick="sendData()">
					<input type="reset" value="다시작성">
					<input type="button" value="목록" onclick="list_go()">
				</td>
			</tr>
		</tfoot>
	</table>
</form>

</div>


	<br><br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br><br>
</body>
</html>












