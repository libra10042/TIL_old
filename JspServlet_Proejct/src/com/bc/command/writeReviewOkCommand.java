package com.bc.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.dao.ProductDAO;
import com.bc.vo.P_boardVO;
import com.bc.vo.P_inquiryVO;
import com.bc.vo.P_optionVO;
import com.bc.vo.P_reviewVO;

public class writeReviewOkCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid = request.getParameter("userid");
		System.out.println("writeqnaOKcommand 아이디 : " + userid);
		
		String p_idx = request.getParameter("p_idx");
		String r_size = request.getParameter("r_size");
		String r_satisfaction = request.getParameter("r_satisfaction");
		String r_colorsimiliarity = request.getParameter("r_colorsimiliarity");
		String r_content = request.getParameter("r_content");
		
		System.out.println("리뷰내용 : " + r_content);
		
		Map<String, String> map = new HashMap<>();
		map.put("userid", userid);
		map.put("p_idx", p_idx);
		map.put("r_size", r_size);
		map.put("r_satisfaction", r_satisfaction);
		map.put("r_colorsimiliarity", r_colorsimiliarity);
		map.put("r_content", r_content);
		
		ProductDAO.writeReview(map);
		
		P_boardVO pvo = ProductDAO.selectOne(p_idx);
		request.setAttribute("pvo", pvo);
		
		List<P_optionVO> oList = ProductDAO.showOption(p_idx);
		request.setAttribute("oList", oList);
		
		List<P_reviewVO> rList = ProductDAO.showReview(p_idx);
		request.setAttribute("rList", rList);
		
		List<P_inquiryVO> iList = ProductDAO.showInquiry(p_idx);
		request.setAttribute("iList", iList);
		
		request.setAttribute("p_idx", p_idx);
		
		return "10.productlist.jsp";
	}

}
