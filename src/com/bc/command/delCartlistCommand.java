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

public class delCartlistCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String p_idx = request.getParameter("p_idx");
		String userid= request.getParameter("userid");
		
		System.out.println("개별삭제 p_idx : " + p_idx + ", userid : " + userid);
		
		Map<String, String> map = new HashMap<>();
		map.put("p_idx", p_idx);
		map.put("userid", userid);
		
		ProductDAO.delCartlist(map);
		
		
		List<O_cartlistVO> cList = ProductDAO.showCartlist(userid);
		
		System.out.println("개별삭제 카트리스트 : " + cList);
		request.setAttribute("cList", cList);
		
		return "25.Shop_cart1-2.jsp";
	}

}
