<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
	String userid = (String)session.getAttribute("userid");
	System.out.println("현재 주문페이지 아이디 : " + userid);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="css/reset.css">
	<link rel="stylesheet" href="css/main.css">
	<link rel="stylesheet" href="css/style.css">
    <title>메인화면</title>
<body>
<% if(session.getAttribute("userid") == null) { %>
	<%@ include file="common/header.jsp" %> 
<%
	} else { %>
	<%@ include file="common/headerLogin.jsp" %>	
<%
	}
%>  
    <h1 class="title">주문서작성</h1>
    
    <div class="o_step">
        <ul>
            <li class="step2_1">
                <img src="images/step_buy1.png"><br><br>01.장바구니
            </li>
            <li class="step2_2">
                <img src="images/step_buy2.png"><br><br>02.주문서작성
            </li>
            <li class="step2_3">
                <img src="images/step_buy3.png"><br><br>03.주문완료
            </li>
        </ul>
    </div>
    
    <form method="post">
    
    <div class="div_k2">
        
        <div>
            <h2>주문리스트</h2>
        </div>
        <div class="div_cart_2_1">
            <table class="table_cart_2_1">
                <colgroup>
                    <col width=20%>
                    <col width=50%>
                    <col width=10%>
                    <col width=15%>
                    <col width=5%>
                </colgroup>
                <tr>
                    <th>사진</th>
                    <th>상품명</th>
                    <th>수량</th>
                    <th>가격</th>
                    <th>적립</th>
                </tr>
                
                <c:forEach var="view" items="${cList }">
	                <tr>
	                    <td>
	                        <img src="images/${view.p_thumbnail }" alt="썸네일이미지" style="width:220px; height:202px">
	                    </td>
	                    <td>${view.p_name }(${view.o_option})</td>
	                    <td>${view.c_quantity }개</td>
	                    <td>${view.p_price }원</td>
	                    <td>${view.c_reserve }원</td>
	                </tr>
	            <c:set var="totalPrice" value="${totalPrice + view.p_price}"/>
                <c:set var="totalReserve" value="${totalReserve + view.c_reserve}"/>
                </c:forEach>
            </table>
        </div>
        
        <div>
            <h2>주문자정보</h2>
        </div>
        <div class="div_cart_2_2">
            <table class="table_cart_2_2">
                <tr>
                    <th>이름</th>
                    <td>${name }</td>
                </tr>
                <tr>
                    <th>이메일</th>
                        <td>
                            <input type="text" id="m_text" name="email1">@
                            <input type="text" id="m_text" name="email2" class="m_text">&nbsp;
                            <select id="m_address">
                                <option value="">직접입력</option>
                                <option value="naver.com">naver.com</option>
                                <option value="daum.net">daum.net</option>
                                <option value="paran.com">paran.com</option>
                                <option value="podong.com">podong.com</option>
                            </select>
                        </td>
                </tr>
                <tr>
                    <th>연락처</th>
                    <td>
                        <select id="m_phone" name="">
                            <option>010</option>
                            <option>011</option>
                            <option>016</option>
                            <option>017</option>
                        </select>&nbsp;-&nbsp;
                        <input type="text" id="m_text2" name="" value="">&nbsp;-&nbsp;
                        <input type="text" id="m_text2" name="" value="">
                    </td>
                </tr>
            </table>
        </div>

        <div>
            <h2>배송정보</h2>
        </div>
        <div class="div_cart_2_3">
            <table class="table_cart_2_3">
                <tr>
                    <th>이름</th>
                    <td><input type="text" id="m_text" name="name" value="" title="이름"></td>
                </tr>
                <tr>
                    <th>연락처</th>
                    <td>
                        <select id="m_phone" name="phone1">
                            <option>010</option>
                            <option>011</option>
                            <option>016</option>
                            <option>017</option>
                        </select>&nbsp;-&nbsp;
                        <input type="text" id="m_text2" name="phone2" value="" title="전화번호">&nbsp;-&nbsp;
                        <input type="text" id="m_text2" name="phone3" value="" title="전화번호">
                    </td>
                </tr>
                <tr>
                    <th>배송지 선택</th>
                    <td>
                        <input type="radio" id="a_home" name="arrive">
                        <label for="a_home">자택</label>&nbsp;
                        <input type="radio" id="a_near" name="arrive">
                        <label for="a_near">최근 배송지</label>&nbsp;
                        <input type="radio" id="a_new" name="arrive" checked>
                        <label for="a_new">신규 배송지</label>
                    </td>
                </tr>
                <tr>
                    <th>주소</th>
                    <td>
                        <div class="paybox">
                            <input type="text" id="m_text3" name="addr1" value="" title="주소">
                        </div>
                        <div class="paybox">
                            <input type="text" id="m_text3"  name="addr2" value="" title="상세주소">&nbsp;(상세주소)
                        </div>
                    </td>
                </tr>
                <tr>
                    <th>주문메세지<br>(100자내외)</th>
                    <td>
                        <textarea rows="10px" cols="30px" id="text_area"></textarea>
                    </td>
                </tr>
                <tr>
                    <th>무통장 입금자명</th>
                    <td>
                        <input type="text" id="m_text2">&nbsp;(주문자와 같을경우 생략 가능)
                    </td>
                </tr>
            </table>
        </div>
        
        <div>
            <h2>주문상품 할인적용</h2>
        </div>
        <div class="div_cart_2_4">
            <table class="table_cart_2_4">
                <colgroup>
                    <col width="16%">
                    <col width="10%">
                    <col width="16%">
                    <col width="10%">
                    <col width="16%">
                    <col width="10%">
                    <col width="16%">
                </colgroup>
                <tr>
                    <th>상품금액</th>
                    <th> </th>
                    <th>배송비</th>
                    <th> </th>
                    <th>할인금액</th>
                    <th> </th>
                    <th>결제 예정금액</th>
                </tr>
                <tr id="o_dc">
                    <td>${totalPrice }원</td>
                    <td>+</td>
                    <td>무료</td>
                    <td>-</td>
                    <td>0원</td>
                    <td>=</td>
                    <td>${totalPrice }원</td>
                </tr>
                <tr>
                    <th>적립금 사용</th>
                    <td colspan="6">
                        <input type="text" id="m_text">&nbsp;
                        <input type="checkbox" id="p_all">&nbsp;
                        <label for="p_all">전액사용(사용가능 적립금: 3000원 이상)</label>
                    </td>
                </tr>
                <tr>
                    <th>쿠폰사용</th>
                    <td colspan="6">
                        <input type="text" id="m_text">
                        <input type="button" value="쿠폰선택" id="l_button2">
                    </td>
                </tr>
            </table>
        </div>
        
        <div>
            <h2>결제 정보</h2>
        </div>
        <div class="div_cart_2_5">
            <table class="table_cart_2_5">
                <tr>
                    <th>
                        <img src="images/ico_escrow_kcp.gif">
                    </th>
                    <td>고객님의 안전거래를 위해 현금으로 결제하실 때 저희 쇼핑Mall에 가입한 KCP의 구매안전서비스를 이용할 수 있습니다.</td>
                </tr>
                <tr>
                    <th>결제방법</th>
                    <td>
                        <div class="paybox">
                            <input type="radio" id="credit" name="pay">&nbsp;
                            <label for="credit">신용카드</label>
                        </div>
                        <div class="paybox">
                            <input type="radio" id="bank" name="pay">&nbsp;
                            <label for="bank">무통장입금</label>
                            <select id="m_card">
                                <option>입금 계좌번호 선택(반드시 주문자 성함으로 입금)</option>
                                <option>신한은행 110-319-569820 (예금주:(주)포동애비)</option>
                                <option>국민은행 0107-187-7995 (예금주:(주)덕소도련)</option>
                            </select>
                        </div>
                        <div class="paybox">
                            <input type="radio" id="live" name="pay">&nbsp;
                            <label for="live">실시간 계좌이체</label>
                        </div>
                        <div class="paybox">
                            <input type="radio" id="phone" name="pay">&nbsp;
                            <label for="phone">휴대폰 결제</label>
                        </div>
                        
                    </td>
                </tr>
                <tr>
                    <th>증빙 신청</th>
                    <td>
                        <input type="radio" id="n" name="call">&nbsp;
                        <label for="n">신청안함</label>&nbsp;
                        <input type="radio" id="y" name="call">&nbsp;
                        <label for="y">현금영수증</label>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <div class="paybox">
                        ·선택된 입금계좌로 인터넷 뱅킹, 은행 방문 등을 통해 입금해 주세요.
                        </div>
                        <div class="paybox">
                        ·반드시 입금 기한 내에 정확한 결제금액을 입금해 주세요.
                        </div>
                        <div class="paybox">
                        ·입금 기한이 지나면 주문은 자동취소됩니다.
                        </div>
                    </td>
                </tr>
            </table>
        </div>
        
        <div>
            <h2>주문자 동의</h2>
        </div>
        <div class="div_cart_2_6">
            <table class="table_cart_2_6">
                <tr>
                    <th>주문동의</th>
                    <td>
                        <input type="checkbox" id="agree">&nbsp;
                        <label for="agree">상기 결제정보를 확인하였으며, 구매진행에 동의합니다.</label>
                    </td>
                </tr>
                <tr>
                    <th>최종 결제금액</th>
                    <td>${totalPrice }원 (적립예정: ${totalReserve }원)<br>
                    (적립 예정금액과 최종 적립금액은 상이할 수 있습니다. 
                    주문 완료 시 지급되는 적립금을 확인해주시기 바랍니다.</td>
                </tr>
            </table>
        </div>
        
        <div class="div_o_button">
            <input type="button" value="주문하기" id="c_button3_cardpass">&nbsp;&nbsp;
            <input type="button" value="주문취소" id="c_button1">      
        </div>
    </div>
    
    
    
    
    <!-- 카드결제 페이지 -->
    
    <div class="div_cardpass">
        <table class="table_carpass_head">
            <tr>
                <th id="cardpass_head">카드결제 페이지</th>
                <th colspan="2" id="close">
                    <input type="button" value="X" id="close_x">
                </th>
            </tr>
        </table>
        <table class="table_cardpass">            
            <tr id="normalpass">
                <td id="normal_left">일반결제</td>
                <td></td>
            </tr>
            <tr id="card_choice">
                <td>카드선택</td>
                <td>
                    <input type="radio" id="shinhan" name="cardnum">&nbsp;
                    <label for="shinhan">신한카드</label>&nbsp;
                    <input type="radio" id="kb" name="cardnum">&nbsp;
                    <label for="kb">국민카드</label>&nbsp;
                    <input type="radio" id="poca" name="cardnum">&nbsp;
                    <label for="poca">포동카드</label>&nbsp;
                    <input type="radio" id="geca" name="cardnum">&nbsp;
                    <label for="geca">지니카드</label>
                </td>
            </tr>
            <tr>
                <td>카드번호</td>
                <td>
                    <input type="text" id="n_box">-
                    <input type="text" id="n_box">-
                    <input type="text" id="n_box">-
                    <input type="text" id="n_box">
                </td>
            </tr>
            <tr>
                <td>CVC 번호<br>(숫자 3자리 입력)</td>
                <td>
                    <input type="text" id="n_box">
                </td>
            </tr>
            <tr>
                <td>카드 비밀번호<br>(숫자 4자리)</td>
                <td>
                    <input type="text" id="n_box">
                </td>
            </tr>
            <tr id="n_but">
                <td colspan="2">
                    <input type="button" value="취소" id="n_but1">
                    <input type="button" value="확인" id="n_but2" onclick="write_order(this.form)">
                </td>
            </tr>
        </table>
    </div>
    <input type="hidden" name="userid" value="<%=userid%>">
    <input type="hidden" name="s_idx" value="${cList.s_idx }">
    <input type="hidden" name="" value="">
    <input type="hidden" name="" value="">
    <input type="hidden" name="" value="">
    </form>
    <%@ include file="common/footer.jsp" %>
</body>

<script>
		
	$(function(){
        $("#close_x").click(function(){
            $(".div_cardpass").hide();
        });
        
        $("#n_but1").click(function(){
            $(".div_cardpass").hide();
        });
        
        $("#m_address").change(function(){
            var address = $(this).val();
            $(".m_text").val(address);
        });
        
        $("#c_button3_cardpass").click(function(){
            if($("#agree").is(":checked")==false){
                alert("상기 결제정보 체크란에 동의하셔야 구매 가능합니당 ;;");
                return false;
            } else {
                $(".div_cardpass").show();
            }
        });
    });
	
	function write_order(frm) {
		frm.action = "controller?type=write";
		frm.submit();
	}
</script>

</html>