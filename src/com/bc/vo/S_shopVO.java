package com.bc.vo;

public class S_shopVO {
	private String s_idx, userid, sr_idx, s_image, s_satis;

	public String getS_idx() {
		return s_idx;
	}

	public void setS_idx(String s_idx) {
		this.s_idx = s_idx;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getSr_idx() {
		return sr_idx;
	}

	public void setSr_idx(String sr_idx) {
		this.sr_idx = sr_idx;
	}

	public String getS_image() {
		return s_image;
	}

	public void setS_image(String s_image) {
		this.s_image = s_image;
	}

	public String getS_satis() {
		return s_satis;
	}

	public void setS_satis(String s_satis) {
		this.s_satis = s_satis;
	}

	@Override
	public String toString() {
		return "S_shopVO [s_idx=" + s_idx + ", userid=" + userid + ", sr_idx=" + sr_idx + ", s_image=" + s_image
				+ ", s_satis=" + s_satis + "]";
	}
	
	

}
