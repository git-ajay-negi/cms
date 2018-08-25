package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.TutorCourseMap;

public interface CalendarRepository extends CrudRepository<TutorCourseMap, Integer> {

}
