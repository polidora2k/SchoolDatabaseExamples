package com.teksystems.schooldatabase.dao;

import javax.persistence.TypedQuery;

import com.teksystems.schooldatabase.entity.Student;
import com.teksystems.schooldatabase.utilities.DAO;

public class StudentDAO extends DAO{
	public Student findByStudentId(Integer id) {
		init();
		
		String hql = "SELECT s FROM Student s WHERE id = :id";
		TypedQuery<Student> query = session.createQuery(hql, Student.class);
		query.setParameter("id", id);
		Student s = query.getSingleResult();
		
		close();
		
		return s;
	}
}
