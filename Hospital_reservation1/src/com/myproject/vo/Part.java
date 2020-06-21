package com.myproject.vo;

public class Part {
	private int partnumber; //�μ���ȣ (1.����, 2.�ܰ�, 3.�Ҿư�, 4.�����ܰ�, 5.�Ȱ�)
	private String partname;   //�μ��̸�
	
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
