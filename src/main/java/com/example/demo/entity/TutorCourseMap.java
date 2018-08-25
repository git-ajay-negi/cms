package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="userCourseTable")
public class TutorCourseMap {
	
	public TutorCourseMap() {
		super();
	}

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
		
	/*private int  tutorId;
	
	private int courseId;*/
	
	/*@Temporal(TemporalType.DATE)
	private Date from;
	
	@Temporal(TemporalType.DATE)

	private Date to;
	*/
	
	@ManyToOne(fetch = FetchType.LAZY)
	   @JoinColumn(name="tutorId")
@JsonIgnore
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)	
	   @JoinColumn(name="courseId")
	@JsonIgnore

	private Course course;
	private String period;
	private String session;
	
	@Transient
	private int cId;
	
	@Transient
	private int tId;
	

	public int getcId() {
		if(this.course!=null)
		return course.getId();
		else return 0;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public int gettId() {
		if(this.user!=null)
			return user.getId();
			else return 0;	}

	public void settId(int tId) {
		this.tId = tId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/*public int getTutorId() {
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

*/	/*public Date getFrom() {
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
	}*/

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

}
