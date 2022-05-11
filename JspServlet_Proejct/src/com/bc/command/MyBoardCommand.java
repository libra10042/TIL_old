package com.bc.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.dao.ProductDAO;
import com.bc.vo.P_inquiryVO;
import com.bc.vo.P_reviewVO;

public class MyBoardCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		
		List<P_reviewVO> rList = ProductDAO.showReview2(userid);
		request.setAttribute("rList", rList);
		
		List<P_inquiryVO> iList = ProductDAO.showInquiry2(userid);
		request.setAttribute("iList", iList);
		return "27.Shop_board.jsp";
	}

}
