package kr.co.softcampus.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.softcampus.beans.ContentBean;

@Repository
public class BoardDao {

	
	@Autowired
	private SqlSessionTemplate boardMapper;
	
	
	public void addContentInfo(ContentBean writeContentBean) {
		boardMapper.selectOne(writeContentBean);			
		
	}
	
	
	public String getBoardInfoName(int board_info_idx) {
		return boardMapper.getBoardInfoName(board_info_idx);
	}
	
	public List<ContentBean> getContentList(int board_info_idx, RowBounds rowBounds){
		return boardMapper.getContentList(board_info_idx, rowBounds);
	}
	
	public ContentBean getContentInfo(int content_idx) {
		return boardMapper.getContentInfo(content_idx);
	}
	
	public void modifyContentInfo(ContentBean modifyContentBean) {
		boardMapper.modifyContentInfo(modifyContentBean);
	}
	
	public void deletecContentInfo(int content_idx) {
		boardMapper.deletecContentInfo(content_idx);
	}
	
	
	public int getContentCnt(int content_board_idx) {
		return boardMapper.getContentCnt(content_board_idx);
	}
	
}
