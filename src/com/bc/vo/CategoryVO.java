package com.bc.vo;

public class CategoryVO {
	private String c_num, c_name, c_sub;

	public String getC_num() {
		return c_num;
	}

	public void setC_num(String c_num) {
		this.c_num = c_num;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getC_sub() {
		return c_sub;
	}

	public void setC_sub(String c_sub) {
		this.c_sub = c_sub;
	}

	@Override
	public String toString() {
		return "CategoryVO [c_num=" + c_num + ", c_name=" + c_name + ", c_sub=" + c_sub + "]";
	}
	
	
}
