package com.bc.command;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.dao.ShopDAO;

public class SellerRegisterCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sr_idx = request.getParameter("sr_idx");
		String sr_rname = request.getParameter("sr_rname");
		String sr_number = request.getParameter("sr_number");
		String sr_address = request.getParameter("sr_address");
		String sr_name = request.getParameter("sr_name");
		String sr_email = request.getParameter("sr_email");
		String sr_phone = request.getParameter("sr_phone");
		String sr_check = request.getParameter("sr_check");
		
		Map<String, String> map = new HashMap<>();
		map.put("sr_idx", sr_idx);
		map.put("sr_rname", sr_rname);
		map.put("sr_number", sr_number);
		map.put("sr_address", sr_address);
		map.put("sr_name", sr_name);
		map.put("sr_email", sr_email);
		map.put("sr_phone", sr_phone);
		map.put("sr_check", sr_check);
		
		System.out.println("입점신청서 확인 map : " + map);
		
		int result = ShopDAO.insertShop(map);
		System.out.println("결과값 확인 result : " + result);
		if(result==0) {
			response.setContentType("text/html; charset=UTF-8");

            PrintWriter out = response.getWriter();

            out.println("<script>alert('등록처리를 실패했습니다. 다시 작성해주세요.'); history.go(-1); </script>");

            out.flush();
		}
		String userid = request.getParameter("userid");
		System.out.println("아이디 : " + userid);
		
		System.out.println("상호법인명 : " + sr_idx);
		request.setAttribute("sr_idx", sr_idx);
		
		return "35.Seller_register3.jsp";
	}

}
