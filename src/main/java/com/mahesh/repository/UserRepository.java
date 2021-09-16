package com.mahesh.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mahesh.binding.UserRegForm;
import com.mahesh.entity.User;

public interface UserRepository extends JpaRepository<User, Serializable> {
	
	public User findByEmail(String email);

	public boolean save(UserRegForm userRegForm);

	public User findByEmailAndTempPassword(String email, String tempPassword);

	
	
}
