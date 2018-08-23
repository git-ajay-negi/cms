package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="topic")
public class Topic {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
		
	private String topicName;
	
	private String topicCode;
	
	private String topicContent;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="courseId")
	private Course course;
	
	public Topic() {
		
	}

	public Topic(String topicName, String topicCode, String topicContent,Course course) {
		super();
		this.topicName = topicName;
		this.topicCode = topicCode;
		this.topicContent = topicContent;
		this.course=course ;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public String getTopicCode() {
		return topicCode;
	}

	public void setTopicCode(String topicCode) {
		this.topicCode = topicCode;
	}

	public String getTopicContent() {
		return topicContent;
	}

	public void setTopicContent(String topicContent) {
		this.topicContent = topicContent;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	
	
	
	
	
	
}
