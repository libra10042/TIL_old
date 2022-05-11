package com.bc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.DAO;
import com.bc.model.vo.EmployeeVO;

@WebServlet("/list")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("> doGet() 시작");
		
		System.out.println(">>> doGet 업무처리 process ~~~~");
		process(request, response);
		
		System.out.println("> doGet() 종료");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("> doPost() 시작");
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
		System.out.println("> doPost() 종료");
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println(">>> process() 시작");
		System.out.println(">>> DB에서 데이터 가져와서 list.jsp로 전달");
		//1. DB연결하고 데이터 가져오기
		List<EmployeeVO> list = DAO.getList();
		
		//2. 응답페이지(list.jsp)에 전달(request 객체에 속성값으로 전달)
		request.setAttribute("list", list);
		
		//3. 페이지 전환 - 응답할 페이지(list.jsp)로 포워딩(전환)
		request.getRequestDispatcher("list.jsp").forward(request, response);
		
		System.out.println(">>> process() 종료");
	}
}










