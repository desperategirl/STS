package com.biz.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.todo.domain.ToDoList;
import com.biz.todo.repository.ToDoListDao;

@Service("toDoServiceV2")
public class ToDoServiceV2 extends ToDoServiceV1 {
	
	@Autowired
	ToDoListDao toDao;
	
	@Override
	public int insert(ToDoList toDoList) {
		return toDao.insert(toDoList);
	}

	@Override
	public int update(ToDoList toDoList) {
		
		if(toDoList.getTd_alarm() == null) {
			toDoList.setTd_alarm("N");
		}
		if(toDoList.getTd_complete() == null) {
			toDoList.setTd_complete("N");
		}
		return toDao.update(toDoList);
	}

	@Override
	public int delete(long tdSeq) {
		return toDao.delete(toDoList);
	}

	@Override
	public int complete(String strSeq) {
		long tdSeq = Long.valueOf(strSeq);
		return toDao.complete(tdSeq);
	}
	
	@Override
	public int alarm(String strSeq)
	

}
