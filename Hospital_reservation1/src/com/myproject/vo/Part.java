package com.myproject.vo;

public class Part {
	private int partnumber; //부서번호 (1.내과, 2.외과, 3.소아과, 4.정형외과, 5.안과)
	private String partname;   //부서이름
	
	public Part() {
		// TODO Auto-generated constructor stub
	}

	public Part(int partnumber, String partname) {
		super();
		this.partnumber = partnumber;
		this.partname = partname;
	}

	public int getPartnumber() {
		return partnumber;
	}

	public void setPartnumber(int partnumber) {
		this.partnumber = partnumber;
	}

	public String getPartname() {
		return partname;
	}

	public void setPartname(String partname) {
		this.partname = partname;
	}

	@Override
	public String toString() {
		return "Part [partnumber=" + partnumber + ", partname=" + partname + "]";
	}
	
	
	
	
	
}
