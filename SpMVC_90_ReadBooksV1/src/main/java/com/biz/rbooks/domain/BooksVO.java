package com.biz.rbooks.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class BooksVO {
	
	// 도서정보 테이블 명세
	
	public String b_code; //	varchar2(20)		primary key 도서코드
	public String b_name; //	nvarchar2(125)	not null	도서명
	public String b_auther; //	nvarchar2(125)	not null	저자
	public String b_comp; //	nvarchar2(125)		출판사
	public String b_year; //	varchar2(10)	구입일자	
	public int b_iprice; //	number	구입가격
	

}
