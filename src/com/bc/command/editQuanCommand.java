package com.bc.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.dao.ProductDAO;
import com.bc.vo.O_cartlistVO;

public class editQuanCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String p_idx = request.getParameter("p_idx");
		String c_quantity = request.getParameter("quantity");
		String p_price = request.getParameter("price");
		String c_reserve = request.getParameter("reserve");
 
		System.out.println("수정페이지 userid : " + userid + ", p_idx : " + p_idx + ", 수량 : " + c_quantity);
		
		int setPrice = Integer.parseInt(p_price);
		int setQuantity = Integer.parseInt(c_quantity);
		int setReserve = Integer.parseInt(c_reserve);
		
		setPrice = setPrice * setQuantity;
		setReserve = (int)(setPrice * 0.01);
		p_price = Integer.toString(setPrice);
		c_reserve = Integer.toString(setReserve);
		
		Map<String, String> map = new HashMap<>();
		map.put("userid", userid);
		map.put("p_idx", p_idx);
		map.put("c_quantity", c_quantity);
		map.put("p_price", p_price);
		map.put("c_reserve", c_reserve);
		
		ProductDAO.editQuant(map);

		List<O_cartlistVO> cList = ProductDAO.showCartlist(userid);
		
		System.out.println("카트리스트 : " + cList);
		request.setAttribute("cList", cList);
		
		return "25.Shop_cart1-2.jsp";
	}

}
