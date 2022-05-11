package com.myproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.myproject.vo.Clients;
import com.myproject.vo.Doctor;
import com.myproject.vo.Doctor_Schedule;

public class CustomerDao{
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// con, pstmt, rs ��ü �ݱ� 
	public void closeConnection() {
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(con!=null) con.close(); 
		}catch(SQLException e) {
			
		}
	}
	
	
	//�ű� �����. 
	public boolean insertClients(Clients c) {
		boolean flag = false; 
		try {
			con = ConnectionManager.getConnection();
			String sql = "insert into Clients values(clients_seq.nextval, ?,?,?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1,  c.getClname());
			pstmt.setString(2, c.getClpn());
			pstmt.setString(3, c.getClphone());
			int inserted = pstmt.executeUpdate();
			
			if(inserted ==1) {
				flag = true;
			}
			
		}catch(Exception e) {
			
		}finally {
			closeConnection();
		}
		return flag; 
		
	}
	
	// �����湮 �� ��ȸ
	public boolean existsClient(Clients vo) {
		boolean flag = false; 
		try {
			con = ConnectionManager.getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append("select clnumber, clname from clients where clnumber =? \n");
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, vo.getClnumber());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				 flag = true; 
				 do {
					 System.out.println("------------------------");
					 System.out.println(rs.getString("clname") + " ����" + " ����ȣ�� " + rs.getString("clnumber") + "�Դϴ�.");
					 System.out.println("------------------------");
				 }while(rs.next());
				 
			}else {
				System.out.println("�� ������ �����ϴ�.");
			}
			
		}catch(Exception e) {
			
		}finally {
			closeConnection();
		}
		
		
		return flag;
	}
	
	// �� �ڵ��� ��ȣ�� ����ȣ ��ȸ.
	public boolean checkClientNumber(Clients vo) {
		boolean flag = false; 
		try {
			con = ConnectionManager.getConnection();
			String sql = "select clnumber from clients where clname =? and clpn = ?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, vo.getClname());
			pstmt.setString(2, vo.getClpn());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				flag = true; 
				System.out.println("��ϵ� ������ ��ȣ�� " + rs.getInt("CLNUMBER") + "�Դϴ�.");
			}else {	
				System.out.println("��ϵ� �� �����Ͱ� �����ϴ�.");
				return flag; 
			}
			
			
		}catch(Exception e) {
			
		}finally {
			closeConnection();
		}
		
		return flag; 
	}
	
	
	
	//�� ��ȭ��ȣ�� �����Ѵ�. (�� �̸��� �� �ֹι�ȣ�� �Է��Ѵ�.)
	public boolean updateClients(Clients vo) {
		boolean flag = false; 
		
		try {
			con = ConnectionManager.getConnection();
			StringBuilder sb = new StringBuilder(); 
			sb.append("update clients set clphone =? \n");
			sb.append("where clname=? and clpn = ?");

			pstmt = con.prepareStatement(sb.toString());
			
			pstmt.setString(1, vo.getClphone());
			pstmt.setString(2, vo.getClname());
			pstmt.setString(3, vo.getClpn());
			
			int inserted = pstmt.executeUpdate(); 
			if(inserted==1) {
				flag = true; 
			}
		}catch(Exception e) {
			
		}finally {
			closeConnection();
		}
		
		return flag; 
		
	}
	
	//�� ��ȣ�� ã�´�.
	public boolean searchClientNumber(Clients vo) {
		boolean flag = false; 
		try {
			con = ConnectionManager.getConnection();
			StringBuilder sb = new StringBuilder(); 
			sb.append("select clnumber, clname from clients \n");
			sb.append("where clphone = ? ");
			
			pstmt = con.prepareStatement(sb.toString());
			
			pstmt.setString(1,  vo.getClphone());
			
			rs = pstmt.executeQuery(); 
			if(rs.next()) {
				do {
					flag = true; 
					System.out.println(rs.getString("clname") + "���� �н��Ͻ�  ����ȣ�� " + rs.getInt("clnumber") +"�Դϴ�.");
				}while(rs.next());
			}
			
			
		}catch(Exception e) {
		
		}finally {
			closeConnection();
		}
		return flag; 
	
	}
	//--------------------------------------------------------------------------------------------------------------------------
	
	public void reservation() {
		try {
			con = ConnectionManager.getConnection();
			
		}catch(Exception e) {
			
		}finally {
			closeConnection();
		}
	}
	
	//���� ����ȣ�� ���� ���� ��ȸ �ϱ�.
	public void searchClientReservation() {
		boolean flag = false; 
		try {
			con = ConnectionManager.getConnection();
			String sql = "select * from Reserve where clnumber = ?";
			pstmt = con.prepareStatement(sql);
			
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				flag = true;
			}
			
		}catch(Exception e) {
			
		}finally {
			closeConnection();
		}
		
		
	}
	
	public void cancealReservation() {
		try {
			
		}catch(Exception e) {
			
		}finally{
			closeConnection();
		}
		
		
		
	}
	
	public void reservationRecord() {
		try {
			
		}catch(Exception e) {
			
		}finally {
			closeConnection();
		}
	}
	
	
	
}
