package com.bc.vo;

public class P_boardVO {
	private String p_idx, c_num, p_name, p_price, p_content, p_reserve, p_tag,
					userid, p_date,	p_image, p_thumbnail, s_idx;

	public String getP_idx() {
		return p_idx;
	}

	public void setP_idx(String p_idx) {
		this.p_idx = p_idx;
	}

	public String getC_num() {
		return c_num;
	}

	public void setC_num(String c_num) {
		this.c_num = c_num;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getP_price() {
		return p_price;
	}

	public void setP_price(String p_price) {
		this.p_price = p_price;
	}

	public String getP_content() {
		return p_content;
	}

	public void setP_content(String p_content) {
		this.p_content = p_content;
	}

	public String getP_reserve() {
		return p_reserve;
	}

	public void setP_reserve(String p_reserve) {
		this.p_reserve = p_reserve;
	}

	public String getP_tag() {
		return p_tag;
	}

	public void setP_tag(String p_tag) {
		this.p_tag = p_tag;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getP_date() {
		return p_date;
	}

	public void setP_date(String p_date) {
		this.p_date = p_date;
	}

	public String getP_image() {
		return p_image;
	}

	public void setP_image(String p_image) {
		this.p_image = p_image;
	}

	public String getP_thumbnail() {
		return p_thumbnail;
	}

	public void setP_thumbnail(String p_thumbnail) {
		this.p_thumbnail = p_thumbnail;
	}
	
	public String getS_idx() {
		return s_idx;
	}

	public void setS_idx(String s_idx) {
		this.s_idx = s_idx;
	}

	@Override
	public String toString() {
		return "P_boardVO [p_idx=" + p_idx + ", c_num=" + c_num + ", p_name=" + p_name + ", p_price=" + p_price
				+ ", p_content=" + p_content + ", p_reserve=" + p_reserve + ", p_tag=" + p_tag + ", userid=" + userid
				+ ", p_date=" + p_date + ", p_image=" + p_image + ", p_thumbnail=" + p_thumbnail + ", s_idx=" + s_idx
				+ "]";
	}



	
}
