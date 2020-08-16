package com.bc.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.dao.ProductDAO;
import com.bc.vo.O_OrderVO;

public class MyPointCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		
		List<O_OrderVO> ovo = ProductDAO.viewPoint(userid);
		
		System.out.println("포인트 목록 보기 : " +ovo);
		request.setAttribute("ovo", ovo);
		return "24.Shop_point.jsp";
	}

}
