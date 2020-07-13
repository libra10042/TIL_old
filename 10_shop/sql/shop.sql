CREATE TABLE shop_t	(
	num			 number(4)		Not Null, --시퀀스 번호
	category	 varchar2(10)	Not Null, --품목구분(컴퓨터:com001, 가전제품:ele002, 스포츠:sp003)
	p_num		 varchar2(10)	Not Null, --제품번호
	p_name		 varchar2(50)	Not Null, --제품명
	p_company    varchar2(50)	Not Null, --제조사(판매사)
	p_price		 number(4)		Not Null, --판매가격
	p_saleprice  number(4)		Not Null, --판매가격(할인적용된)
	p_image_s	 varchar2(50)	Null,     --사진이미지(작은)
	p_image_l	 varchar2(50)	Null,     --사진이미지(큰)
	p_content	 varchar2(4000)	Not Null, --제품상세정보
	p_date		 date			Not Null  --제품 등록일
);

create sequence shop_num
increment by 1
start with 1
nocache;

insert into shop_t 
       (num, category, p_num, p_name, p_company
     , p_price, p_saleprice, p_image_s, p_image_l
     , p_content
     , p_date)
values (shop_num.nextVal, 'sp003', 'RC-113', '로체스 인라인', '로체스'
     , 3200, 1150, 'pds1.jpg', 'pds1_z.jpg'
     , '바이오맥스 통풍 나일론-HGPU SHELL * 특수 충격 흡수 밑창 * 신발끈 메모리 버클 * 힐 락에 의한 신속한 신발끈 시스템 * 느린 메모리 포말에 의한 편안한 통풍성의 숨쉬는 라이너 * 쿨 통풍 시스템 * 통풍성의 인체공학적 신발밑창 * 손쉬운 엔트리 시스템(신기 편한 입구) * 몰디드 알루미늄 프레임 * 80mm 82a hyper dubbs 휠 * 강철 스페이서 * ABEC-5 베어링'
     , sysdate);

insert into shop_t 
       (num, category, p_num, p_name, p_company
     , p_price, p_saleprice, p_image_s, p_image_l
     , p_content
     , p_date)
values (shop_num.nextVal, 'ele002', 'vC-13', '사니PDP-TV', '사니'
     , 9200, 4750, 'pds4.jpg', 'pds4_z.jpg'
     , '질러~ 질러! 무조건 질러봐~ 후회 하지 않아~~'
     , sysdate);

commit;

---------------------------------------------------------------
-- 추가 데이터
insert into shop_t 
       (num, category, p_num, p_name, p_company
     , p_price, p_saleprice, p_image_s, p_image_l
     , p_content
     , p_date)
values (shop_num.nextVal,'sp003', 'RC-500', '로체스헬멧', '로체스'
     , 2000, 1000, 'pds3.jpg', 'pds3_z.jpg'
     , '가볍고 튼튼한 소재와 통풍이 잘되는 구조로 안전과 쾌적함을 한 번에~~~'
     , sysdate);
     
insert into shop_t 
       (num, category, p_num, p_name, p_company
     , p_price, p_saleprice, p_image_s, p_image_l
     , p_content
     , p_date)
values (shop_num.nextVal,'sp003', 'RC-501', '로체스헬멧2', '로체스'
     , 2500, 1100, 'pds3.jpg', 'pds3_z.jpg'
     , '특수강화소재, 가볍고 튼튼한 소재와 통풍이 잘되는 구조로 안전과 쾌적함을 한 번에~~~'
     , sysdate);

commit;
