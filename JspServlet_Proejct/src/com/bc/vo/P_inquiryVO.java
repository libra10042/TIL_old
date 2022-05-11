package com.bc.vo;

public class P_inquiryVO {
	private String p_idx, userid, i_category, i_content, i_answer, i_date, i_idx, i_title;

	public String getP_idx() {
		return p_idx;
	}

	public void setP_idx(String p_idx) {
		this.p_idx = p_idx;
	}
	

	public String getI_title() {
		return i_title;
	}

	public void setI_title(String i_title) {
		this.i_title = i_title;
	}

	public String getI_idx() {
		return i_idx;
	}

	public void setI_idx(String i_idx) {
		this.i_idx = i_idx;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getI_category() {
		return i_category;
	}

	public void setI_category(String i_category) {
		this.i_category = i_category;
	}

	public String getI_content() {
		return i_content;
	}

	public void setI_content(String i_content) {
		this.i_content = i_content;
	}

	public String getI_answer() {
		return i_answer;
	}

	public void setI_answer(String i_answer) {
		this.i_answer = i_answer;
	}

	public String getI_date() {
		return i_date;
	}

	public void setI_date(String i_date) {
		this.i_date = i_date;
	}

	@Override
	public String toString() {
		return "P_inquiryVO [p_idx=" + p_idx + ", userid=" + userid + ", i_category=" + i_category + ", i_content="
				+ i_content + ", i_answer=" + i_answer + ", i_date=" + i_date + ", i_idx=" + i_idx + ", i_title="
				+ i_title + "]";
	}
	
	
}
