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
	
	// con, pstmt, rs 객체 닫기 
	public void closeConnection() {
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(con!=null) con.close(); 
		}catch(SQLException e) {
			
		}
	}
	
	
	//신규 고객등록. 
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
	
	// 기존방문 고객 조회
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
					 System.out.println(rs.getString("clname") + " 님의" + " 고객번호는 " + rs.getString("clnumber") + "입니다.");
					 System.out.println("------------------------");
				 }while(rs.next());
				 
			}else {
				System.out.println("고객 정보가 없습니다.");
			}
			
		}catch(Exception e) {
			
		}finally {
			closeConnection();
		}
		
		
		return flag;
	}
	
	// 고객 핸드폰 번호로 고객번호 조회.
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
				System.out.println("등록된 고객님의 번호는 " + rs.getInt("CLNUMBER") + "입니다.");
			}else {	
				System.out.println("등록된 고객 데이터가 없습니다.");
				return flag; 
			}
			
			
		}catch(Exception e) {
			
		}finally {
			closeConnection();
		}
		
		return flag; 
	}
	
	
	
	//고객 전화번호를 수정한다. (고객 이름과 고객 주민번호를 입력한다.)
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
	
	//고객 번호를 찾는다.
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
					System.out.println(rs.getString("clname") + "님이 분실하신  고객번호는 " + rs.getInt("clnumber") +"입니다.");
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
	
	//개인 고객번호를 통해 예약 조회 하기.
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
