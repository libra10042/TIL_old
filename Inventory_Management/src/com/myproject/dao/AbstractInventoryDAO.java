package com.myproject.dao;

import java.util.ArrayList;

import com.myproject.vo.Admin;
import com.myproject.vo.Member;
import com.myproject.vo.Product;

public interface AbstractInventoryDAO {

	public boolean insertMebmer(Member vo); //회원 가입.
	public boolean printAllMember(); //고객 정보 모두 출력. 
	
	/*-----------관리자 기능--------------- */
	/*
	 관리자 회원가입 정보를 db에 저장한다. 
	 */
	public int insertAdmin(Admin vo);

	/*
	 관리자 로그인
	 */
	public boolean loginAdmin(Admin admin);
	
	
	/*
	 회원정보를 불러온다.
	 */
	public ArrayList<Member> searchAllMember();
	
	
	
	/*
	 가입된 회원 전체 정보 출력. 
	 */
	public ArrayList<Member> loginAdmin();
	
	/*
	  
	 
	 */
	
	
	
	/*--------------------------------------------------------------*/
	/* 특정 품목에 대한 재고 확인하는 메소드 
	 @param productId : 재고를 확인할 품목에 대한 id
	 @return Product : 재고가 확인된 품목 객체
	 */
	public Product stockCheck(String productId);
	
	/*
	 판매하는 전체 품목에 대한 재고 확인
	 */
	public Product allstockCheck();
	
	
	
	/*
	 새로운 풀품 등록
	 @param product : 판매자가 팔매할 새로운 물품을 등록한다.
	 @return        등록 여부(true: 등록 완료, false: 등록불가)
	 */
	public boolean stockCreate(Product product);
	
	
	
	/*
	 
	  
	 */
	
	
	
	
	/*--------------------------------------------------------------*/
	

	
}


