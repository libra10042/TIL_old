package com.mystudy.jdbc_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// DAO, Dao : Data Access Object / Database Access Object
// ������(�����ͺ��̽�)�� �����ؼ� CRUD�� ������ Ŭ����
public class MemberDAO {
	private static final String DRIVER = "oracle.jdbc.OracleDriver"; 
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe"; 
	private static final String USER = "mystudy"; 
	private static final String PASSWORD = "mystudypw"; 
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	//����̹� �ε� ó��
	//static �ʱ�ȭ ����
	static {
		try {
			Class.forName(DRIVER);
			System.out.println(">> ����̹� �ε� ����");
		} catch (ClassNotFoundException e) {
			System.out.println("[���ܹ߻�] ����̹� �ε� ����!!!");
		}
	}
	
	//CRUD �۾��� �޼ҵ� �ۼ�
	//SELECT : ���̺� ��ü ������ ��ȸ - selectAll : List<MemberVO>
	public List<MemberVO> selectAll() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		try {
			//DB ���� - Connection ��ü����(DB�� �����) <- DriverManager Ŭ���� ���
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT ID, NAME, PASSWORD, PHONE, ADDRESS ");
			sql.append("  FROM MEMBER ");
			sql.append(" ORDER BY ID");
			pstmt = conn.prepareStatement(sql.toString());
			
			rs = pstmt.executeQuery();
			
			//SQL ���� ����� ���� ó��
			while (rs.next()) {
				/*
				MemberVO mvo = new MemberVO(
						rs.getString("ID"), 
						rs.getString("NAME"), 
						rs.getString("PASSWORD"), 
						rs.getString("PHONE"), 
						rs.getString("ADDRESS") );
				list.add(mvo);
				*/
				list.add(new MemberVO(
						rs.getString("ID"), 
						rs.getString("NAME"), 
						rs.getString("PASSWORD"), 
						rs.getString("PHONE"), 
						rs.getString("ADDRESS") ) );
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC_Close.closeConnStmtRs(conn, pstmt, rs);
		}
		
		return list;
	}
	
	//INSERT : VO ��ü�� �޾Ƽ� �Է� - insertOne : int
	public int insertOne(MemberVO member) {
		int result = 0;
		try {
			//DB ���� - Connection ��ü����(DB�� �����) <- DriverManager Ŭ���� ���
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			//SQL ������ �ۼ��ؼ� Statement�� �����ϰ� SQL�� ����
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO MEMBER ");
			sql.append("       (ID, NAME, PASSWORD, PHONE, ADDRESS) ");
			sql.append("VALUES (?, ?, ?, ?, ?) ");
			pstmt = conn.prepareStatement(sql.toString());
			
			// ?(���ε庯��)�� �� ��Ī ��Ű��
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getPassword());
			pstmt.setString(4, member.getPhone());
			pstmt.setString(5, member.getAddress());
			
			//SQL ���� ��û - insert, update, delete : executeUpdate()
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			//e.printStackTrace();
			result = -1;
		} finally {
			JDBC_Close.closeConnStmt(conn, pstmt);
		}
		
