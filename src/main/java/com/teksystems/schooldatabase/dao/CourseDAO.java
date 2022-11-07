package com.teksystems.schooldatabase.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import com.teksystems.schooldatabase.entity.Course;
import com.teksystems.schooldatabase.utilities.DAO;

public class CourseDAO extends DAO{
	
	public List<Course> findCourses() {
		init();
		
		String hql = "FROM Course";
		TypedQuery<Course> query = session.createQuery(hql, Course.class);
		List<Course> results = query.getResultList();
		
		close();
		
		return results;
	}
	
	public Course findCourseById(Integer id) {
		init();
		
		String hql = "SELECT c FROM Course c WHERE id = :id";
		TypedQuery<Course> query = session.createQuery(hql, Course.class);
		query.setParameter("id", id);
		Course c = query.getSingleResult();
		
		close();
		
		return c;
	}
	
	public List<Course> findByCourseName(String name) {
		init();

		String hql = "SELECT c FROM Course c WHERE c.name = :name";

		TypedQuery<Course> query = session.createQuery(hql, Course.class);
		query.setParameter("name", name);

		List<Course> result = query.getResultList();

		close();

		return result;
	}
	
	public List<Course> findByCourseNameStartsWith(String word) {
		init();
		
		String pattern = word + "%";

		String hql = "SELECT c FROM Course c WHERE c.name LIKE :pattern";

		TypedQuery<Course> query = session.createQuery(hql, Course.class);
		query.setParameter("pattern", pattern);

		List<Course> result = query.getResultList();

		close();

		return result;
	}
	
	public void update(Course course) {
		init();
		
		session.merge(course);
		
		close();
	}
	
	public void insert(Course course) {
		init();
		
		session.save(course);
		
		close();
	}
}
