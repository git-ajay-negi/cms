package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="userCourseTable")
public class TutorCourseMap {
	
	public TutorCourseMap() {
		super();
	}

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
		
	private int  tutorId;
	
	private int courseId;
	
	@Temporal(TemporalType.DATE)
	private Date from;
	
	@Temporal(TemporalType.DATE)

	private Date to;
	
	private String session;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTutorId() {
		return tutorId;
	}

	public void setTutorId(int tutorId) {
		this.tutorId = tutorId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public Date getFrom() {
		return from;
	}

	public void setFrom(Date from) {
		this.from = from;
	}

	public Date getTo() {
		return to;
	}

	public void setTo(Date to) {
		this.to = to;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;;
	}

}
