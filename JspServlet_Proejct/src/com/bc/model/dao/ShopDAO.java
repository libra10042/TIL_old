package com.bc.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.bc.mybatis.DBService;
import com.bc.vo.CategoryVO;
import com.bc.vo.P_boardVO;
import com.bc.vo.S_sellerRegistVO;

public class ShopDAO {
	public static  S_sellerRegistVO viewSeller(String sr_idx) {
		SqlSession ss = DBService.getFactory().openSession();
		S_sellerRegistVO vo = ss.selectOne("SHOP.viewSeller", sr_idx);
		ss.close();
		return vo;
	}
	
	public static String viewShop(String userid) {
		SqlSession ss = DBService.getFactory().openSession();
		String sr_idx = ss.selectOne("SHOP.viewShop", userid);
		ss.close();
		return sr_idx;
	}
	
	public static String viewShop2(String userid) {
		SqlSession ss = DBService.getFactory().openSession();
		String s_idx = ss.selectOne("SHOP.viewShop2", userid);
		ss.close();
		return s_idx;
	}
	
	public static int insertShop (Map<String, String> map) {
		SqlSession ss = DBService.getFactory().openSession(true);
		int result = ss.insert("SHOP.insertShop", map);
		ss.close();
		return result;
	}
	
	public static int shopRegister(Map<String, String> map) {
		SqlSession ss = DBService.getFactory().openSession(true);
		int result = ss.insert("SHOP.shopRegister", map);
		ss.close();
		return result;
	}
	
	public static List<P_boardVO> searchProduct(String s_idx) {
		SqlSession ss = DBService.getFactory().openSession();
		List<P_boardVO> pvo = ss.selectList("SHOP.searchProduct", s_idx);
		ss.close();
		return pvo;
	}
	
	public static List<CategoryVO> viewCategory() {
		SqlSession ss = DBService.getFactory().openSession();
		List<CategoryVO> cavo = ss.selectList("SHOP.viewCategory");
		ss.close();
		return cavo;
	}
	
	public static int insertProduct(Map<String, String> map) {
		SqlSession ss = DBService.getFactory().openSession(true);
		int result = ss.insert("SHOP.insertProduct", map);
		ss.close();
		return result;
	}
	
}
