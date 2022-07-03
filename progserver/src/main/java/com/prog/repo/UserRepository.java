package com.prog.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prog.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	public User findByUserName(String userName);
	
}
