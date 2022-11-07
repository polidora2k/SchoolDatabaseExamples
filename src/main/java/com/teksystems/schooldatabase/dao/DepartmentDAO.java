package com.teksystems.schooldatabase.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import com.teksystems.schooldatabase.entity.Course;
import com.teksystems.schooldatabase.entity.Department;
import com.teksystems.schooldatabase.utilities.DAO;

public class DepartmentDAO extends DAO{
	
	public Department findById(Integer id) {
		init();

		String hql = "SELECT d FROM Department d WHERE d.id = :id";

		TypedQuery<Department> query = session.createQuery(hql, Department.class);
		query.setParameter("id", id);

		Department result = query.getSingleResult();

		close();

		return result;
	}
	
	public List<Course> findByDepartmentName(String name) {
		init();

		String hql = "SELECT d FROM Department d WHERE d.name = :name";

		TypedQuery<Course> query = session.createQuery(hql, Course.class);
		query.setParameter("name", name);

		List<Course> result = query.getResultList();

		close();

		return result;
	}

	public void update(Department dept) {
		init();
		
		session.merge(dept);
		
		close();
	}
	
	public void insert(Department dept) {
		init();
		
		session.save(dept);
		
		close();
	}

}
