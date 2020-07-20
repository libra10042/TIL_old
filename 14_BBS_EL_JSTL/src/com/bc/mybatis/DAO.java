package com.bc.mybatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class DAO {

	// 게시글(BBS_T)의 전체 건수 조회
	public static int getTotalCount() {
		SqlSession ss = DBService.getFactory().openSession();
		int totalCount = ss.selectOne("BBS.totalCount");
		ss.close();
		return totalCount;
	}
	
	//페이지에 해당하는 글목록(게시글) 가져오기
	public static List<BBSVO> getList(Map<String, Integer> map) {
		SqlSession ss = DBService.getFactory().openSession();
		List<BBSVO> list = ss.selectList("BBS.list", map);
		ss.close();
		return list;
	}
	
	//게시글 조회
	public static BBSVO selectOne(String b_idx) {
		SqlSession ss = DBService.getFactory().openSession();
		BBSVO vo = ss.selectOne("BBS.one", b_idx);
		ss.close();
		return vo;
	}
	
	//게시글 입력처리
	public static int insert(BBSVO bvo) {
		SqlSession ss = DBService.getFactory().openSession(true);
		int result = ss.insert("BBS.insert", bvo);
		ss.close();
		return result;
	}
	
	//게시글 수정(조회수 1 증가 처리)
	public static int updateHit(int b_idx) {
		SqlSession ss = DBService.getFactory().openSession(true);
		int result = ss.update("hit", b_idx);
		ss.close();
		return result;
	}
	
	//============== 댓글 관련 =====================
	public static List<CommVO> getCommList(String b_idx) {
		SqlSession ss = DBService.getFactory().openSession();
		List<CommVO> list = ss.selectList("BBS.commList", b_idx);
		ss.close();
		return list;
	}	
	
	//댓글 입력처리
	public static int insertComment(CommVO cvo) {
		SqlSession ss = DBService.getFactory().openSession(true);
		int result = ss.insert("BBS.c_insert", cvo);
		ss.close();
		return result;
	}
	
	//댓글삭제
	public static int deleteComment(String c_idx) {
		SqlSession ss = DBService.getFactory().openSession(true);
		int result = ss.insert("BBS.c_delete", c_idx);
		ss.close();
		return result;
	}
}












