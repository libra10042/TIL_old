package kr.co.softcampus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import kr.co.softcampus.beans.BoardInfoBean;

public interface TopMenuMapper {
	
	@Select("select board_info_idx, board_info_name " + 
			"from board_info_table " +
			"ORDER BY board_info_idx")
	List<BoardInfoBean> getTopMenuList();
	
}