		return result;
	}
	
	//(�ǽ�)SELECT : ID ������ ������ ��ȸ - selectOne : MemberVO
	public MemberVO selectOne(String id) {
		MemberVO mvo = null;
		
		try {
			//DB ���� - Connection ��ü����(DB�� �����) <- DriverManager Ŭ���� ���
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT ID, NAME, PASSWORD, PHONE, ADDRESS ");
			sql.append("  FROM MEMBER ");
			sql.append(" WHERE ID = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			//SQL ���� ����� ���� ó��
			if (rs.next()) {
				mvo = new MemberVO(
						rs.getString("ID"), 
						rs.getString("NAME"), 
						rs.getString("PASSWORD"), 
						rs.getString("PHONE"), 
						rs.getString("ADDRESS") );
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC_Close.closeConnStmtRs(conn, pstmt, rs);
		}
		
		return mvo;
	}
	
	//SELECT : VO�� �޾Ƽ� ID�� ������ ��ȸ - selectOne : MemberVO
	
	//(�ǽ�)UPDATE : VO ��ü�� �޾Ƽ� ���� - updateOne : int
	//         NAME, PASSWORD, PHONE, ADDRESS �� ����
	public int updateOne(MemberVO member) {
		int result = 0;
		try {
			//DB ���� - Connection ��ü����(DB�� �����) <- DriverManager Ŭ���� ���
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			//SQL ������ �ۼ��ؼ� Statement�� �����ϰ� SQL�� ����
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE MEMBER ");
			sql.append("   SET NAME = ? ");
			sql.append("     , PASSWORD = ? ");
			sql.append("     , PHONE = ? ");
			sql.append("     , ADDRESS = ? ");
			sql.append(" WHERE ID = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			
			// ?(���ε庯��)�� �� ��Ī ��Ű��
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getPhone());
			pstmt.setString(4, member.getAddress());
			pstmt.setString(5, member.getId());
			
			//SQL ���� ��û - insert, update, delete : executeUpdate()
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			//e.printStackTrace();
			result = -1;
		} finally {
			JDBC_Close.closeConnStmt(conn, pstmt);
		}
		
		return result;
	}
	
	
	//UPDATE : ID, �н����� �޾Ƽ� �н����� ����
	//UPDATE : ID, PHONE �޾Ƽ� ��ȭ��ȣ ����
	//UPDATE : ID, �̸��� �޾Ƽ� �̸��� ����
	
	//DELETE : VO ��ü�� �޾Ƽ� ���� - deleteOne : int
	//(�ǽ�)DELETE : Ű��(id) �޾Ƽ� ���� - deleteOne : int
	public int deleteOne(String id) {
		int result = 0;
		try {
			//DB ���� - Connection ��ü����(DB�� �����) <- DriverManager Ŭ���� ���
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			//SQL ������ �ۼ��ؼ� Statement�� �����ϰ� SQL�� ����
			StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM MEMBER ");
			sql.append(" WHERE ID = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			
			// ?(���ε庯��)�� �� ��Ī ��Ű��
			pstmt.setString(1, id);
			
			//SQL ���� ��û - insert, update, delete : executeUpdate()
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			//e.printStackTrace();
			result = -1;
		} finally {
			JDBC_Close.closeConnStmt(conn, pstmt);
		}
		
		return result;
	}	
	
	//(�ǽ�)�α���ó�� : id, password ���� �޾Ƽ� ������ ������ ������ true
	//            ������ false ����
	// boolean checkIdPassword(id, password)
	public boolean checkIdPassword(String id, String password) {
		boolean isExist = false;
		
		try {
			//DB ���� - Connection ��ü����(DB�� �����) <- DriverManager Ŭ���� ���
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT COUNT(*) CNT");
			sql.append("  FROM MEMBER ");
			sql.append(" WHERE ID = ? AND PASSWORD = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			
			rs = pstmt.executeQuery();
			
			//SQL ���� ����� ���� ó��
			if (rs.getInt("CNT") > 0) {
				isExist = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC_Close.closeConnStmtRs(conn, pstmt, rs);
		}
		
		return isExist;
	}
	public String checkIdPassword2(String id, String password) {
		String name = null;
		
		try {
			//DB ���� - Connection ��ü����(DB�� �����) <- DriverManager Ŭ���� ���
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT NAME");
			sql.append("  FROM MEMBER ");
			sql.append(" WHERE ID = ? AND PASSWORD = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			
			rs = pstmt.executeQuery();
			
			//SQL ���� ����� ���� ó��
			if (rs.next()) {
				name = rs.getString("NAME");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC_Close.closeConnStmtRs(conn, pstmt, rs);
		}
		
		return name;
	}
}




















