package com.SpringSecurityBasics.SecurityBasics;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import models.User;


public interface UserRepository extends JpaRepository<User, Integer>{
	
	 Optional<User> findByUserName(String userName);

}
