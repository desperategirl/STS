package com.biz.rbooks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.rbooks.domain.BooksVO;
import com.biz.rbooks.service.BooksService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BooksController {

	@Autowired
	BooksService booksService;


	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert_Get(Model model) {
		
		return "insert";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert_Post(@ModelAttribute BooksVO booksVO, Model model) {

		log.debug(booksVO.toString());
		booksService.insert(booksVO);
		// model.addAttribute("booksInsert", booksVO);
		// 필요없는 이유는 selectAll method를 사용하면 수정된 도서목록을 보여주기 때문임
		return "redirect:/home";
	}

	// delete(삭제) 하는 메뉴를 보여주는 method
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete_Get(BooksVO booksVO) {

		// 필요없을것 같아서 일단 주석처리 booksService.delete(booksVO);
		return "delete";
	}

	// 삭제할 도서목록의 값(VO)을 선택하여 addAttribute로 보냄
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete_Post(@ModelAttribute BooksVO booksVO, Model model) {

		booksService.delete(booksVO);
		model.addAttribute(booksVO);
		return "redirect:/home";
	}

}
