package kr.co.softcampus.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecondController {

	@GetMapping("/test2")
	public String test2() {
		
		ArrayList<String> list = null; 
		list.add("문자열");
		
		
		return "test2";
	}
	
//	@ExceptionHandler(java.lang.NullPointerException.class)
//	public String exception2() {
//		return "error2";
//	}
	
}
