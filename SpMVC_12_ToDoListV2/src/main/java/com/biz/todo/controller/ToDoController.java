package com.biz.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.biz.todo.domain.ToDoList;
import com.biz.todo.service.ToDoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ToDoController {
	
	@Autowired
	@Qualifier ("toDoServiceV2")
	ToDoService toService;
	
    @RequestMapping(value="list", method=RequestMethod.GET)
	public String list(Model model) {
		/*
		 * 팀 프로젝트에서 Controller 개발자와, Service 개발자가 다를 경우
		 * Service는 interface가 정의되어 있기 때문에
		 * 아직 기능은 구현되지 않았어도
		 * Controller 개발자는 당연히 Service의 method를 호출하면
		 * 결과가 리턴 될 것이다 라는 것을 알고
		 * 나머지 코드를 구현할 수 있게 된다.
		 */
		
		List<ToDoList> todoList = toService.selectAll();
		model.addAttribute("todoList", todoList);
		return "home";
	}
    
    @RequestMapping(value="list", method=RequestMethod.POST)
    public String insert(@ModelAttribute ToDoList toDoList,
    				Model model) {
    	
    	int ret = toService.insert(toDoList);
    	if(ret < 1) {
    		model.addAttribute("INSERT_ERROR", "NOT INSERT");
    	}
    	
    	return "redirect:/list";
    }
    
    public String delete(
    		@RequestParam("tdSeq") String strSeq) {
    	try {
    		long tdSeq = Long.valueOf(strSeq);
		} catch (Exception e) {
			log.debug("삭제 오류");
			// TODO: handle exception
		}
    	return "redirect:/list";
    }
    
    @RequestMapping(value="update", method=RequestMethod.GET)
    public String update(
    		@RequestParam("td_seq")
    		String strSeq, Model model) {
    	
    	long tdSeq = Long.valueOf(strSeq);
    	
    	ToDoList toDTO = toService.findBySeq(tdSeq);
    	model.addAttribute("todoDTO",toDTO);
    	
    	List<ToDoList> tdList = toService.selectAll();
    	model.addAttribute("todoList",tdList);
    	
    	return "home";
    }
    
    @RequestMapping(value="update", method=RequestMethod.POST)
    public String update(ToDoList toList, Model model) {
    	
    	toService.update(toList);
    	return "redirect:/list";
    }

}
