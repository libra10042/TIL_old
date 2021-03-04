use miniproject;

create sequence user_seq
start with 0
increment by 1
minvalue 0;

create sequence content_seq
start with 0
increment by 1
minvalue 0;

create table board_info_table(
	board_info_idx INT, 
	board_info_name VARCHAR(500) not null,
    PRIMARY KEY (board_info_idx)
);


insert into board_info_table(board_info_idx, board_info_name) values (1, '자유게시판');
insert into board_info_table(board_info_idx, board_info_name) values (2, '유머게시판');
insert into board_info_table(board_info_idx, board_info_name) values (3, '정치게시판');
insert into board_info_table(board_info_idx, board_info_name) values (4, '스포츠게시판');

commit;

create table user_table(
	user_idx INT auto_increment,
	user_name VARCHAR(50) not null,
	user_id VARCHAR(100) not null,
	user_pw VARCHAR(100) not null,
    PRIMARY KEY (user_idx)
);


create table content_table(
	content_idx INT,
	content_subject VARCHAR(500) not null,
	content_text long not null,
	content_file VARCHAR(500),
	content_writer_idx INT not null,
	content_board_idx INT not null,
	content_date date not null,
    PRIMARY KEY (content_idx),
    FOREIGN KEY CONTENT_FK1 REFERENCES user_table (user_idx),
    FOREIGN KEY CONTENT_FK2 REFERENCES board_info_table (board_info_idx)
);

