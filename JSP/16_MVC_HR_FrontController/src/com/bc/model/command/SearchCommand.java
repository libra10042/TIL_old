package com.bc.model.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.DAO;
import com.bc.model.vo.EmployeeVO;

public class SearchCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idx = request.getParameter("idx");
		String keyword = request.getParameter("keyword");
		
		// 단순 페이지 전환인지 DB데이터 조회처리를 해야 하는지 결정
		String path = null;
		if (keyword == null || keyword.equals("")) {
			path = "search.jsp";
		} else { // DB데이터 조회처리 후 결과페이지 이동
			List<EmployeeVO> list = DAO.getSearch(idx, keyword);
			System.out.println(">> 동적검색결과 list : " + list);
			
			//동적검색 형태 확인
			String title = "";
			switch (idx) {
				case "0" : title = "사번"; break;
				case "1" : title = "이름"; break;
				case "2" : title = "직종"; break;
				case "3" : title = "부서"; break;
			}
			
			//동적검색 결과 응답페이지로 전달
			request.setAttribute("list", list);
			request.setAttribute("title", title);
			
			//페이지 전환(searchList.jsp 페이지에 위임)
			path = "searchList.jsp";
		}
		return path;
	}

}
