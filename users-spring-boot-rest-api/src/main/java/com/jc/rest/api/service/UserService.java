package com.jc.rest.api.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jc.rest.api.repository.UserRepository;
import com.jc.rest.api.model.UserModel;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	public ArrayList<UserModel> getAllUsers() {
		return (ArrayList<UserModel>) userRepository.findAll();
	}
	
	public Optional<UserModel> getUserById(Long userId) {
		return userRepository.findById(userId);
	}
	
	public ArrayList<UserModel> getUsersByPriority(Integer priority) {
		return userRepository.findByPriority(priority);
	}
	
	public UserModel createUser(UserModel user) {
		return userRepository.save(user);
	}
	
	public Optional<UserModel> updateUser(Long userId, UserModel user) {
		return userRepository.findById(userId).map(u -> {
			u.setEmail(user.getEmail());
			u.setPriority(user.getPriority());
			return userRepository.save(u);
		});
	}
	
	public boolean deleteUser(Long userId) {
		try {
			userRepository.deleteById(userId);
			return true;
		}
		catch(Exception ex) {
			return false;
		}
	}
}