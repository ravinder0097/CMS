package com.mindtree.CMS.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.CMS.model.User;
import com.mindtree.CMS.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "user")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/greet", method = RequestMethod.GET)
	@ApiOperation(value = "Gets All the Available User Details")
	public String getGreeting() {
		return "Welcome back";
	}

	@RequestMapping(value = "/overview", method = RequestMethod.GET)
	@ApiOperation(value = "Gets All the Available User Details")
	public List<User> getAllUsers() {
		logger.trace("Entering getAllUsers");
		return userService.getAllUsers();

	}

	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	@ApiOperation(value = "GEts User by given id")
	public User getUser(@RequestParam(required = true) long userId) {
		logger.trace("Entering getUser");
		return userService.getUser(userId);
	}

}
