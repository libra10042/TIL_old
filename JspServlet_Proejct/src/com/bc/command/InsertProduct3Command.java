package com.bc.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.dao.ShopDAO;

public class InsertProduct3Command implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String option = request.getParameter("option");
		String p_name = request.getParameter("p_name");
		String p_price = request.getParameter("p_price");
		String p_thumbnail = request.getParameter("p_thumbnail");
		String p_image = request.getParameter("p_image");
		String userid = request.getParameter("userid");
		String s_idx = request.getParameter("s_idx");
		
		System.out.println("option : " + option + ", p_name : " + p_name + ", p_price : " + p_price
				+ ", p_thumbnail : " + p_thumbnail + ", p_image" + p_image + ", userid : " + userid +
				", s_idx : " + s_idx);
		
		Map<String, String> map = new HashMap<>();
		map.put("option", option);
		map.put("p_name", p_name);
		map.put("p_price", p_price);
		map.put("p_thumbnail", p_thumbnail);
		map.put("p_image", p_image);
		map.put("userid", userid);
		map.put("s_idx", s_idx);
		
		int result = ShopDAO.insertProduct(map);
		System.out.println("결과값 : " + result);
		
		return "39.Seller_productRegist.jsp";
	}

}
