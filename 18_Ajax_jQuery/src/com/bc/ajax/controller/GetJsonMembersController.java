package com.bc.ajax.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/getJsonMembers")
public class GetJsonMembersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//db 데이터 조회
		List<MembersVO> list = MembersDAO.getList(); 
		
		/* {"list" : [{}, {}, {} ..., {}]}
		 {"list" : [
		 	{
		 		"idx" : "idx값",
		 		"name" : "name값",
		 		"age" : "age값",
		 		"addr" : "addr"값",
		 		"regdate" : "regdate값"
		 	}, {}, {}, ..., {}
		 
		 */
		
		//json 형태 문자열로 바꾸기
		String result = "{\"list\" : [";
		for(MembersVO vo : list) {
			result += "{";
			result +="\"idx\" : \"" + vo.getIdx() + "\",";
			result +="\"idx\" : \"" + vo.getName() + "\",";
			result += "\"age\" : \"" + vo.getAge() + "\",";
			result += "\"addr\" :\"" + vo.getAddr() + "\",";
			result += "\"regdate\" : \"" + vo.getRegdate() + "\",";			
			result += "},";
		}
		result = result.substring(0, result.length()-1);
		
		result += "]}";
		
		System.out.println("result : " + result);
		
		
		//json 문자열 출력
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
