package kr.co.softcampus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {

	@RequestMapping(value = "/test1", method= RequestMethod.GET)
	public String test1_get() {
		return "test1";
	}
	
	@RequestMapping(value = "/test2", method= RequestMethod.POST)
	public String test2_post() {
		return "test2";
	}
	
	
	@RequestMapping(value = "/test3", method = RequestMethod.GET)
	public String test3_get() {
		return "test3_get";
	}

	@RequestMapping(value= "/test3", method= RequestMethod.POST)
	public String test3_post() {
		return "test3_post";
	}

	
	@GetMapping("/test4")
	public String test4() {
		return "test4";
	}
	
	
	
	@PostMapping("/test5")
	public String test5() {
		return "test5";
	}
	
	
	@PostMapping("/test6")
	public String test6_post() {
		return "test6_post";
	}
	
	@GetMapping("test6")
	public String test6_get() {
		return "test6_get";
	}
	
	
	@RequestMapping(value="/test7", method= {RequestMethod.GET, RequestMethod.POST})
	public String test7() {
		return "test7";
	}
	
	
	@GetMapping("/test8")
	public String test8_get() {
		return test8_post();
	}
	
	@PostMapping("test8")
	public String test8_post() {
		return test8_get();
	}
	
	
	
	
	
}
