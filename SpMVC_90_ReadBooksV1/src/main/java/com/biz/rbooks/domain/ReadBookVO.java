package com.biz.rbooks.domain;



public class ReadBookVO {

	// 독서록 테이블 명세
	
	public int rb_seq; //	number	not null	primary key 일련번호
	public String rb_bcode; //	varchar2(20)	not null 도서코드	
	public String rb_date; //	varchar2(10)	not null  독서시작날짜
	public String rb_stime; //	varchar2(10)		독서시작시각
	public int rb_rtime; //	number(10,3)		독서시간
	public String rb_subject; //	nvarchar2(20)		한줄소감
	public String rb_text; //	nvarchar2(400)		긴줄소감
	public int rb_star; //	number		독서느낌(별점)

}
