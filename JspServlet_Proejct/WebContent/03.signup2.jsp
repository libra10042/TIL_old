<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="css/style.css">
    <title>회원가입-자바스크립트</title>
    <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>  
	<script type="text/javascript">
		
		function validate() {
			
			var firstForm = document.signUpForm;
			
	        for(let i=0; i < firstForm.length; i++){
	            if (firstForm.elements[i].value.trim() == "") {
	               alert(firstForm.elements[i].title + " 입력 해주세요.");
	               firstForm.elements[i].focus();
	               return;
	            }
	        }
      
	        //비밀번호 일치 확인 
			var pwd1 = firstForm.elements[3].value;   
			var pwd2 = firstForm.elements[4].value;

			if (pwd1 != pwd2) {
				alert("비밀번호가 일치하지 않습니다.");
				firstForm.elements[3].value = "";
				firstForm.elements[3].focus();
				return false;
   
			} else {
				firstForm.action="controller?type=register"
				firstForm.submit();
			}
      
		}
		
	</script>
</head>
<body> 
<% if(session.getAttribute("userid") == null) { %>
	<%@ include file="common/header.jsp" %> 
<%
	} else { %>
	<%@ include file="common/headerLogin.jsp" %>	
<%
	}
%> 
	<div class="wrap">
	<form method = "post"  name="signUpForm">
        <div class="join_chang" style="background-color: #fff3e5; padding: 10px; width: 1000px; text-align: center; margin-left: 230px;">
            <h2>JOIN US</h2>
        </div>
        
        <div style="width: 1000px; text-align: center; margin-left: 240px; padding: 20px">
            <p style="color: gray;">비트마켓 회원가입으로 다양한 혜택을 누리세요.</p>
        </div>
        <!--내용항목-->
        <div class="form_group">

            <!--이름-->
            <div class="form_name">
                <label class="label">이름</label>
                <!--입력하는 네모창 -->
                <input type="text" class="form_ele" style="margin-left:50px;"name="name" id="NAME" title="이름"><br>
            </div>
            <div class="line"></div>
    
            <!--아이디-->
            <div class="form_id">
                <label class="label">아이디</label>
                <!--입력하는 네모창 -->
                <input type="text" class="form_ele" style="margin-left:39px;" name="id" title="아이디">
   
                <!--중복확인 버튼-->
                <input type="button" class="id_c" value="중복확인">
                <p style="font-size: 0.9em; color: gray; margin-top: 1%; margin-right: 30%; 
                float: right;">4~20자의 영, 숫자만 사용 할 수 있습니다.</p><br><br>
            </div>
            <div class="line"></div>
    
            <!--비밀번호-->
            <div class=form_pwd>
                <label class="label">비밀번호</label>
                <!--입력하는 네모창 -->
                <input type="password" class="form_ele" style="margin-left:2.8%;" name="password" title="비밀번호">
                <!--비밀번호 확인-->
                <label class="label" style="margin-left:4%;">비밀번호 확인</label>
                <!--입력하는 네모창 -->
                <input type="password" class="form_ele" style="margin-left:2%;" name="password2" title="비밀번호 확인"><br><br>
             </div>
            <div class="line"></div>   
    
            <!--휴대전화-->
            <div class="from_ph">
                <label class="label">휴대전화</label>
                    <li class="ph_n"><!--휴대폰 번호 앞자리 선택-->
                        <select name="phone0"style="width:20%; margin-left:29px; padding:8px;
                        font-size: 13px; border: 1px solid gainsboro;">
	                        <option>선택</option>
	                        <option>010</option>
	                        <option>011</option>
	                        <option>016</option>
	                        <option>017</option>
	                        <option>018</option>
	                        <option>019</option>
                        </select>
                <!--입력하는 네모창 -->
                <input type="text" style="margin-left:10px; border: 1px solid gainsboro;
                width:20%; padding:8px;" name="phone1" title="휴대폰번호"> &nbsp;&nbsp;-
                <!--입력하는 네모창 -->
                <input type="text" style="margin-left:6px; border: 1px solid gainsboro;
                width:20%; padding:8px;" name="phone2" title="휴대폰번호"></li>
            </div>
            <div class="line2"></div>
        
            <!--sms수신-->
            <div class="form_enter">
                <label class="label">SMS수신</label>
                <input type="radio" name="p_agree" value="okay"checked="checked" style="margin-left: 40px;">
                <span style="font-weight: bold; color: gray;">받습니다.</span>
                <input type="radio" name="p_agree" value="not" style="margin-left: 40px;">
                <span style="font-weight: bold; color: gray;">받지 않습니다. </span>

                <div class="form_notice">
                    *sms 수신을 받지 않을 시 '입고지연/품절 안내불가'
                </div>
            </div>
            <div class="line"></div>
            <!--이메일 주소-->
            <div class="form_email">
                <label class="label">이메일 주소</label>
                <!--입력하는 네모창 -->
                <input type="text" class="email_form" name="email0" title="이메일"><span style="color: gray;">&nbsp;@</span>
                <!--입력하는 네모창 -->
                <input type="text" class="email_form" name="email1" style="margin-left: auto;">

                <li class="em_add"> 
                    <select name="email3" style="width:80%; padding:7.4px;
                    font-size: 13px; border: 1px solid gainsboro;">
                        <option>직접선택</option>
                        <option>naver.com</option>
                        <option>hotmail.com</option>
                        <option>hanmail.net</option>
                        <option>yahoo.com</option>
                        <option>nate.com</option> 
                        <option>gmail.com</option>
                    </select>  
                </li>
           
                <div class="line2"></div> 
            
                <!--이메일 수신확인 여부-->
                <div class="form_enter">
                    <label class="label" style=font-size:0.8em;>이메일수신여부</label>
                    <input type="radio" name="m_agree" value="okay"checked="checked" style="margin-left: 20px;">
                    <span style="font-weight:bold; color: gray;">받습니다.</span>
                    <input type="radio" name="m_agree" value="not" style="margin-left: 40px;">
                    <span style="font-weight: bold; color: gray;">받지 않습니다. </span>
                
                    <div class="form_notice">
                        *받기를 선택하시면 배송정보, 이벤트 메일을 수신합니다.
                    </div>
                </div>
        
            </div>
            <div class="line"></div>

            <!--주소-->
          
               
                <!--기본,상세주소-->
                
                    <label class="label">주소</label>
            <div class="form_ele_plus1">
	            <input type="text" class="form_ele_plus" name="addr0">&nbsp;&nbsp;[기본주소]
	            <input type="text" class="form_ele_plus" style="margin-left:5%"; name="addr1">&nbsp;&nbsp;[상세주소]
            </div>
        </div>
	    <!--완료(가입취소회원가입) 버튼-->
	    <div class="form_btn" style="width: 1000px; margin: auto; padding-left: 650px;">
	        <input type="submit" class="form_btn2" value="회원가입"  onclick="validate()" >
	    <!--완료(회원가입) 버튼-->
	        <input type="button" class="form_btn1" value="가입취소" onclick="javascript:location.href='01.main.jsp'">
	        <div class="line2"></div>
            <br><br><br><br><br><br><br><br><br><br><br><br><br><br>
	    </div>
    </form>
</div>
<%@ include file="common/footer.jsp" %> 
</body>
</html>