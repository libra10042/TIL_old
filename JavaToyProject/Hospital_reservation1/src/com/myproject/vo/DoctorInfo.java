package com.myproject.vo;

public class DoctorInfo extends Doctor{
	private String major;//전공
	private String education;//학력
	private String career;//경력
	
	
	 public DoctorInfo() {

	 }


	public DoctorInfo(String major, String education, String career) {
		super();
		this.major = major;
		this.education = education;
		this.career = career;
	}


	public String getMajor() {
		return major;
	}


	public void setMajor(String major) {
		this.major = major;
	}


	public String getEducation() {
		return education;
	}


	public void setEducation(String education) {
		this.education = education;
	}


	public String getCareer() {
		return career;
	}


	public void setCareer(String career) {
		this.career = career;
	}


	@Override
	public String toString() {
		return "DoctorInfo [major=" + major + ", education=" + education + ", career=" + career + "]";
	}


	

	 
	
	
	
}
