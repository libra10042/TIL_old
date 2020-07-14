package com.bc.mybatis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// 장바구니 역할 클래스
public class Cart {
	private List<ShopVO> list; //카트에 담긴 제품 목록
	private int total; // 카트에 담긴 전체 품목의 가격 합계 금액
	
	public Cart() {
		list = new ArrayList<ShopVO>();
	}

	/** 장바구니에 담기 요청 처리(카트에 제품 추가)
	 *	list에 없으면 제품추가
	 *  list에 동일한 제품이 있으면 수량 1개 증가 처리
	 */
	public void addProduct(String p_num, ShopDAO dao) {
		//카트에 제품이 있는지 확인
		ShopVO vo = findProduct(p_num);
		if (vo == null) { //카트에 없음 : 제품을 카트에 등록
			vo = dao.selectOne(p_num); //1. p_num DB 조회해서 VO객체 생성
			vo.setQuant(1); //2. VO객체의 수량 1 설정
			list.add(vo); //3. 카트목록(list)에 추가
			total += vo.getP_saleprice(); //4. total 값 재계산(제품 하나 가격 추가)
		} else { //카트에 있음 -> 수량 1증가 처리 + total 재계산
			vo.setQuant(vo.getQuant() + 1); //수량 1 증가 처리
			// total 재계산 : 기존 금액 + 새로추가된 제품 1개 판매가격
			total = total + vo.getP_saleprice();
		}
	}
	
	// 카트에 제품이 있는지 확인(있으면: VO리턴, 없으면: null 리턴)
	public ShopVO findProduct(String p_num) {
		ShopVO vo = null;
		Iterator<ShopVO> ite = list.iterator();
		while (ite.hasNext()) {
			ShopVO listVO = ite.next();
			if (listVO.getP_num().equals(p_num)) {
				vo = listVO;
				break;
			}
		}
		//(개인별로 실습) 위의 처리를 개선된 for문 형태로 구현
		
		return vo;
	}
	
	//제품수량 변경 처리
	public void setQuant(String p_num, int su) {
		ShopVO vo = findProduct(p_num);
		if (vo == null) return;
		//1. 변경전 카트합계금액 - 수량변경전 수정할제품합계금액
		total = total - vo.getTotalprice();
		//2. 제품 수량 변경
		vo.setQuant(su);
		//3. 카드 합계금액 + 수량변경된 제품합계금액
		total = total + vo.getTotalprice();
	}
	
	//카트에서 제품 삭제(꺼내기)
	public void delProduct(String p_num) {
		ShopVO vo = findProduct(p_num);
		if (vo != null) {
			list.remove(vo);
			
			//카트 합계금액에서 제품 금액 빼기
			total = total - vo.getTotalprice();
		}
	}
	
	public List<ShopVO> getList() {
		return list;
	}
	public int getTotal() {
		return total;
	}
	
}










