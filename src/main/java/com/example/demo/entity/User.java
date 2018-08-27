package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String name;

	public User(String name, String userName, String password, Role role) {
		super();
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.role = role;
	}

	private String userName;

	private String password;
	
	//@OneToOne(fetch=FetchType.EAGER)
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="roleId")
	private Role role;

	/*@ManyToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(name="user_course",joinColumns=@JoinColumn(name="userId"),inverseJoinColumns=@JoinColumn(name="courseId"))
	private List<Course> courses;*/
	
	
	@OneToMany(mappedBy="user",fetch=FetchType.LAZY)
	List<TutorCourseMap>tutCourses;
	
	public User() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	

}
