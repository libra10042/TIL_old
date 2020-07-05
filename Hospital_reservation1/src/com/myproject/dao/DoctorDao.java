package com.myproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.myproject.vo.Doctor;
import com.myproject.vo.Doctor_Schedule;
import com.myproject.vo.Part;
import com.myproject.vo.Reserve;

public class DoctorDao  {
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
	
	public boolean selectDoctor(Part vo) {
		boolean flag = false; 
		try {
			con = ConnectionManager.getConnection();
			StringBuilder sb = new StringBuilder(); 
			sb.append("SELECT D.DONUMBER, P.PARTNAME, D.DONAME, D.INFO_DOCTOR \n");
			sb.append("FROM DOCTOR D, PART P \n");
			sb.append("WHERE D.PARTNUMBER = P.PARTNUMBER  AND D.PARTNUMBER = ?");
			
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, vo.getPartnumber());
			
			rs = pstmt.executeQuery(); 
			
			if(rs.next()) {
				System.out.println("[담당의 정보]");
				System.out.println("--------------------");
				do {
					flag = true; 
					System.out.println("번호 : " + rs.getInt("DONUMBER") +", 부서명 : " + rs.getString("PARTNAME") + ", 의사이름 :" + rs.getString("DONAME"));
				}while(rs.next()); 
					
			}else {
				System.out.println("*** 다시 선택해주세요.");
			}
			System.out.println("--------------------");
		}catch(Exception e) {
		
		}finally{
			closeConnection();
		}
		return flag; 
	}

	
	
	
	
	
	public void doctorReservationRecord(Reserve vo) {
		try {
			con = ConnectionManager.getConnection();
			StringBuilder sb = new StringBuilder(); 
			sb.append("SELECT R.RENUMBER, R.DONUMBER, R.DONAME, R.CLNUMBER, R.CLNAME, R.SYMPTOM, TO_CHAR(R.SCHEDULE, 'YYYY/MM/DD') AS DT, C.CLPHONE  \n");
			sb.append("FROM RESERVE R JOIN CLIENTS C ON R.CLNUMBER = C.CLNUMBER \n");
			sb.append("WHERE R.DONUMBER =? AND R.SCHEDULE >= SYSDATE-1 \n");
			sb.append("order by r.schedule ");
			
			pstmt = con.prepareStatement(sb.toString());
			
			pstmt.setInt(1, vo.getDonumber());
			
			
			rs = pstmt.executeQuery(); 
			
			if(rs.next()) {
				do {
					System.out.println("----------------------");
					System.out.println("예약번호 : " + rs.getString("RENUMBER") + " ");
					System.out.println("담당의 : " + rs.getString("DONAME") + "\n");
					System.out.println("고객번호 : " + rs.getString("CLNUMBER") + "\n");
					System.out.println("고객이름 : " + rs.getString("CLNAME")+"\n");
					System.out.println("증상 : " + rs.getString("SYMPTOM") + "\n");
					System.out.println("예약날짜 " + rs.getString("DT") + "\n");
					System.out.println("고객 전화 번호 :" + rs.getString("CLPHONE") + "\n");
					System.out.println("----------------------");
					
				}while(rs.next());
			}else {
				System.out.println("예약내역이 없습니다.");
			}
			
			
			
			
		}catch(Exception e) {
			
		}finally {
			closeConnection();
		}
	}
//	
//	public ArrayList<Doctor> introduceDoctorInfo() {
//		ArrayList<DoctorInfo> doctorList = new ArrayList<DoctorInfo>();
//		
//		try {	
//			con = ConnectionManager.getConnection();
//			String sql = "select donumber, partnumber, doname from doctor"; 
//			pstmt = con.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			while(rs.next()) {
//				int donumber = rs.getInt(1);
//				int partnumber = rs.getInt(2);
//				String doname = rs.getString(3);
//				
//				
//				DoctorInfo vo = new DoctorInfo();
//				vo.setDonumber(donumber);
//				vo.setPartnumber(partnumber);
//				vo.setDoname(doname);
//				
//			}
//		}catch(Exception e) {
//			
//		}finally {
//			closeConnection();
//		}
//	}

}
