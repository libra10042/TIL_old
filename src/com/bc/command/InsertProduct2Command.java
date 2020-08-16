package com.bc.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.dao.ShopDAO;
import com.bc.vo.CategoryVO;

public class InsertProduct2Command implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		System.out.println("userid : " + userid);
		System.out.println("들어왔다.");
		List<CategoryVO> cavo = ShopDAO.viewCategory();
		System.out.println("카테고리 모두 보기 : " + cavo);
		request.setAttribute("cavo", cavo);
		
		String s_idx = ShopDAO.viewShop2(userid);
		System.out.println("상점이름 : " + s_idx);
		request.setAttribute("s_idx", s_idx);
		
		return "37.Seller_productRegist.jsp";
	}

}
