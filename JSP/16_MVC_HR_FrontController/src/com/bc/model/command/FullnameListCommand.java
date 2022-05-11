package com.bc.model.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.DAO;
import com.bc.model.vo.EmployeeVO;

public class FullnameListCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 사용할 파라미터 값 추출
		String fullname = request.getParameter("fullname");
		
		//2. DAO.getFullnameList(fullname) 사용 데이터 조회
		List<EmployeeVO> list = DAO.getFullnameList(fullname);
		System.out.println("> list : " + list);
		
		//3. 조회된 데이터 request scope에 "list" 이름으로 저장
		request.setAttribute("list", list);
		
		return "fullnameList.jsp";
	}

}






