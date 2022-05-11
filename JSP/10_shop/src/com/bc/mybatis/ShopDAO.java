package com.bc.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class ShopDAO {
	
	public ShopDAO() {
		System.out.println(">> ShopDAO 객체 생성");
	}
	
	public List<ShopVO> list(String category) {
		SqlSession ss = DBService.getFactory().openSession();
		List<ShopVO> list = ss.selectList("shop.list", category);
		ss.close();
		
		return list;
	}
	
	// 제품번호로 데이터 조회
	public ShopVO selectOne(String pNum) {
		SqlSession ss = DBService.getFactory().openSession();
		ShopVO vo = ss.selectOne("shop.one", pNum);
		ss.close();
		
		return vo;
	}
	
}




















