<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="com.bc.mybatis.DBService"%>
<%@page import="com.bc.mybatis.GuestbookVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 선택된 데이터 삭제 처리(파라미터 pwd값과 session 데이터 사용) 
	전달받은 pwd와 session에 저장된 VO객체의 pwd 값 비교
	- 일치하면 : 삭제 후 목록페이지로 이동(삭제 메시지 표시)
	- 불일치 : 이전페이지로 이동(암호불일치 메시지 표시 후)
--%>
<%
	//0. 한글처리를 위한 encoding 타입 설정
	request.setCharacterEncoding("UTF-8");
	
	String pwd = request.getParameter("pwd");
	GuestbookVO vo = (GuestbookVO) session.getAttribute("guestbookVO");
	System.out.println("param pwd: " + pwd + ", vo pwd: " + vo.getPwd());
	
	if (!pwd.equals(vo.getPwd())) { //암호 불일치
%>
	<script>
		alert("암호불일치, 암호를 확인하세요.");
		history.back();
	</script>
<%		
	} else { //암호일치 : DB데이터 삭제 후 목록페이지로 이동
		SqlSession ss = DBService.getFactory().openSession(true);
		try {
			ss.delete("guestbook.delete", vo.getIdx());
%>			
			<script>
				alert("정상 삭제되었습니다! 목록페이지 이동");
				location.href = "list.jsp";
			</script>
<%			
		} catch(Exception e) {
			e.printStackTrace();
%>
			<script>
				alert("[예외발생] 삭제실패! 목록페이지 이동");
				location.href = "list.jsp";
			</script>
<%			
		} finally {
			ss.close();
		}
	}
%>













