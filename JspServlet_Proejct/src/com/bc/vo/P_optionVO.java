package com.bc.vo;

public class P_optionVO {
	private String p_idx, o_name, o_price, o_size;

	public String getP_idx() {
		return p_idx;
	}

	public void setP_idx(String p_idx) {
		this.p_idx = p_idx;
	}

	public String getO_name() {
		return o_name;
	}

	public void setO_name(String o_name) {
		this.o_name = o_name;
	}

	public String getO_price() {
		return o_price;
	}

	public void setO_price(String o_price) {
		this.o_price = o_price;
	}

	public String getO_size() {
		return o_size;
	}

	public void setO_size(String o_size) {
		this.o_size = o_size;
	}

	@Override
	public String toString() {
		return "P_optionVO [p_idx=" + p_idx + ", o_name=" + o_name + ", o_price=" + o_price + ", o_size=" + o_size
				+ "]";
	}
	
	
}
