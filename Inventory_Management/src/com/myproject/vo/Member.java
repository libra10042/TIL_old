package com.myproject.vo;


//회원 등록 페이지 
public class Member {
	private String no; //회원 일련번호
	private String name; //회원 이름
	private String id; //회원 아이디
	private String pw; //회원 패스워드
	public Member() {
	}
	public Member(String no, String name, String id, String pw) {
		super();
		this.no = no;
		this.name = name;
		this.id = id;
		this.pw = pw;
	}
	
	
	
	
	public Member(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	@Override
	public String toString() {
		return "Member [no=" + no + ", name=" + name + ", id=" + id + ", pw=" + pw + "]";
	}
	
	
	
	
	
	
}
