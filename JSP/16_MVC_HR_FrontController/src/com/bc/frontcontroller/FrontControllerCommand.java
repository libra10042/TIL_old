package com.bc.frontcontroller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.DAO;
import com.bc.model.command.Command;
import com.bc.model.command.DeptCommand;
import com.bc.model.command.DeptListCommand;
import com.bc.model.command.FullnameCommand;
import com.bc.model.command.FullnameListCommand;
import com.bc.model.command.ListCommand;
import com.bc.model.command.SearchCommand;
import com.bc.model.vo.EmployeeVO;

@WebServlet("/controller")
public class FrontControllerCommand extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(">> FrontControllerCommand.doGet() 실행~~");
		//요청에 대한 처리
		String type = request.getParameter("type");
		System.out.println("> type : " + type);
		Command command = null;
		if ("all".equals(type)) {
			command = new ListCommand();
		} else if ("dept".equals(type)) {
			command = new DeptCommand();
		} else if ("deptList".equals(type)) {
			command = new DeptListCommand();
		} else if ("fullname".equals(type)) {
			command = new FullnameCommand();
		} else if ("fullnameList".equals(type)) {
			command = new FullnameListCommand();
		} else if ("search".equals(type)) {
			command = new SearchCommand();
		}
		String path = command.exec(request, response);
		request.getRequestDispatcher(path).forward(request, response);
		System.out.println(">> FrontController.doGet() 끝~~");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}
}










