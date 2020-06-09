package com.myproject.dao;

import java.util.ArrayList;


import com.myproject.vo.Member;
import com.myproject.vo.Product;
import com.myproject.vo.SalesList;
import com.myproject.vo.Sales;


public interface AbstractInventoryDAO {

	
	public boolean loginMember(Member vo); //회원 로그인. 0
	public boolean insertMember(Member vo);// 회원등록. 0
	
	
	/*------------- 관리자 기능 ----------------*/
	public ArrayList<Member> printAllMember(); // 멤버 전체 출력하기
	
	public Member SalesInfo(); //판매자별 매출 정보 확인. 
	
	/*------------- 판매자 기능 ----------------*/

	
	public int insertProduct(Product vo); //상품 정보를 db에 저장한다.
	public ArrayList<Product> listProduct(); //DB에 저장된 모든 상품정보를 코드 순으로 읽어온다.
	public int insert(Sales vo); // 판매정보를 db에 저장한다.
	public ArrayList<Sales> list(); //DB에 저장된 모든 판매 정보를 날짜순으로 읽어온다.
	public int update(Sales vo); // 번호와 판매수량을 전달받아 해당 번호의 데이터를 수정한다.
	public int delete(int num); //번호를 전달받아 해당 판매 정보를 삭제한다.
	public ArrayList<SalesList> sales(); //상품별로 판매수량과 판매금액을 구한다. (판매정보가 담김)
	
	
	
	

	



	
}


