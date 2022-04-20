package com.jc.rest.api.controller;

import java.util.ArrayList;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jc.rest.api.model.UserModel;
import com.jc.rest.api.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/users")
	public UserModel createUser(@Valid @RequestBody UserModel user) {
		return userService.createUser(user);
	}
	
	@GetMapping("/users")
	public ArrayList<UserModel> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/users/{userId}")
	public Optional<UserModel> getUserById(@PathVariable(name = "userId") Long userId) {
		return userService.getUserById(userId);
	}

	@GetMapping("/users/query")
	public ArrayList<UserModel> getUsersByPriority(@RequestParam("priority") Integer priority) {
		return userService.getUsersByPriority(priority);
	}
	
	@PutMapping("/users/{userId}")
	public Optional<UserModel> updateUser(@PathVariable(name = "userId") Long userId, @Valid @RequestBody UserModel user) {
		return userService.updateUser(userId, user);
	}
	
	@DeleteMapping("/users/{userId}")
	public String deleteUser(@PathVariable(name = "userId") Long userId) {
		if(userService.deleteUser(userId) == true) {
			return "User deleted successfully!";
		}
		else {
			return "User with id: " + userId + " was not deleted!";
		}
	}
}