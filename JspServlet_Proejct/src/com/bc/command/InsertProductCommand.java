package com.bc.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.dao.ShopDAO;
import com.bc.vo.P_boardVO;

public class InsertProductCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid = request.getParameter("userid");
		System.out.println("상품등록, 현황 페이지 접속 아이디 : " + userid);
		
		String s_idx = ShopDAO.viewShop2(userid);
		System.out.println("현재 접속중인 아이디의 상점 이름 : " + s_idx);
		
		List<P_boardVO> pvo = ShopDAO.searchProduct(s_idx);
		System.out.println("상품목록 : " + pvo);
		
		request.setAttribute("pvo", pvo);
		
		return "32.Seller_productInfo.jsp";
	}

}
