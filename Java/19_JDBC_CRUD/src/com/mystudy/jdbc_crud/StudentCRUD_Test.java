package com.mystudy.jdbc_crud;

import java.util.List;

public class StudentCRUD_Test {

	public static void main(String[] args) {
		StudentCRUD crud = new StudentCRUD();
		crud.dispData("A1111");
		
		System.out.println("-----");
		String id = "A1111";
		StudentVO vo = crud.selectId(id);
		//데이터가 없으면 null 값이 리턴되는 경우 null체크 처리
		if (vo != null) {
			System.out.println("ID: "+ vo.getId() + ", 이름: " + vo.getName());
			vo.printData();
		} else {
			System.out.println(id + " : 데이터 없음" );
		}
		
		System.out.println("==== selectAll() 테스트 ====");
		List<StudentVO> list = crud.selectAll();
		for (StudentVO student : list) {
			student.printData();
		}
		
		System.out.println("===== insertData() 테스트 ===");
		id = "I-5555";
		int cnt = crud.insertData(id, "I-테스트", 100, 90, 80, 0, 0);
		if (cnt > 0) {
			System.out.println(">> 입력 성공!!! : " + cnt + "건 입력");
		} else {
			System.out.println(">> 입력 실패!!! : " + cnt);
		}
		crud.dispData(id);
		
		System.out.println("----- VO 입력 ----");
		vo = new StudentVO("VO-2222", "테스트", 100, 90, 81);
		crud.insertData(vo);
		crud.dispData("VO-2222");
		
		System.out.println("==== updateData() 테스트 ==========");
		vo = new StudentVO("A2222", "김유신3", 99, 88, 77);
		crud.updateData(vo);
		crud.dispData(vo.getId());
		
		System.out.println("==== deleteData() 테스트 =========");
		crud.deleteData("A1111");
		crud.dispData("A1111");
		
		System.out.println("----- deleteData(VO) ---");
		crud.dispData(vo.getId());
		crud.deleteData(vo);
		crud.dispData(vo.getId());
		
		System.out.println("---- main() 끝 ----");
	}

}











