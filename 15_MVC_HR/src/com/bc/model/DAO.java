package com.bc.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.bc.model.vo.EmployeeVO;
import com.bc.mybatis.DBService;

public class DAO {

	//직원 전체 목록 조회
	public static List<EmployeeVO> getList() {
		SqlSession ss = DBService.getFactory().openSession();
		List<EmployeeVO> list = ss.selectList("HR.list");
		ss.close();
		return list;
	}
	
	//직원 전체 목록 조회
	public static List<EmployeeVO> getDept(String deptno) {
		SqlSession ss = DBService.getFactory().openSession();
		List<EmployeeVO> list = ss.selectList("HR.deptList", deptno);
		ss.close();
		return list;
	}

	public static List<EmployeeVO> getFullnameList(String fullname) {
		SqlSession ss = DBService.getFactory().openSession();
		List<EmployeeVO> list = ss.selectList("HR.fullnameList", fullname);
		ss.close();
		return list;
	}

	public static List<EmployeeVO> getSearch(String idx, String keyword) {
		SqlSession ss = DBService.getFactory().openSession();
		Map<String, String> map = new HashMap<>();
		map.put("idx", idx);
		map.put("keyword", keyword);
		List<EmployeeVO> list = ss.selectList("HR.search", map);
		ss.close();
		return list;
	}
	
	public static List<EmployeeVO> getSearchTest(String idx, String keyword) {
		SqlSession ss = DBService.getFactory().openSession();
		String mapperId = "";
		if ("0".equals(idx)) {
			mapperId = "HR.search0";
		} else if ("1".equals(idx)) {
			mapperId = "HR.search1";
		} 
		List<EmployeeVO> list = ss.selectList(mapperId, keyword);
		ss.close();
		return list;
	}


}












