package kr.co.softcampus.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.softcampus.beans.DataBean1;
import kr.co.softcampus.beans.DataBean2;
import kr.co.softcampus.beans.DataBean3;
import kr.co.softcampus.beans.DataBean4;

@Controller
public class TestController {

	
	@Autowired
	DataBean1 requestBean1;
	
	@Resource(name = "requestBean2")
	DataBean2 requestBean2;
	
	@Autowired
	DataBean3 requestBean3; 
	
	@Resource(name = "requestBean4")
	DataBean4 requestBean4; 
	
	
	
	@GetMapping("/test1")
	public String test1() {
		
		requestBean1.setData1("문자열1");
		requestBean1.setData2("문자열2");
		

		requestBean2.setData3("문자열3");
		requestBean2.setData4("문자열4");
		
		requestBean3.setData5("문자열5");
		requestBean3.setData6("문자열6");
		
		requestBean4.setData7("문자열7");
		requestBean4.setData8("문자열8");
		
		
		return "forward:/result1";
	}
	
	
	@GetMapping("/result1")
	public String result1(Model model) {
	
		System.out.println("requestBean1.data1 : " + requestBean1.getData1());
		System.out.println("requestBean1.data2 : " + requestBean1.getData2());
		
		System.out.println("requestBean2.data3 : " +requestBean2.getData3());
		System.out.println("requestBean2.data4: " +requestBean2.getData4());

		System.out.println("requestBean3.data5 : " +requestBean3.getData5());
		System.out.println("requestBean3.data6: " +requestBean3.getData6());

		System.out.println("requestBean4.data7 : " +requestBean4.getData7());
		System.out.println("requestBean4.data8: " +requestBean4.getData8());

		
		
		
		model.addAttribute("requestBean1", requestBean1);
		model.addAttribute("requestBean2", requestBean2);
		
		model.addAttribute("requestBean3", requestBean3);
		model.addAttribute("requestBean4", requestBean4);
		
		return "result1"; 
	}
	
	
}
