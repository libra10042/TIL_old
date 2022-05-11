package com.bc.command;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.dao.ProductDAO;
import com.bc.vo.O_cartlistVO;

public class viewCartlistCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		System.out.println("cartlist 로그인 아이디 : " + userid);
		if(userid=="") {
			response.setContentType("text/html; charset=UTF-8");

            PrintWriter out = response.getWriter();

            out.println("<script>alert('현재 비로그인 상태이므로 로그인 후 다시 이용 바랍니다.'); history.go(-1); </script>");

            out.flush();
		}
		
		List<O_cartlistVO> cList = ProductDAO.showCartlist(userid);
		request.setAttribute("cList", cList);
		
		System.out.println("카트리스트 목록 : " + cList);
		
		return "25.Shop_cart1-2.jsp";
	}

}
