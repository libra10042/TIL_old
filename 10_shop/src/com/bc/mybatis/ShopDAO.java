package com.bc.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class ShopDAO {
	private List<ShopVO> list;
	
	public ShopDAO() {
		System.out.println(">> ShopDAO 객체 생성");
	}
	
	public List<ShopVO> list(String category) {
		SqlSession ss = DBService.getFactory().openSession();
		list = ss.selectList("shop.list", category);
		ss.close();
		
		return list;
	}
	
}









