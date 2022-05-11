package com.bc.command;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.dao.ProductDAO;

public class writeReviewCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		System.out.println("writereviewcommand 아이디 : " + userid);
		
		String p_idx = request.getParameter("p_idx");
		System.out.println("writereviewcommand p_idx : " + p_idx);
		
		if(userid.equals("null")) {
			response.setContentType("text/html; charset=UTF-8");

            PrintWriter out = response.getWriter();

            out.println("<script>alert('현재 비로그인 상태입니다.'); history.go(-1); </script>");

            out.flush();
		}
		Map<String, String> map = new HashMap<>();
		map.put("userid", userid);
		map.put("p_idx", p_idx);
		int result = ProductDAO.chkBuy(map);
		System.out.println("구매이력 result : " + result);
		
		if(result == 0) {
			response.setContentType("text/html; charset=UTF-8");

            PrintWriter out = response.getWriter();

            out.println("<script>alert('현재 상품을 구매한 이력이 없습니다.'); history.go(-1); </script>");

            out.flush();
		}
		
		request.setAttribute("p_idx", p_idx);
		return "12.productlist_writeReview.jsp";
	}

}
