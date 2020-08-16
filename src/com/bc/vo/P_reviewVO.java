package com.bc.vo;

public class P_reviewVO {
	private String p_idx, userid, r_size, r_colorsimiliarity, r_satisfaction, r_content, r_date;

	public String getP_idx() {
		return p_idx;
	}

	public void setP_idx(String p_idx) {
		this.p_idx = p_idx;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getR_size() {
		return r_size;
	}

	public void setR_size(String r_size) {
		this.r_size = r_size;
	}

	public String getR_colorsimiliarity() {
		return r_colorsimiliarity;
	}

	public void setR_colorsimiliarity(String r_colorsimiliarity) {
		this.r_colorsimiliarity = r_colorsimiliarity;
	}

	public String getR_satisfaction() {
		return r_satisfaction;
	}

	public void setR_satisfaction(String r_satisfaction) {
		this.r_satisfaction = r_satisfaction;
	}

	public String getR_content() {
		return r_content;
	}

	public void setR_content(String r_content) {
		this.r_content = r_content;
	}

	public String getR_date() {
		return r_date;
	}

	public void setR_date(String r_date) {
		this.r_date = r_date;
	}

	@Override
	public String toString() {
		return "P_reviewVO [p_idx=" + p_idx + ", userid=" + userid + ", r_size=" + r_size + ", r_colorsimiliarity="
				+ r_colorsimiliarity + ", r_satisfaction=" + r_satisfaction + ", r_content=" + r_content + ", r_date="
				+ r_date + "]";
	}
	
	
}
