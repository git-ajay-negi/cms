package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="courseId")
	private int id;
		
	private String courseName;
	
	public Course(String courseName, String courseCode, List<Topic> topics) {
		super();
		this.courseName = courseName;
		this.courseCode = courseCode;
		this.topics = topics;
	}
	
	public Course() {
		
	}


	private String courseCode;
	
	/*@ManyToMany(mappedBy="courses")
	private List<User>users;*/
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="course")
	private List<Topic> topics;

	@OneToMany(mappedBy="course",fetch=FetchType.LAZY)
	List<TutorCourseMap>tutCourses;
	
	public List<TutorCourseMap> getTutCourses() {
		return tutCourses;
	}

	public void setTutCourses(List<TutorCourseMap> tutCourses) {
		this.tutCourses = tutCourses;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}
	
	
	
	
	
	
}
