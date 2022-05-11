package com.bc.command;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.dao.ProductDAO;
import com.bc.vo.O_OrderVO;
import com.bc.vo.O_arriveVO;

public class CardChkCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cardNum1 = request.getParameter("cardNum1");
		String cardNum2 = request.getParameter("cardNum2");
		String cardNum3 = request.getParameter("cardNum3");
		String cardNum4 = request.getParameter("cardNum4");
		String cardNum = cardNum1+"-"+cardNum2+"-"+cardNum3+"-"+cardNum4;
		String cardPw = request.getParameter("cardPw");
		
		Map<String, String> map = new HashMap<>();
		map.put("cardNum", cardNum);
		map.put("cardPw", cardPw);
		
		int result = ProductDAO.cardChk(map);
		
		System.out.println("비밀번호 일치 여부 결과값 : " + result);
		if(result == 0) {
			System.out.println("if문안에 들어왔음");
			response.setContentType("text/html; charset=UTF-8");

            PrintWriter out = response.getWriter();

            out.println("<script>alert('카드번호와 비밀번호가 일치하지 않습니다.'); history.go(-1); </script>");

            out.flush();
            return "25.Shop_cart3.jsp";
		}
		
	
		String userid = request.getParameter("userid");
		String insertName = request.getParameter("insertName");
		String a_address1 = request.getParameter("addr1");
		String a_address2 = request.getParameter("addr2");
		
		String a_address = a_address1 + " " + a_address2;
		
		String a_email1 = request.getParameter("email1");
		String a_email2 = request.getParameter("email2");
		
		String a_email = a_email1 + "@" + a_email2;
		
		String a_phone1 = request.getParameter("phone1");
		String a_phone2 = request.getParameter("phone2");
		String a_phone3 = request.getParameter("phone3");
		
		String a_phone = a_phone1 + "-" + a_phone2 + "-" + a_phone3;
		
		String a_message = request.getParameter("message");
		
		Map<String, String> map2 = new HashMap<>();
		map2.put("userid", userid);
		map2.put("a_address", a_address);
		map2.put("a_email", a_email);
		map2.put("a_phone", a_phone);
		map2.put("a_message", a_message);
		map2.put("insertName", insertName);
		
		System.out.println("값 확인 : " + map);
		
		int result2 = ProductDAO.insertArrive(map2);
		
		System.out.println("insert된 값 확인 : " + result2);
		
		//----------------------------------------------------------
		
	    String p_idx = request.getParameter("p_idx");
	    String o_product = request.getParameter("o_product");
	    String p_price = request.getParameter("p_price");
	    String s_idx = request.getParameter("s_idx");
	    String c_reserve = request.getParameter("c_reserve");
	    
	    Map<String, String> map3 = new HashMap<>();
		map3.put("userid", userid);
		map3.put("p_idx", p_idx);
		map3.put("o_product", o_product);
		map3.put("o_place", a_address);
		map3.put("o_order", a_message);
		map3.put("p_price", p_price);
		map3.put("s_idx", s_idx);
		map3.put("c_reserve", c_reserve);
		
		int result3 = ProductDAO.insertOrder(map3);
		
		System.out.println("o_order 유효검사 : " + result3);
		/*
		O_OrderVO ovo = ProductDAO.viewOrder(userid);
		System.out.println("ovo : " + ovo);
		request.setAttribute("ovo", ovo);
		
		O_arriveVO ovo2 = ProductDAO.viewOrder2(userid);
		System.out.println("ovo2 : " + ovo);
		request.setAttribute("ovo2", ovo2);
		*/
		request.setAttribute("p_price", p_price);
		request.setAttribute("c_reserve", c_reserve);
		request.setAttribute("insertName", insertName);
		request.setAttribute("a_address", a_address);
		request.setAttribute("a_phone", a_phone);
		request.setAttribute("a_message", a_message);
		return "25.Shop_cart3.jsp";
	}

}
