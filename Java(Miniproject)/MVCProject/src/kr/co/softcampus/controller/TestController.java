package kr.co.softcampus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.softcampus.service.TestService;

@Controller
public class TestController {
	
	@Autowired
	private TestService testService;
	
	
	@GetMapping("/test1")
	public String test1(Model model){
		String str = testService.testMethod();
		
		model.addAttribute("str", str);
		
		return "test1";
	}
	
	
	
	
}
