package com.mystudy.ojdbc3_prepare;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentManager_Select {

	public static void main(String[] args) {
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
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//1. JDBC ����̹� �ε�
			Class.forName("oracle.jdbc.OracleDriver");
			
			//2. DB����  - Connection ��ü ���� <- DriverManager
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", 
					"mystudy", "mystudypw");
			
			//3. Statement�� ����(SQL�� ����)
			//3-1. Connection ��ü�� ���� PreparedStatement ��ü����
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT ID, NAME, KOR, ENG, MATH, TOT, AVG ");
			sb.append("  FROM STUDENT ");
			sb.append(" WHERE ID = ? "); // ? : ���ε� ���� ��ġ ǥ�� ��ȣ
			pstmt = conn.prepareStatement(sb.toString());
			
			//3-2. ?(���ε庯��) �� ������ �� ���� ��Ű��
			String id = "A3333";
			pstmt.setString(1, id);	
			
			//3-3. Statement(PreparedStatement) ��� SQL ����
			rs = pstmt.executeQuery();
			
			//4. SQL ���� ����� ���� ó��
			//   -SELECT : ��ȸ(�˻�) ����Ÿ ��� ���� ���� ó��
			while (rs.next()) {
				sb.setLength(0);
				sb.append(rs.getString("ID")).append("\t");
				sb.append(rs.getString("NAME")).append("\t");
				sb.append(rs.getInt("KOR")).append("\t");
				sb.append(rs.getInt("ENG")).append("\t");
				sb.append(rs.getInt("MATH")).append("\t");
				sb.append(rs.getInt("TOT")).append("\t");
				sb.append(rs.getDouble("AVG"));
				
				System.out.println(sb.toString());
			}
			System.out.println(">> ������ ���� ��ȸ �Ϸ�");
			
		} catch (ClassNotFoundException | SQLException e) {
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

}








