package kr.co.softcampus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	
	@GetMapping("/test1")
	public String test1(Model model) {
		int [] array1 = {10, 20, 30};
		
		System.out.printf("array1 : %d\n", array1[0]);
		model.addAttribute("array1", array1[10]);
		
		return "test1";
	}
	
	
	
	
	@ExceptionHandler(ArrayIndexOutOfBoundsException.class)
	public String exception1() {
		return "error1";
	}
	
	
	
	
}
