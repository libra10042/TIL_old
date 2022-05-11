package kr.co.softcampus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import kr.co.softcampus.beans.UserDataBean;

@Controller
public class TestController {

	@GetMapping("/test1")
	public String test1(@ModelAttribute UserDataBean bean) {

		bean.setUser_name("홍길동");
		bean.setUser_id("hong");
		bean.setUser_pw("1234");
		bean.setUser_postcode("444");
		bean.setUser_address1("경기도");
		bean.setUser_address2("의왕시");
		
		
		return "test1";
	}
	
	
	@GetMapping("/test2")
	public String test2(UserDataBean bean) {
		bean.setUser_name("홍길동");
		bean.setUser_id("hong");
		bean.setUser_pw("1234");
		bean.setUser_postcode("444");
		bean.setUser_address1("경기도");
		bean.setUser_address2("의왕시");
		
		
		return "test2";
	}
	
	@GetMapping("/test3")
	public String test3(@ModelAttribute("testBean") UserDataBean bean) {
		bean.setUser_name("홍길동");
		bean.setUser_id("hong");
		bean.setUser_pw("1234");
		bean.setUser_postcode("444");
		bean.setUser_address1("경기도");
		bean.setUser_address2("의왕시");
		
		
		return "test3";
	}
	
	@GetMapping("/test4")
	public String test4(Model model) {
		UserDataBean bean = new UserDataBean();
		bean.setUser_name("홍길동");
		bean.setUser_id("hong");
		bean.setUser_pw("1234");
		bean.setUser_postcode("444");
		bean.setUser_address1("경기도");
		bean.setUser_address2("의왕시");
		
		model.addAttribute("test_user2", bean);
		return "test4";
		
	}
	
}
