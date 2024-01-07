package com.SpringSecurityBasics.SecurityBasics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import models.Todo;

@Service
public class MyTodoService {
	
	@Autowired
	TodoRepository todoRepository;

	public List<Todo> UserSpecificTodos(int user_id){
		return todoRepository.findByAuthorId(user_id);
	}
	
	public void addTodos(Todo todo) {
		
		todoRepository.save(todo);
	}
}
