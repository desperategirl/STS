package com.biz.rbooks.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;

import com.biz.rbooks.domain.BooksVO;

//tbl_books에 저장된 정보가 (보기 좋게) 나오게 하기 위한 interface
public interface BooksDao {
	
	// 도서정보 조회를 위한 method
	@Select("SELECT * FROM tbl_books")
	public List<BooksVO> viewBooks();

	// 도서정보 추가를 위한 method
	@InsertProvider(type=BooksSQL.class, method="booksInsert_sql")
	public int insertBooks(BooksVO booksVO);

	// 도서정보 삭제를 위한 method
	@Delete("DELETE * FROM tbl_books;")
	public int deleteBooks(BooksVO booksVO);
	
	
	
	
	

}
