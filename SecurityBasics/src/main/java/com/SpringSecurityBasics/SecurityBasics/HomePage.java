package com.SpringSecurityBasics.SecurityBasics;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import models.AuthenticationRequest;
import models.AuthenticationResponse;
import models.Todo;
import models.User;
import util.JwtUtil;


@RestController
public class HomePage {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private MyUserDetailsService userDtailsService;
	
	@Autowired
	private JwtUtil jwtTokenUtil;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	MyTodoService myTodosService;
	
	

	@GetMapping("/hello")
	public String Home() {
		return "Hello";
	}
	
	@RequestMapping(value = "/todos/user/{user_id}" , method = RequestMethod.GET)
	public List<Todo> getUserSpecificTodos(@PathVariable int user_id) {
		return myTodosService.UserSpecificTodos(user_id) ;
	}
	
	@RequestMapping(value = "/addtodos/user" , method = RequestMethod.POST)
	public void addUserSpecificTodos(@RequestBody Todo todo) {
		myTodosService.addTodos(todo) ;
	}
	
	@RequestMapping(value = "/authenticate" , method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
		
		try {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword()));
		}catch(BadCredentialsException e) {
			
			throw new Exception("Incorrect username or password",e);
		}
		
		final UserDetails userDetails =  userDtailsService.loadUserByUsername(authenticationRequest.getUsername());
		
		Optional<User> user =  userRepo.findByUserName(authenticationRequest.getUsername());
		int usop = user.map(User::getId).get();
		System.out.println(usop);
		
		
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new AuthenticationResponse(jwt,usop));
	
	}
}






