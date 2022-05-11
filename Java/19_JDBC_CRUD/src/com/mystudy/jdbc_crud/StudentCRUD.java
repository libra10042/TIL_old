package com.mystudy.jdbc_crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//JDBC�� �̿��� DB ���α׷��� ���� 
//0. JDBC ���̺귯�� ����ȯ�� ����(�����ο� ���)
//1. JDBC ����̹� �ε�
//2. DB����  - Connection ��ü ���� <- DriverManager
//3. Statement�� ����(SQL�� ����)
//4. SQL ���� ����� ���� ó��
//   -SELECT : ��ȸ(�˻�) ����Ÿ ��� ���� ���� ó��
//   -INSERT, UPDATE, DELETE : int��(�Ǽ�) ó��
//5. Ŭ��¡ ó���� ���� �ڿ� �ݳ�
//------------------------------------
public class StudentCRUD {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public StudentCRUD() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println(">> ����̹� �ε� ����");
			e.printStackTrace();
		}
	}
	
	//Student ���̺� �ִ� 1���� ������ ��ȸ�ؼ� ȭ�� ǥ��
	// ID���� �����ϸ� �����͸� �����ͼ� ȭ�鿡 ǥ��
	public void dispData(String id) {
		try {
			//2. DB����  - Connection ��ü ���� <- DriverManager
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", 
					"mystudy", "mystudypw");
			
			//3. Statement�� ����(SQL�� ����)
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT ID, NAME, KOR, ENG, MATH, TOT, AVG ");
			sql.append("  FROM STUDENT ");
			sql.append(" WHERE ID = ? ");
			
			//3-1. PreparedStatement ��ü���� <- Connection ��ü�� ����
			pstmt = conn.prepareStatement(sql.toString());
			
			//3-2. ? (���ε庯��)�� �� ����
			pstmt.setString(1, id);
			
			//3-3. SQL�� ����
			rs = pstmt.executeQuery();
			
			//4. SQL ���� ����� ���� ó��
			//   -SELECT : ��ȸ(�˻�) ����Ÿ ��� ���� ���� ó��
			if (rs.next()) {
				System.out.print(rs.getString("ID") + "\t");
				System.out.print(rs.getString("NAME") + "\t");
				System.out.print(rs.getInt("KOR") + "\t");
				System.out.print(rs.getInt("ENG") + "\t");
				System.out.print(rs.getInt("MATH") + "\t");
				System.out.print(rs.getInt("TOT") + "\t");
				System.out.print(rs.getDouble("AVG"));
				System.out.println();
			} else {
				System.out.println("���̵� : " + id + " - ������ ����");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//5. Ŭ��¡ ó���� ���� �ڿ� �ݳ�
			try {
				if (rs != null) rs.close();
			} catch (SQLException e) {}
			try {
				if (pstmt != null) pstmt.close();
			} catch (SQLException e) {}
			try {
				if (conn != null) conn.close();
			} catch (SQLException e) {}
		}
	}
	
	//�ϳ��� �����͸� ��ȸ�ؼ� VO�� �����ؼ� ����
	public StudentVO selectId(String id) {
		System.out.println("----> selectId() ����");
		StudentVO stu = null;
		
		try {
			//2. DB����  - Connection ��ü ���� <- DriverManager
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", 
					"mystudy", "mystudypw");
			
			//3. Statement�� ����(SQL�� ����)
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT ID, NAME, KOR, ENG, MATH, TOT, AVG ");
			sql.append("  FROM STUDENT ");
			sql.append(" WHERE ID = ? ");
			
			//3-1. PreparedStatement ��ü���� <- Connection ��ü�� ����
			pstmt = conn.prepareStatement(sql.toString());
			
			//3-2. ? (���ε庯��)�� �� ����
			pstmt.setString(1, id);
			
			//3-3. SQL�� ����
			rs = pstmt.executeQuery();
			
			//4. SQL ���� ����� ���� ó��
			//   -SELECT : ��ȸ(�˻�) ����Ÿ ��� ���� ���� ó��
			if (rs.next()) {
				// StudentVO Ÿ�� ��ü �����ϰ� ������ ����
				stu = new StudentVO(id, 
						rs.getString("NAME"), 
						rs.getInt("KOR"), 
						rs.getInt("ENG"), 
						rs.getInt("MATH"), 
						rs.getInt("TOT"), 
						rs.getDouble("AVG") );

			} else {
				System.out.println("���̵� : " + id + " - ������ ����");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//5. Ŭ��¡ ó���� ���� �ڿ� �ݳ�
			close(conn, pstmt, rs);
		}
		
		System.out.println("----> selectId() ��");
		return stu;
	}
	private void close(Connection conn, 
			PreparedStatement pstmt, ResultSet rs) {
		//5. Ŭ��¡ ó���� ���� �ڿ� �ݳ�
		try {
			if (rs != null) rs.close();
			System.out.println(">> ResultSet close");
		} catch (SQLException e) {}
		try {
			if (pstmt != null) pstmt.close();
			System.out.println(">> PreparedStatement close");
		} catch (SQLException e) {}
		try {
			if (conn != null) conn.close();
			System.out.println(">> Connection close");
		} catch (SQLException e) {}
	}
	private void close(Connection conn, PreparedStatement pstmt) {
		try {
			if (pstmt != null) pstmt.close();
			System.out.println(">> PreparedStatement close");
		} catch (SQLException e) {}
		try {
			if (conn != null) conn.close();
			System.out.println(">> Connection close");
		} catch (SQLException e) {}
	}
	
	//��ü ������ ��ȸ ArrayList�� ��Ƽ� ����
	//�ϳ��� �����ʹ� StudentVO�� ���, VO�� ArrayList�� ��Ƽ� ����
	public List<StudentVO> selectAll() {
		List<StudentVO> list = new ArrayList<>();
		
		try {
			//2. DB����  - Connection ��ü ���� <- DriverManager
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", 
					"mystudy", "mystudypw");
			//3. Statement�� ����(SQL�� ����)
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT ID, NAME, KOR, ENG, MATH, TOT, AVG ");
			sql.append("  FROM STUDENT ");
			sql.append(" ORDER BY ID ");
			
			//3-1. PreparedStatement ��ü���� <- Connection ��ü�� ����
			pstmt = conn.prepareStatement(sql.toString());
			
			//3-2. SQL�� ����
			rs = pstmt.executeQuery();
			
			//4. SQL�� ������ ó��
			// DB������ �ϳ��� StudentVO�� ���� + ����Ʈ�� �߰�
			while (rs.next()) {
				//DB������ StudentVO�� ����
				StudentVO vo = new StudentVO(
						rs.getString("ID"), 
						rs.getString("NAME"), 
						rs.getInt("KOR"), 
						rs.getInt("ENG"), 
						rs.getInt("MATH"), 
						rs.getInt("TOT"), 
						rs.getDouble("AVG") );
				
				//VO�� ����Ʈ�� �߰�
				list.add(vo);
			}
			
		} catch (SQLException e) {
			list = null;
			e.printStackTrace();
		}
		
		return list;
	}
	
	//DB�� ������ �Է�(INSERT)
	//��� �÷����� �޾Ƽ� �Է� ó��
	public int insertData(String id, String name, 
			int kor, int eng, int math, int tot, double avg) {
		return insertData(new StudentVO(id, name, kor, eng, math, tot, avg));
/*		
		int cnt = 0;
		//(�ǽ�) DB�����ϰ� ���޹��� �����͸� DB�� �Է�ó��(�Է°Ǽ� ����)
		try {
			//2. DB����  - Connection ��ü ���� <- DriverManager
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", 
					"mystudy", "mystudypw");
			
			//3. Statement�� ����(SQL�� ����)
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO STUDENT ");
			sql.append("       (ID, NAME, KOR, ENG, MATH, TOT, AVG) ");
			sql.append("VALUES (?, ?, ?, ?, ?, ?, ?) ");
			System.out.println("INSERT SQL : " + sql.toString());
			
			pstmt = conn.prepareStatement(sql.toString()); //SQL�� �����ؼ� �غ�
			
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setInt(3, kor);
			pstmt.setInt(4, eng);
			pstmt.setInt(5, math);
			pstmt.setInt(6, tot);
			pstmt.setDouble(7, avg);
			
			cnt = pstmt.executeUpdate(); //SQL�� ���� : INSERT,UPDATE,DELETE - executeUpdate()
		} catch (SQLException e) {
			cnt = -1;
			//e.printStackTrace();
		} finally {
			close(conn, pstmt);
		}
		return cnt;
*/		
	}
	
	//DB�� ������ �Է�(INSERT) : StudentVO Ÿ�� �� ���޹޾� �Է�ó��
	public int insertData(StudentVO student) {
		int cnt = 0;
		//(�ǽ�) DB�����ϰ� ���޹��� �����͸� DB�� �Է�ó��(�Է°Ǽ� ����)
		try {
			//2. DB����  - Connection ��ü ���� <- DriverManager
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", 
					"mystudy", "mystudypw");
			
			//3. Statement�� ����(SQL�� ����)
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO STUDENT ");
			sql.append("       (ID, NAME, KOR, ENG, MATH, TOT, AVG) ");
			sql.append("VALUES (?, ?, ?, ?, ?, ?, ?) ");
			System.out.println("INSERT SQL : " + sql.toString());
			
			pstmt = conn.prepareStatement(sql.toString()); //SQL�� �����ؼ� �غ�
			
			pstmt.setString(1, student.getId());
			pstmt.setString(2, student.getName());
			pstmt.setInt(3, student.getKor());
			pstmt.setInt(4, student.getEng());
			pstmt.setInt(5, student.getMath());
			pstmt.setInt(6, student.getTot());
			pstmt.setDouble(7, student.getAvg());
			
			cnt = pstmt.executeUpdate(); //SQL�� ���� : INSERT,UPDATE,DELETE - executeUpdate()
		} catch (SQLException e) {
			cnt = -1;
			//e.printStackTrace();
		} finally {
			close(conn, pstmt);
		}		
		return cnt;
	}
	
	//����(UPDATE) : StudentVO �����͸� �޾Ƽ� ����(ID ������ ��� ������ ����)
	public int updateData(StudentVO student) {
		System.out.println(">> updateData() ����");
		int result = 0;
		//(�ǽ�)DB�����ϰ� ���޹��� VO �����Ϳ� ��ġ�ϴ� ID �����͸� ����
		try {
			//2. DB����  - Connection ��ü ���� <- DriverManager
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", 
					"mystudy", "mystudypw");
			
			//3. Statement�� ����(SQL�� ����)
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE STUDENT ");
			sql.append("   SET NAME = ? ");
			sql.append("     , KOR = ? ");
			sql.append("     , ENG = ? ");
			sql.append("     , MATH = ? ");
			sql.append("     , TOT = ? ");
			sql.append("     , AVG = ? ");
			sql.append(" WHERE ID = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			
			int idx = 1;
			pstmt.setString(idx++, student.getName());
			pstmt.setInt(idx++, student.getKor());
			pstmt.setInt(idx++, student.getEng());
			pstmt.setInt(idx++, student.getMath());
			pstmt.setInt(idx++, student.getTot());
			pstmt.setDouble(idx++, student.getAvg());
			
			//where�� ��Ī��
			pstmt.setString(idx++, student.getId());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt);
		}
		
		System.out.println(">> updateData() ��");
		return result;
	}
	//����(DELETE) : ID���� ���޹޾� ������ ����
	public int deleteData(String id) {
		int result = 0;
		try {
			//2. DB����  - Connection ��ü ���� <- DriverManager
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", 
					"mystudy", "mystudypw");
			
			//3. Statement�� ����(SQL�� ����)
			StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM STUDENT WHERE ID = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			
			//where�� ��Ī��
			pstmt.setString(1, id);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt);
		}
		return result;
	}
	//����(DELETE) : StudentVO ���޹޾� ������ ����
	public int deleteData(StudentVO student) {
		return deleteData(student.getId());
	}
	
	//=======================================
	//----- INSERT �ǽ� ------------
	//(�ǽ�) StudentVO �����͸� ���޹޾Ƽ� �Է� ó��(TOT, AVG ��� �� �Է�)
	
	//----- UPDATE �ǽ�
	//(�ǽ�) ID, NAME ���� �޾Ƽ� ID�� ��ȸ�ϰ�, NAME ����
	//(�ǽ�) ID, KOR, ENG, MATH ���� �޾Ƽ� ID�� ã��
	//       KOR, ENG, MATH, TOT, AVG �� ����(TOT, AVG ��� ó��)
	//(�ǽ�) ID �޾Ƽ� TOT, AVG ���� ó��(TOT, AVG ���� ó��)
	
	//----- DELETE �ǽ�
	//(�ǽ�) �̸� �޾Ƽ� ����
	
	//----- SELECT �ǽ�
	//(�ǽ�) �̸����� ��ȸ - �̸� �ߺ� ���ɼ� ����(List, Set, Map ���)
}















