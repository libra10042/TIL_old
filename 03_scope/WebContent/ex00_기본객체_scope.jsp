<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
1. JSP의 기본객체 9가지
	- 선언없이 사용할 수 있는 객체
	- JSP가 서블릿으로 변경될 때 JSP에서 작성한 코드 이전에
	  생성(존재)되어 있는 객체
	- request, response, out
	- pageContext, session, application, config, page, exception
	
	request : 클라이언트의 요청정보를 저장한 객체
	response : 응답정보를 저장
	out : 결과를 출력할 때 사용하는 출력 스트림
	
	pageContext : JSP 페이지에 대한 정보를 저장
	page : JSP 페이지를 구현한 자바 클래스의 인스턴스(Object 타입)
		   JSP에서 자기자신을 참조할 때 사용
		   JSP 컨테이너에서 생성된 서블릿객체를 참조하는 참조변수
	config : JSP 페이지에 대한 설정 정보 저장
	exception : 일반페이지에서는 사용할 수 없고, 오류페이지에서만 사용 가능

================================================================
2. 영역 scope(범위)
	범위(scope 네가지 상태): page < request < session < application 
	사용객체
	pageContext : 페이지가 이동되면 정보 삭제됨(사라짐, 더이상 사용못함)
	request : 응답(response) 하면 정보 삭제됨(사라짐, 더이상 사용못함)
	session : 웹브라우저 종료되면 정보 삭제됨
	application : 해당 프로그램이 종료되면 정보 삭제됨 
	-------------------------------------
	pageContext : 다른 모든 내장객체에 대한 프로그램적인 접근방법을 제공
		http요청을 처리하는 제어권을 다른 페이지로 넘길 때 사용
		getRequest(), getResponse(), getSession(), getServletContext()
		getPage(), getOut(), getServletConfig()...
		
	request : 요청정보
		사용자가 입력한 정보를 읽을 때 사용(파라미터 값 읽기)
		request.getParameter()
		request.getParameterValues()
		request.getRequestDispatcher("이동위치").forward(request, response)

	response : 클라이언쪽으로 응답할 정보
		response.sendRedirect("이동위치")
	
	session : 서버와 클라이언트 사이에 접속을 유지 시켜주는 것
		(데이타, 정보를 유지시켜줌)
		getId() - 세션 ID 값 가져오기
		invalidate() - 초기화(session scope 저장 데이타 일괄 삭제 처리)
		isNew() - 새로 생성된 세션여부 확인
		setMaxInactiveInterval(int 초) - 세션 유지시간 설정
		getMaxInactiveInterval() - 세션 유지시간 설정값 확인
	---------------------------------------------------
	
	scope에 데이타 저장하고 사용(속성사용)
	<속성 설정 및 가져오기>
	속성값 설정
	pageContext.setAttribute("이름", "데이타");
	request.setAttribute("이름", "데이타");
	session.setAttribute("이름", "데이타");
	application.setAttribute("이름", "데이타");
		
	속성값 확인(사용)
	pageContext.getAttribute("이름");
	request.getAttribute("이름");
	session.getAttribute("이름");
	application.getAttribute("이름");
--%>















