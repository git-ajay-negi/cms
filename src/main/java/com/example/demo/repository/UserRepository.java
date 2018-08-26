package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	public List<User> findByRole(@Param("role")Role role);
	
	public List<User> findByUserNameAndPassword(@Param("userName")String userName,@Param("password")String password);

}
