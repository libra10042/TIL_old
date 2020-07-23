package com.bc.frontcontroller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.DAO;
import com.bc.model.vo.EmployeeVO;

//@WebServlet("/controller")
public class FrontController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(">> FrontController.doGet() 실행~~");
		//요청에 대한 처리
		String type = request.getParameter("type");
		System.out.println("> type : " + type);
		if ("all".equals(type)) {
			//1. DB연결하고 데이터 가져오기
			List<EmployeeVO> list = DAO.getList();
			
			//2. 응답페이지(list.jsp)에 전달(request 객체에 속성값으로 전달)
			request.setAttribute("list", list);
			
			//3. 페이지 전환 - 응답할 페이지(list.jsp)로 포워딩(전환)
			request.getRequestDispatcher("list.jsp").forward(request, response);
		} else if ("dept".equals(type)) {
			request.getRequestDispatcher("dept.jsp").forward(request, response);
		} else if ("deptList".equals(type)) {
			//전달받은 부서코드로 DB데이터 조회 후 deptList.jsp 응답처리(위임처리)
			//1. 전달받은 파라미터값(부서코드: deptno) 추출
			String deptno = request.getParameter("deptno");
			System.out.println("> deptno : " + deptno);
			
			//2. DB에서 해당부서(deptno)에 있는 직원 조회(DAO 사용)
			List<EmployeeVO> list = DAO.getDept(deptno);
			
			//3. 조회된 데이터를 응답페이지(deptList.jsp)에서 사용토록 속성에 저장
			request.setAttribute("list", list);
			
			//4. 응답페이지(deptList.jsp)로 응답 위임 처리
			request.getRequestDispatcher("deptList.jsp").forward(request, response);
		} else if ("fullname".equals(type)) {
			request.getRequestDispatcher("fullname.jsp").forward(request, response);
		} else if ("fullnameList".equals(type)) {
			System.out.println("> fullnameList 처리시작~");
			//1. 사용할 파라미터 값 추출
			String fullname = request.getParameter("fullname");
			
			//2. DAO.getFullnameList(fullname) 사용 데이터 조회
			List<EmployeeVO> list = DAO.getFullnameList(fullname);
			System.out.println("> list : " + list);
			
			//3. 조회된 데이터 request scope에 "list" 이름으로 저장
			request.setAttribute("list", list);
			
			//4. fullnameList.jsp 페이지로 위임처리
			request.getRequestDispatcher("fullnameList.jsp").forward(request, response);
		} else if ("search".equals(type)) {
			String idx = request.getParameter("idx");
			String keyword = request.getParameter("keyword");
			
			// 단순 페이지 전환인지 DB데이터 조회처리를 해야 하는지 결정
			if (keyword == null || keyword.equals("")) {
				//search.jsp 페이지로 응답처리(페이지 이동)
				request.getRequestDispatcher("search.jsp").forward(request, response);
			} else { // DB데이터 조회처리 후 결과페이지 이동
				List<EmployeeVO> list = DAO.getSearch(idx, keyword);
				System.out.println(">> 동적검색결과 list : " + list);
				
				//동적검색 형태 확인
				String title = "";
				switch (idx) {
					case "0" : title = "사번"; break;
					case "1" : title = "이름"; break;
					case "2" : title = "직종"; break;
					case "3" : title = "부서"; break;
				}
				
				//동적검색 결과 응답페이지로 전달
				request.setAttribute("list", list);
				request.setAttribute("title", title);
				
				//페이지 전환(searchList.jsp 페이지에 위임)
				request.getRequestDispatcher("searchList.jsp")
						.forward(request, response);
			}
		}
		System.out.println(">> FrontController.doGet() 끝~~");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}
}










