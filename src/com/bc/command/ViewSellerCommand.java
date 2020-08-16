package com.bc.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.dao.ShopDAO;
import com.bc.vo.S_sellerRegistVO;

public class ViewSellerCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		System.out.println("현재 접속중인 아이디 : " + userid);
		
		//상호법인명 호출
		String sr_idx = ShopDAO.viewShop(userid);
		System.out.println("상호법인명 : " + sr_idx);
		
		String s_idx = ShopDAO.viewShop2(userid);
		System.out.println("상점이름 : " + s_idx);
		
		S_sellerRegistVO svo = ShopDAO.viewSeller(sr_idx);
		System.out.println("법인회사정보 : " + svo);
		request.setAttribute("svo", svo);
		request.setAttribute("s_idx", s_idx);
		
		
		return "31.Seller_register.jsp";
	}

}
