package com.spring.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {
	
	public static void main(String[] args) {
		//1. 스프링 컨테이너 구동
		AbstractApplicationContext container
			= new GenericXmlApplicationContext("applicationContext.xml");
		System.out.println("--- 컨테이너 구동 후 ---");
		
		//2. 스프링 컨테이너 사용
		BoardService boardService = (BoardService) container.getBean("boardService");
		
		//2-1. 입력
		BoardVO vo = new BoardVO();
		vo.setTitle("테스트TX");
		vo.setWriter("홍길동");
		vo.setContent("테스트-내용");
		
		try {
			boardService.insertBoard(vo);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		//데이터 하나 조회(글번호 1번)
		vo.setSeq(1);
		System.out.println("게시글1번 : " + boardService.getBoard(vo));
		
		//전체목록 조회
		List<BoardVO> list = boardService.getBoardList();
		for (BoardVO board : list) {
			System.out.println(board);
		}
		
		//3. 스프링 컨테이너 종료
		container.close();
	}
}
