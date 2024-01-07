package com.SpringSecurityBasics.SecurityBasics;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import models.User;


@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepo;
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		//return new MyUserDetails(userName);
		Optional<User> user =  userRepo.findByUserName(userName);
		
		
		user.orElseThrow(() -> new UsernameNotFoundException("Not found :" +userName));
		
		return user.map(MyUserDetails::new).get();
	}

}
