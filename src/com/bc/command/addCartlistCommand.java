package com.bc.command;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.dao.ProductDAO;
public class addCartlistCommand implements Command {
	
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid = request.getParameter("userid");
		System.out.println("addCartlistCommand 아이디 : " + userid);
		System.out.println("userid==\"null\"? : " + userid.equals("null"));
		
		if(userid.equals("null")) {
			System.out.println("if문안에 들어왔음");
			response.setContentType("text/html; charset=UTF-8");

            PrintWriter out = response.getWriter();

            out.println("<script>alert('현재 비로그인 상태이므로 로그인 후 다시 이용 바랍니다.'); history.go(-1); </script>");

            out.flush();
		}
		
		String p_idx = request.getParameter("p_idx");
		String p_thumbnail = request.getParameter("p_thumbnail");
		String p_name = request.getParameter("p_name");
		String o_option = request.getParameter("option");
		String c_quantity = request.getParameter("quantity");
		String p_price = request.getParameter("p_price");
		String c_reserve = request.getParameter("p_reserve");
		String s_idx = request.getParameter("s_idx");
		
		int setPrice = Integer.parseInt(p_price);
		int setQuantity = Integer.parseInt(c_quantity);
		int setReserve = Integer.parseInt(c_reserve);
		
		setPrice = setPrice * setQuantity;
		setReserve = (int)(setPrice * 0.01);
		p_price = Integer.toString(setPrice);
		c_reserve = Integer.toString(setReserve);
		
		Map<String, String> map = new HashMap<>();
		map.put("p_price", p_price);
		map.put("userid", userid);
		map.put("p_thumbnail", p_thumbnail);
		map.put("p_name", p_name);
		map.put("o_option", o_option);
		map.put("c_quantity", c_quantity);
		map.put("p_price", p_price);
		map.put("c_reserve", c_reserve);
		map.put("p_idx", p_idx);
		map.put("s_idx", s_idx);
		
		System.out.println("p_idx : " + p_idx + ", userid : " + userid + ", p_thumbnail : " + p_thumbnail +
					", p_name : " + p_name + ", o_option : " + o_option + ", c_quantity : " + c_quantity + ", p_price : " +
					p_price + "c_reserve : " + c_reserve + ", s_idx : " + s_idx);
		
		int result = ProductDAO.isDuplicate(map);


		System.out.println(result);
		
		if(result == 0) {
			ProductDAO.insertCart(map);
			
			response.setContentType("text/html; charset=UTF-8");

            PrintWriter out = response.getWriter();

            out.println("<script>alert('장바구니에 추가되었습니다.'); history.go(-1); </script>");

            out.flush();
            
		} else {
			response.setContentType("text/html; charset=UTF-8");

            PrintWriter out = response.getWriter();

            out.println("<script>alert('해당 상품은 이미 장바구니에 담겨있습니다..'); history.go(-1); </script>");

            out.flush(); 

		}
	
		return "10.productlist.jsp";
	}

}


