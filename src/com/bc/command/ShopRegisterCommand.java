package com.bc.command;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.dao.ShopDAO;

public class ShopRegisterCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s_idx = request.getParameter("s_idx");
		String sr_idx = request.getParameter("sr_idx");
		String userid= request.getParameter("userid");
		
		Map<String, String> map = new HashMap<>();
		map.put("s_idx", s_idx);
		map.put("sr_idx", sr_idx);
		map.put("userid", userid);
		
		System.out.println("상점에 들어갈 shop 정보 map : " + map);
		
		int result = ShopDAO.shopRegister(map);
		
		if(result==0) {
			response.setContentType("text/html; charset=UTF-8");

            PrintWriter out = response.getWriter();

            out.println("<script>alert('등록처리를 실패했습니다. 다시 작성해주세요.'); history.go(-1); </script>");

            out.flush();
		}
		
		
		return "31.Seller_register.jsp";
	}

}
