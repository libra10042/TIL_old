package com.mystudy.jdbc_dao;

import java.util.List;

public class MemberDAO_Test {

	public static void main(String[] args) {
		MemberDAO dao = new MemberDAO();
		MemberVO member = new MemberVO("hong2", "ȫ�浿2", "hong222", 
				"010-2222-2222", "�λ�");
		int cnt = dao.insertOne(member);
		System.out.println("> �Է°Ǽ� : " + cnt);
		
		//��ü ������ ��������
		System.out.println("\n----- ��ü ������ ��ȸ -------");
		List<MemberVO> list = dao.selectAll();
		for (MemberVO mvo : list) {
			System.out.println(mvo);
		}

	}

}







