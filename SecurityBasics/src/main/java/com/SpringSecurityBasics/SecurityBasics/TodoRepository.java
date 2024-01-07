package com.SpringSecurityBasics.SecurityBasics;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import models.Todo;


public interface TodoRepository extends JpaRepository<Todo, Integer> {
	
	public List<Todo> findByAuthorId(int userid);

}
