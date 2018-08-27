package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
		
	private String role="Tutor";
	
	public Role(String role) {
		super();
		this.role = role;
	}



	//@OneToOne(mappedBy="role",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@OneToMany(mappedBy="role")
	private List<User> user;
	
	
	
	public Role() {
		
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}


	
	
	
	
	
	
	
}
