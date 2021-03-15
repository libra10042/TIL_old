package kr.co.softcampus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import kr.co.softcampus.service.UserService;

@RestController
public class RestApiController {

	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/user/checkUserIdExist/{user_id}")
	public String checkUserIdExists(@PathVariable String user_id) {
		
		boolean chk = userService.checkUserIdExists(user_id);
		
		
		return chk + "";
	}
	
}
