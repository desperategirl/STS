package com.biz.rbooks.repository;

import org.apache.ibatis.annotations.Select;

import com.biz.rbooks.domain.MemberVO;
import com.biz.rbooks.domain.ReadBookVO;


// tbl_read_book 테이블에 저장된 정보가 (보기 좋게) 나오게 만들기 위한 interface
// 독서록 CRUD를 위한 interface

// 해당 도서를 읽은 횟수가 여러번일 경우 도서 정보 아래에 읽은 정보에 대하여 리스트가 하단에 나타남. 

// 하단에 나타난 리스트를 클릭하면 해당 독서 정보에 대하여 자세히 보기 화면이 나타남.
// 독서록 기록, 자세히보기는 반드시 로그인을 해야만 가능
public interface ReadBookDao {
	
	
	@Select("SELECT * FROM tbl_read_book")
	public ReadBookVO viewReadBook();
	
	@Select("SELECT * FROM tbl_user WHERE u_id = #{u_id}")
	public MemberVO findById(String u_id);
	

}
