package com.prog.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prog.entity.User;
import com.prog.entity.UserRole;
import com.prog.helper.UserFoundException;
import com.prog.repo.RoleRepository;
import com.prog.repo.UserRepository;
import com.prog.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	//Creating User
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		User local = this.userRepository.findByUserName(user.getUserName());
		if(local!=null) {
			System.out.println("User already exist!!");
			throw new UserFoundException();
		}
		else {
			//create user
			for(UserRole urole:userRoles) {
				roleRepository.save(urole.getRole());
			}
			user.getUserRoles().addAll(userRoles);
			local = this.userRepository.save(user);
		}
		return local;
	}
	
	
	//Getting User by userName
	@Override
	public User getUser(String userName) {
		// TODO Auto-generated method stub
		return this.userRepository.findByUserName(userName);
	}
	//Get User by Id
	@Override
	public Optional<User> fetchEmployeeById(Long id) {
		// TODO Auto-generated method stub
		return this.userRepository.findById(id);
	}


	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		this.userRepository.deleteById(id);
	}


	@Override
	public User updateUser(Long id, User user) {
		User editUser = this.userRepository.findById(id).get();
		editUser.setFirstName(user.getFirstName());
		//editUser.setPassword(user.getPassword());
		//editUser.setPhone(user.getPhone());
		
		return this.userRepository.save(editUser);
	}
	@Override
	public List<User> getAllUsers(){
		return this.userRepository.findAll();
	}

	
}
