package kr.co.softcampus.beans;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class DataBean1 {

	@AssertTrue
	private boolean data1;

	@AssertFalse
	private boolean data2; 
	
	@Max(100)
	@Min(10)
	private String data3; 

	@DecimalMax(value="100", inclusive=false)
	@DecimalMin(value="10", inclusive=false)
	private String data4; 
	
	@Null
	private String data5; 
	
	@NotNull
	private String data6;

	
	@Digits(integer = 3, fraction = 3)
	private String data7; 
	
	
	@Size(min = 3, max = 10)
	private String data8; 
	
	@Pattern(regexp = "[a-zA-Z]*")
	private String data9; 
	
	
	public DataBean1() {
		this.data1 = true; 
		this.data2 = false; 
		this.data3 = "50";
		this.data4 = "50";
		this.data5 = null; 
		this.data6 = "check2";
		this.data7 = "111.111";
		this.data8 = "abcd";
	}



	public boolean isData1() {
		return data1;
	}



	public void setData1(boolean data1) {
		this.data1 = data1;
	}



	public boolean isData2() {
		return data2;
	}



	public void setData2(boolean data2) {
		this.data2 = data2;
	}



	public String getData3() {
		return data3;
	}



	public void setData3(String data3) {
		this.data3 = data3;
	}



	public String getData4() {
		return data4;
	}



	public void setData4(String data4) {
		this.data4 = data4;
	}



	public String getData5() {
		return data5;
	}



	public void setData5(String data5) {
		this.data5 = data5;
	}



	public String getData6() {
		return data6;
	}



	public void setData6(String data6) {
		this.data6 = data6;
	}



	public String getData7() {
		return data7;
	}



	public void setData7(String data7) {
		this.data7 = data7;
	}



	public String getData8() {
		return data8;
	}



	public void setData8(String data8) {
		this.data8 = data8;
	}



	public String getData9() {
		return data9;
	}



	public void setData9(String data9) {
		this.data9 = data9;
	}
	
	
	 
	
	
	
	
	
}
