package com.biz.rbooks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.rbooks.domain.BooksVO;
import com.biz.rbooks.repository.BooksDao;

// 도서정보 테이블을 위한 서비스 클래스
@Service
public class BooksService {

	BooksDao booksDao;

	@Autowired
	public BooksService(BooksDao booksDao) {
		super();
		this.booksDao = booksDao;
	}
	
	// 도서 VO를 모두 조회
	public List<BooksVO> selectAll() {
		return booksDao.viewBooks();
	}

	// 새로운 도서 VO 업데이트 
	public int insert(BooksVO booksVO) {
		return booksDao.insertBooks(booksVO);
	}

	// VO로 저장된 도서목록 값들 중 b_code를 조회하여 맞는 도서를 찾아 삭제
	public int delete(BooksVO b_code) {
		return booksDao.deleteBooks(b_code);
	}

	
	
	
}
