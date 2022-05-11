package com.mystudy.jdbc_crud;

import java.util.List;

public class StudentCRUD_Test {

	public static void main(String[] args) {
		StudentCRUD crud = new StudentCRUD();
		crud.dispData("A1111");
		
		System.out.println("-----");
		String id = "A1111";
		StudentVO vo = crud.selectId(id);
		//�����Ͱ� ������ null ���� ���ϵǴ� ��� nullüũ ó��
		if (vo != null) {
			System.out.println("ID: "+ vo.getId() + ", �̸�: " + vo.getName());
			vo.printData();
		} else {
			System.out.println(id + " : ������ ����" );
		}
		
		System.out.println("==== selectAll() �׽�Ʈ ====");
		List<StudentVO> list = crud.selectAll();
		for (StudentVO student : list) {
			student.printData();
		}
		
		System.out.println("===== insertData() �׽�Ʈ ===");
		id = "I-5555";
		int cnt = crud.insertData(id, "I-�׽�Ʈ", 100, 90, 80, 0, 0);
		if (cnt > 0) {
			System.out.println(">> �Է� ����!!! : " + cnt + "�� �Է�");
		} else {
			System.out.println(">> �Է� ����!!! : " + cnt);
		}
		crud.dispData(id);
		
		System.out.println("----- VO �Է� ----");
		vo = new StudentVO("VO-2222", "�׽�Ʈ", 100, 90, 81);
		crud.insertData(vo);
		crud.dispData("VO-2222");
		
		System.out.println("==== updateData() �׽�Ʈ ==========");
		vo = new StudentVO("A2222", "������3", 99, 88, 77);
		crud.updateData(vo);
		crud.dispData(vo.getId());
		
		System.out.println("==== deleteData() �׽�Ʈ =========");
		crud.deleteData("A1111");
		crud.dispData("A1111");
		
		System.out.println("----- deleteData(VO) ---");
		crud.dispData(vo.getId());
		crud.deleteData(vo);
		crud.dispData(vo.getId());
		
		System.out.println("---- main() �� ----");
	}

}











