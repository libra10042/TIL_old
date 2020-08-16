package com.bc.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class writeQnaCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid = request.getParameter("userid");
		System.out.println("writeqnacommand 아이디 : " + userid);
		
		String p_idx = request.getParameter("p_idx");
		
		if(userid.equals("null")) {
			response.setContentType("text/html; charset=UTF-8");

            PrintWriter out = response.getWriter();

            out.println("<script>alert('현재 비로그인 상태이므로 로그인 후 다시 이용 바랍니다.'); history.go(-1); </script>");

            out.flush();
		}
		
		
		request.setAttribute("p_idx", p_idx);
		return "11.productlist_writeQna.jsp";
	}

}
