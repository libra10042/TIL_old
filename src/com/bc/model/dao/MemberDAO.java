package com.bc.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.bc.mybatis.DBService;
import com.bc.vo.MemberVO;

public class MemberDAO  {
/*	
	public static List<MemberVO> getAllUser() {
		SqlSession ss = DBService.getFactory().openSession();
		List<MemberVO> list = ss.selectList("MEMBER.allUser");
		ss.close();
		return list;
	}
	
	public static MemberVO login(String id, String password) {
		SqlSession ss = DBService.getFactory().openSession();
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("password", password);
		
		MemberVO member = new MemberVO();
		member = ss.selectOne("MEMBER.login", map);
		
		//System.out.println(member.getEmail() + " 로그인 성공!");;
		ss.close();
		return member;
	}
*/
	public static int register(MemberVO member) {
		SqlSession ss = DBService.getFactory().openSession(true);
		//System.out.println("dao register: " + member.getName());
		int result = ss.insert("SHOP.register", member);
		ss.close();
		return result;
	}
	
}

