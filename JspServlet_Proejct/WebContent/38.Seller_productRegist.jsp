<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String userid = (String)session.getAttribute("userid");
	System.out.println("메인페이지 현재 아이디 : " + userid);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/style.css">
    <title>상품등록페이지</title>
    <script src="//code.jquery.com/jquery-1.12.4.min.js"></script>
    <script>
        $(function(){
            $("#login_btn").click(function(){
                $(".lg").show();
            });
        });

    </script>
</head>
<body>
	<%@ include file="common/headerLogin.jsp" %> 
	
    
    <!----------------------- 포동애비 ---------------------------------->
    
    <h1 class="title">02.심사중</h1>

	<div class="o_step">
		<ul>
			<li class="step2_1"><img src="images/step_buy2.png"><br>
				<br>01.상품등록하기</li>
			<li class="step2_2"><img src="images/step_buy2.png"><br>
				<br>02.심사중</li>
			<li class="step2_3"><img src="images/step_buy3.png"><br>
				<br>03.상품등록완료</li>
		</ul>
	</div>
	<!-- ------------------------------------------------------------------------------------ -->
	
	
	
	
	
    
    <%@ include file="common/footer.jsp" %>
</body>
</html>