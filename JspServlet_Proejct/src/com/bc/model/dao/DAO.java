package com.bc.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bc.mybatis.DBService;
import com.bc.vo.O_OrderVO;
import com.bc.vo.P_boardVO;
import com.bc.vo.SignUpVO;

public class DAO {

	//주문 조회
	public static List<O_OrderVO> getOrder(String userid) {
		SqlSession ss = DBService.getFactory().openSession();
		List<O_OrderVO> order = ss.selectList("SHOP.Shop_order", userid);
		ss.close();
		return order;
	}
	
	//주문서 작성 - 주문리스트
	public static List<P_boardVO> getView(String userid) {
		SqlSession ss = DBService.getFactory().openSession();
		List<P_boardVO> view = ss.selectList("SHOP.Shop_view", userid);
		ss.close();
		return view;
	}
	
	//주문서 작성 - 주문자정보
	public static int insert(SignUpVO svo) {
		SqlSession ss = DBService.getFactory().openSession(true);
		int write = ss.insert("SHOP.Shop_write", svo);
		ss.close();
		return write;
	}

}
