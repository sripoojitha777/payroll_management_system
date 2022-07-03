package com.prog.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.prog.entity.User;
import com.prog.entity.UserRole;

public interface UserService {
	//Creating User
	public User createUser(User user,Set<UserRole> userRoles) throws Exception;
	//Get User 
	public User getUser(String userName);
	//Delete by userName
	public void deleteUser(Long id);
	//Update User
	public User updateUser(Long id,User user);
	//all users
	public List<User> getAllUsers();
	//get User By id
	public Optional<User> fetchEmployeeById(Long id);

}

