package com.bc.mybatis;

import org.apache.ibatis.session.SqlSession;

public class DAO {

	// 게시글(BBS_T)의 전체 건수 조회
	public static int getTotalCount() {
		SqlSession ss = DBService.getFactory().openSession();
		int totalCount = ss.selectOne("BBS.totalCount");
		ss.close();
		return totalCount;
	}
}












