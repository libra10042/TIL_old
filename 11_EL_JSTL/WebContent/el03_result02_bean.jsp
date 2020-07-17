<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 전달받은 파라미터값을 자바빈(Bean) VO에 저장해서 사용 --%>
<%
	//한글처리
	request.setCharacterEncoding("UTF-8");
%>
	<jsp:useBean id="vo" class="com.bc.vo.PersonVO" />
	<jsp:setProperty property="*" name="vo" />
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자바빈(Bean)</title>
</head>
<body>
	<h2>결과보기(Bean 사용)</h2>
	<ul>
		<li>이름 : <%=vo.getName() %></li>
		<li>나이 : <%=vo.getAge() %></li>
		<li>성별 : <%=vo.getGender() %></li>
		<li>취미 : <%=vo.getHobby() %></li>
		<li>취미(반복문) :
<%
		for (String h : vo.getHobby()) { %>
			<%=h %>&nbsp;&nbsp;
<%			
		}
%>	
		</li>
	</ul>
	<hr>
	
	<h3>Bean 데이터 EL사용</h3>
	<ol>
		<li>이름 : ${vo.getName() }</li>
		<li>나이 : ${vo.getAge() }</li>
		<li>성별 : ${vo.gender }</li>
		
		<li>취미 : ${vo.hobby }</li>
		<li>취미(데이터) :
			-${vo.hobby[0] } 
			${vo.hobby[1] } 
			${vo.hobby[2] } 
			${vo.hobby[3] }-
		</li>
	</ol>
	
	
	<br><br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br><br>
</body>
</html>












