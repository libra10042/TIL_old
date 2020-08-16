package com.bc.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.dao.ProductDAO;
import com.bc.vo.O_cartlistVO;

public class goOrderlistCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		
		System.out.println("장바구니->주문페이지 아이디 : " + userid);
		
		List<O_cartlistVO> cList = ProductDAO.showCartlist(userid);
		request.setAttribute("cList", cList);
		
		String name = ProductDAO.viewName(userid);
		System.out.println("사용자 이름 : " + name);
		request.setAttribute("name", name);
		
		System.out.println("카트리스트 목록 : " + cList);
		
		return "25.Shop_cart2-1.jsp";
	}

}
