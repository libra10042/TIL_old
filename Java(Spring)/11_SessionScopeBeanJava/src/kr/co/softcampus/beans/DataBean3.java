package kr.co.softcampus.beans;

import org.springframework.web.context.annotation.SessionScope;

@SessionScope
public class DataBean3 {

	private String data5; 
	private String data6;
	public String getData5() {
		return data5;
	}
	public void setData5(String data5) {
		this.data5 = data5;
	}
	public String getData6() {
		return data6;
	}
	public void setData6(String data6) {
		this.data6 = data6;
	} 
	
	
	
	
}
