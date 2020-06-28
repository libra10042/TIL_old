package com.myproject.dao;

import java.util.ArrayList;

import com.myproject.vo.Admin;
import com.myproject.vo.Product;
import com.myproject.vo.SalesList;
import com.myproject.vo.Sales;

public interface AbstractInventoryDAO {

	
	public boolean login(Admin vo); //관리자 로그인 
	public boolean insertMember(Admin vo);  //관리자 회원가입
	
	public int insertProduct(Product vo); //상품 등록 
	public ArrayList<Product> listProduct(); //상품 전체 보기 
	public int insert(Sales vo); //판매 정보 등록 
	public ArrayList<Sales> list(); //판매 정보 전체보기.
	public int update(Sales vo); //판매 정보 수정
	public int delete(int num); //판매 정보 삭제 
	public ArrayList<SalesList> sales(); //상품별 판매 예상 매출 정보. 
	
	



	
}


