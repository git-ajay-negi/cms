package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;

public interface RoleRepository extends CrudRepository<Role, Integer> {

	public List<Role> findByRole(@Param("role")String role);
}
