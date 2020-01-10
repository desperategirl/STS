package com.biz.rbooks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.rbooks.domain.BooksVO;
import com.biz.rbooks.service.BooksService;

@Controller
public class HomeController {

	@Autowired
	BooksService booksService;

	// 독서록의 홈 화면.
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String selectAll(Model model) {

		// 그 인스턴스를 BooksService에 있는 selectAll 메서드로 모두 보이게 해서
		// BooksVO의 리스트의 인스턴스 booksVO에 담은 다음
		// booksSelectAll이라는 이름의 booksVO 인스턴스를 addAttribute 메서드로 처리하고
		// 그 값을 Model 클래스의 인스턴스 model로 받아 home으로 보낸다 		
		List<BooksVO> booksVO = booksService.selectAll();
		model.addAttribute("booksSelectAll", booksVO);
		return "home";
	}
	
	// 독서록의 홈 화면에서 새로운 도서 추가등록과 로그인, 로그아웃, 회원가입, 독서록 작성이 가능하다.
	// home의 리스트를 클릭하면 수정과 삭제가 가능하다.
}
