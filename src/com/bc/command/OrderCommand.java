package com.bc.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.dao.DAO;
import com.bc.vo.O_OrderVO;

public class OrderCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		//1. DB연결하고 데이터 가져오기
		List<O_OrderVO> order = DAO.getOrder(userid);
		
		//2. 응답페이지(Shop_order.jsp)에 전달(request 객체에 속성값으로 전달)
		request.setAttribute("order", order);
		
		// 응답은 컨트롤러에서 해주는 것이 좋다.
		// 페이징 처리 정보만 리턴
		return "21.Shop_order.jsp";
	}

	
}
