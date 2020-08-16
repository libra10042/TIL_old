package com.bc.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.dao.ProductDAO;
import com.bc.vo.P_boardVO;
import com.bc.vo.P_inquiryVO;
import com.bc.vo.P_optionVO;
import com.bc.vo.P_reviewVO;

public class productlistCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid = request.getParameter("userid"); 
		System.out.println("productlistCommand 로그인 상태 : " + userid);
		
		
		String p_idx = request.getParameter("p_idx");
		System.out.println("p_idx : " + p_idx);
		P_boardVO pvo = ProductDAO.selectOne(p_idx);
		request.setAttribute("pvo", pvo);
		
		List<P_optionVO> oList = ProductDAO.showOption(p_idx);
		request.setAttribute("oList", oList);
		
		List<P_reviewVO> rList = ProductDAO.showReview(p_idx);
		request.setAttribute("rList", rList);
		
		List<P_inquiryVO> iList = ProductDAO.showInquiry(p_idx);
		request.setAttribute("iList", iList);
		
		return "10.productlist.jsp";
	}
}
