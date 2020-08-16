package com.bc.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.dao.DAO;
import com.bc.vo.P_boardVO;

public class ViewCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		System.out.println("userid : " + userid);
		
		List<P_boardVO> view = DAO.getView(userid);
		
		request.setAttribute("view", view);
		
		return "25.Shop_cart2.jsp";
	}

}
