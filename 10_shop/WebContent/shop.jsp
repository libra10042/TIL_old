<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쇼핑몰 메인</title>
<style>
	#wrap { margin: 0 auto; }
	hr { width: 600px; border: 1px solid navy; }
	#header, #nav {
		width: 600px;
		margin: 10px auto;
		text-align: center;
	}
	#header { font-size: 2em; }
	#nav { font-size: 1.3em; }
	#nav a { text-decoration: none; }
	#nav a:hover { text-decoration: underline; color: red; }
</style>
</head>
<body>

<div id="wrap">
	<hr>
	<div id="header">
		<span class="title">SHOPPING CENTER</span>
	</div>
	<hr>
	<div id="nav">
		<a href="product_list.jsp?category=com001">컴퓨터</a> |
		<a href="product_list.jsp?category=ele002">가전제품</a> |
		<a href="product_list.jsp?category=sp003">스포츠</a>
	</div>
</div>

</body>
</html>









