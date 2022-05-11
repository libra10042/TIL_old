package com.mystudy.jdbc_dao;

import java.util.List;

public class MemberDAO_Test {

	public static void main(String[] args) {
		MemberDAO dao = new MemberDAO();
		MemberVO member = new MemberVO("hong2", "홍길동2", "hong222", 
				"010-2222-2222", "부산");
		int cnt = dao.insertOne(member);
		System.out.println("> 입력건수 : " + cnt);
		
		//전체 데이터 가져오기
		System.out.println("\n----- 전체 데이터 조회 -------");
		List<MemberVO> list = dao.selectAll();
		for (MemberVO mvo : list) {
			System.out.println(mvo);
		}

	}

}







