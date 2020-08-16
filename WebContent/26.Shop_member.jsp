<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="css/reset.css">
	<link rel="stylesheet" href="css/main.css">
	<link rel="stylesheet" href="css/style.css">
    <title>메인화면</title>

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
<h1 class="title">회원정보수정</h1>
    
    <div class="div_member">
        <table class="table_member">
            <tr>
                <th id="name_top">이름</th>
                <td id="name_top">
                    <input type="text" id="m_text">
                </td>
            </tr>
            <tr>
                <th>생년월일</th>
                <td>
                    <select id="year">
                        <option>1992</option>
                        <option>1993</option>
                        <option>1994</option>
                        <option>1995</option>
                        <option>1996</option>
                    </select>&nbsp;년&nbsp;
                    
                    <select id="month">
                        <option>12</option>
                        <option>11</option>
                        <option>10</option>
                        <option>9</option>
                    </select>&nbsp;월&nbsp;
                    
                    <select id="day">
                        <option>8</option>
                    </select>&nbsp;일&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="radio" id="man" name="gender">
                    <label for="man">남</label>&nbsp;&nbsp;
                    <input type="radio" id="woman" name="gender">
                    <label for="woman">여</label>
                </td>
            </tr>
            <tr>
                <th>아이디</th>
                <td><b>podongEbi</b></td>
            </tr>
            <tr>
                <th>비밀번호</th>
                <td>
                    <input type="text" id="m_text">
                </td>
            </tr>
            <tr>
                <th>비밀번호 확인</th>
                <td>
                    <input type="text" id="m_text">
                </td>
            </tr>
            <tr>
                <th>휴대전화</th>
                <td>
                    <select id="m_phone">
                        <option>010</option>
                        <option>011</option>
                        <option>016</option>
                        <option>017</option>
                    </select>&nbsp;-&nbsp;
                    
                    <input type="text" id="m_text2">&nbsp;-&nbsp;
                    
                    <input type="text" id="m_text2">
                </td>
            </tr>
            <tr>
                <th>이메일 주소</th>
                <td>
                    <input type="text" id="m_text">@
                            <input type="text" id="m_text" class="m_text">&nbsp;
                    <select id="m_address">
                        <option value="">직접입력</option>
                        <option value="naver.com">naver.com</option>
                        <option value="daum.net">daum.net</option>
                        <option value="paran.com">paran.com</option>
                        <option value="podong.com">podong.com</option>
                    </select>
                </td>
            </tr>
            <tr id="ad_hgt">
                <th>주소</th>
                    <td>
                        <div class="paybox">
                            <input type="text" id="m_text3">
                        </div>
                        <div class="paybox">
                            <input type="text" id="m_text3">&nbsp;(상세주소)
                        </div>
                    </td>
            </tr>
        </table>
    </div>

    <div class="div_member2">
        <input type="button" value="확인" id="c_button3">&nbsp;&nbsp;
        <input type="button" value="취소" id="c_button1">
    </div>
<%@ include file="common/footer.jsp" %>
</body>
</html>