package com.spring.biz.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.biz.user.UserService;
import com.spring.biz.user.UserVO;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	public UserController() {
		System.out.println("--->> UserController() 객체생성");
	}
	
	// 요청방식 POST에 대한 처리
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(UserVO vo) {
		System.out.println(">>> 로그인 처리 - login()");
		
		//일부러 예외 발생
		if (vo.getId() == null || vo.getId().equals("")) {
			throw new IllegalArgumentException("아이디는 반드시 입력해야 합니다");
		}		
		
		UserVO user = userService.getUser(vo);
		if (user != null) {
			return "getBoardList.do";
		} else {
			return "login.jsp";
		}
	}
	
	/* @ModelAttribute : 모델의 속성값으로 저장(속성명 별도지정)
	 *   별도 명칭 부여 안하면 <데이터타입>의 첫글자 소문자로 작성된 명칭사용
	 * @ModelAttribute UserVO --> 속성명 userVO 형태
	 * @ModelAttribute("user") UserVO ---> 속성명 user 사용
	 * **********************************/
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String loginView(@ModelAttribute("user") UserVO vo) {
		System.out.println(">>> 로그인 처리 - loginView()");
		vo.setId("test");
		vo.setPassword("test");
		
		return "login.jsp";
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		//1. 세션 초기화(세션 객체 종료)
		session.invalidate();
		
		return "login.jsp";
	}	
}
