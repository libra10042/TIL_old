package kr.co.softcampus.database;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import kr.co.softcampus.beans.DataBean;

public interface MapperInterface {

	@Insert("insert into spring_mvc_table (data1, data2, data3) values (#{data1}, #{data2}, #{data3})")
	void insert_data(DataBean dataBean);
	
	
	@Select("select data1, data2, data3 from spring_mvc_table")
	List<DataBean> select_data(); 
	
}
