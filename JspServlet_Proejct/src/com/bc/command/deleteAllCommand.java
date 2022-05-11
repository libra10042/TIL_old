package com.bc.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.dao.ProductDAO;

public class deleteAllCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		System.out.println("deleteAllCommand 아이디 : " + userid);
		
		int result = ProductDAO.deleteAll(userid);
		System.out.println("삭제결과 : " + result);
		return "01.main.jsp";
	}

}
