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
	<form:form action='input_pro' modelAttribute="dataBean1" method='post'>
		
		
		data1 : <form:input path='data1' type='text' /><br/>
				<form:errors path='data1'/><br/>
	
		data2 : <form:input path='data2' type='text'/><br/>
				<form:errors path='data2' /><br/>
		
		data3 : <form:input path='data3' type='text'/><br/>
				<form:errors path='data3' /><br/>
	
		data4 : <form:input path="data4"/><br/>
				<form:errors path='data4'/><br/>
		
		data5 : <form:input path='data5'/><br/>
				<form:errors path='data5'/><br/>
	
		
		data6 : <form:input path='data6' /><br/>
				<form:errors path="data6" /><br/>
	
		data7 : <form:input path="data7"/><br/>
				<form:errors path='data7'/><br/>
	
	
		<form:button type='submit'>확인</form:button>
	</form:form>

</body>
</html>