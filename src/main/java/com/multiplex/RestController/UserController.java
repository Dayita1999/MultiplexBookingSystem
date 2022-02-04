package com.multiplex.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.multiplex.Exceptions.UserAlreadyExistsException;
import com.multiplex.Exceptions.UserNotFoundException;
import com.multiplex.Model.User;
import com.multiplex.Service.IUserService;
@RestController
@RequestMapping("/users") //method=RequestMethod.GET)
public class UserController {

	public UserController() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	IUserService userService;
	
	@PostMapping("/addUserDetails")
	//@RequestMapping(value="/addUserDetails",method=RequestMethod.GET)
	public ResponseEntity<User> addUserDetails(@Validated @RequestBody User user) throws UserAlreadyExistsException,UserNotFoundException {
		
		System.out.println(user);
		User us = userService.addUserDetails(user);
		return new ResponseEntity<User>(us,HttpStatus.OK);
		//return userService.addUserDetails(user);
	}
}
	