package com.bc.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.dao.MemberDAO;
import com.bc.vo.MemberVO;


public class RegisterCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("id");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		// phone0 phone1 phone2 하나로 합쳐야
		String phone0 = request.getParameter("phone0");
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		
		String phone = phone0.concat("-").concat(phone1).concat("-").concat(phone2);
		
		// email0 email1 하나로 합쳐야
		String email0 = request.getParameter("email0");
		String email1 = request.getParameter("email1");
		String email = email0.concat("@").concat(email1);
				
		String addr0 = request.getParameter("addr0");
		String addr1 = request.getParameter("addr1");
		
		String addr = addr0.concat("-").concat(addr1);
		
		
		MemberVO member = new MemberVO();
		
		member.setUserid(userid);
		member.setName(name);
		member.setPassword(password);
		member.setEmail(email);
		member.setPhone(phone);
		member.setAddr(addr);
		
		
		System.out.println("command :" + member.toString());
	
		int result = MemberDAO.register(member);
		
		if(result==0) {
			System.out.println("if문안에 들어왔음");
			response.setContentType("text/html; charset=UTF-8");

            PrintWriter out = response.getWriter();

            out.println("<script>alert('회원가입이 완료되지 않았습니다.'); history.go(-1); </script>");

            out.flush();
		}
	
		return "01.main.jsp";
		
	}
}
