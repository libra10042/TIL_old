package kr.co.softcampus.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.softcampus.beans.DataBean;
import kr.co.softcampus.beans.DataBean2;

@Controller
public class TestController {

	@GetMapping("/test1")
	public String test1(@RequestParam Map<String, String> map, @RequestParam List<String> data3) {
		String data1 = map.get("data1");
		String data2 = map.get("data2");
		String data33 = map.get("data3");
		
		System.out.println(data1);
		System.out.println(data2);
		
		System.out.println(data33);
		
		
		for(String str : data3) {
			System.out.println(str);
		}
		
		
		return "result";
	}

	
	@GetMapping("/test2")
	public String test2(@ModelAttribute DataBean bean1, @ModelAttribute DataBean2 bean2) {
		System.out.printf("data1 : %d\n", bean1.getData1());
		System.out.printf("data2 : %d\n", bean1.getData2());
		
		
		for(int number1 : bean1.getData3()) {
			System.out.printf("data3 :%d\n", number1);
		}

		
		System.out.println(bean2.getData1());
		System.out.println(bean2.getData2());
		
		return "result";
		

	}
	
}
