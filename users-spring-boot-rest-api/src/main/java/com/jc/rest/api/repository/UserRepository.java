package com.jc.rest.api.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jc.rest.api.model.UserModel;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {
	
	public abstract ArrayList<UserModel> findByPriority(Integer priority);
}