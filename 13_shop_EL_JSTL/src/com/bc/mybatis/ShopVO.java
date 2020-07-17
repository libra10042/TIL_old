package com.bc.mybatis;

public class ShopVO {
	//DB에 있는 데이터
	private String num, category, p_num, p_name, p_company;
	private String p_image_s, p_image_l, p_content, p_date;
	private int p_price, p_saleprice;
	
	//수량, 수량별 금액(판매가 * 수량)
	private int quant; //장바구니에 담긴 수량
	private int totalprice; //수량별 금액(판매가 * 수량)
	
	//할인율 조회 메소드
	public int getPercent() {
		double percent = (p_price - p_saleprice) * 100 / p_price;
		return (int) percent;
	}
	
	public int getQuant() {
		return quant;
	}
	public void setQuant(int quant) {
		this.quant = quant;
		//수량이 변경되면 수량별금액(totalprice) 계산후 변경처리
		totalprice = p_saleprice * quant;
	}
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	//setters, getters
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getP_num() {
		return p_num;
	}
	public void setP_num(String p_num) {
		this.p_num = p_num;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getP_company() {
		return p_company;
	}
	public void setP_company(String p_company) {
		this.p_company = p_company;
	}
	public String getP_image_s() {
		return p_image_s;
	}
	public void setP_image_s(String p_image_s) {
		this.p_image_s = p_image_s;
	}
	public String getP_image_l() {
		return p_image_l;
	}
	public void setP_image_l(String p_image_l) {
		this.p_image_l = p_image_l;
	}
	public String getP_content() {
		return p_content;
	}
	public void setP_content(String p_content) {
		this.p_content = p_content;
	}
	public String getP_date() {
		return p_date;
	}
	public void setP_date(String p_date) {
		this.p_date = p_date;
	}
	public int getP_price() {
		return p_price;
	}
	public void setP_price(int p_price) {
		this.p_price = p_price;
	}
	public int getP_saleprice() {
		return p_saleprice;
	}
	public void setP_saleprice(int p_saleprice) {
		this.p_saleprice = p_saleprice;
	}
	@Override
	public String toString() {
		return "ShopVO [num=" + num + ", category=" + category + ", p_num=" + p_num + ", p_name=" + p_name
				+ ", p_company=" + p_company + ", p_image_s=" + p_image_s + ", p_image_l=" + p_image_l + ", p_content="
				+ p_content + ", p_date=" + p_date + ", p_price=" + p_price + ", p_saleprice=" + p_saleprice + "]";
	}

}
