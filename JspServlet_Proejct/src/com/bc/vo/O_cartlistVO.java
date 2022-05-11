package com.bc.vo;

public class O_cartlistVO {
	private String userid, p_idx, p_thumbnail, p_name, o_option, c_delevery, c_quantity, p_price, c_reserve, s_idx;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getP_idx() {
		return p_idx;
	}

	public void setP_idx(String p_idx) {
		this.p_idx = p_idx;
	}

	public String getP_thumbnail() {
		return p_thumbnail;
	}

	public void setP_thumbnail(String p_thumbnail) {
		this.p_thumbnail = p_thumbnail;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getO_option() {
		return o_option;
	}

	public void setO_option(String o_option) {
		this.o_option = o_option;
	}

	public String getC_delevery() {
		return c_delevery;
	}

	public void setC_delevery(String c_delevery) {
		this.c_delevery = c_delevery;
	}

	public String getC_quantity() {
		return c_quantity;
	}

	public void setC_quantity(String c_quantity) {
		this.c_quantity = c_quantity;
	}

	public String getP_price() {
		return p_price;
	}

	public void setP_price(String p_price) {
		this.p_price = p_price;
	}

	public String getC_reserve() {
		return c_reserve;
	}

	public void setC_reserve(String c_reserve) {
		this.c_reserve = c_reserve;
	}
	
	public String getS_idx() {
		return s_idx;
	}

	public void setS_idx(String s_idx) {
		this.s_idx = s_idx;
	}

	@Override
	public String toString() {
		return "O_cartlistVO [userid=" + userid + ", p_idx=" + p_idx + ", p_thumbnail=" + p_thumbnail + ", p_name="
				+ p_name + ", o_option=" + o_option + ", c_delevery=" + c_delevery + ", c_quantity=" + c_quantity
				+ ", p_price=" + p_price + ", c_reserve=" + c_reserve + ", s_idx=" + s_idx + "]";
	}

}
