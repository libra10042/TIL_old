<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>input_data</h1>
	<form:form action="input_pro" modelAttribute="dataBean1" method='post'>
		
		data1 : <form:input path="data1" value='true'/> true
				<form:input path="data1" value='false'/> false<br/>
				<form:errors path='data1'/><br/>
	
		data2 : <form:radiobutton path="data2" value="true"/>true
				<form:radiobutton path="data2" value="false"/> false <br/>
				<form:errors path='data2'/><br/>
				
				
		data3 : <form:input path="data3" type='text'/><br/>
				<form:errors path="data3" /><br/>		
		
		
		data4 : <form:input path="data4" type='text'/><br/>
				<form:errors path='data4'></form:errors><br/>
		 
		
		data5 : <form:checkbox path="data5" value='check1'/>checkbox1 <br/>
				<form:errors path='data5'/><br/>
		
		
		data6 : <form:checkbox path="data5" value='check2'/>checkbox2<br/>
				<form:errors path='data6'/><br/>
		
		data7 : <form:input path="data7" type="text"/><br/>
				<form:errors path="data7"/><br/>
		
		
		data8 : <form:input path="data8" type="text" /><br/>
				<form:errors path="data8" /><br/>
		
		
		data9 : <form:input path="data9" type="text"/><br/>
				<form:errors path="data9" /><br/>
		
		
		
		<form:button type='submit'>확인</form:button>
	
	</form:form>
	
	
</body>
</html>