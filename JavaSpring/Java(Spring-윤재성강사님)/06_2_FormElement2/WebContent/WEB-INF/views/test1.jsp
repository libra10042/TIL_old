<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<H1>test1</H1>
	<form:form action='result' modelAttribute="dataBean">
		<form:select path="a1">
			<form:option value="data1">항목1</form:option>
			<form:option value="data2">항목2</form:option>
			<form:option value="data3">항목3</form:option>
		</form:select>
		<hr />

		<form:select path="a2">
			<form:options items="${requestScope.data_list1}" />
		</form:select>
		<hr />
		
		<form:select path="a3">
			<form:options items="${requestScope.data_list2 }"/>
		</form:select>

		<hr />
		<form:select path="a4">
			<form:options items="${requestScope.data_list3}" itemLabel="key" itemValue="value" />
		</form:select>
		
		<hr />
		<form:checkbox path="a5" value="data1" />항목1
		<form:checkbox path="a5" value="data2" />항목2
		<form:checkbox path="a5" value="data3" />항목3
		<form:checkbox path="a5" value="data4" />항목4
		
		
		<hr />
		<form:checkboxes items="${requestScope.data_list1 }" path="a6" />
		
		
		<hr />
		<form:checkboxes items="${requestScope.data_list2 }" path="a7"/>
		
		
		<hr />
		<form:checkboxes items="${requestScope.data_list3 }" path="a8" itemsLabel="key" itemValue="value" />
		
		
		<hr />
		<form:radiobutton path="a9" value="data1"/>항목1
		<form:radiobutton path="a9" value="data2"/>항목2
		<form:radiobutton path="a9" value="data3"/>항목3
		
		
		<hr />
		<form:radiobuttons path="a10" items="${requestScope.data_list1 }"/>
		
		<hr />
		<form:radiobuttons path="a11" items="${requestScope.data_list2 }" />
		
		<hr />
		<form:radiobuttons path="a12" items="${requestScope.data_list3 }" itemLabel="key" itemValue="value" />
		
		
	</form:form>

	<hr />


</body>
</html>