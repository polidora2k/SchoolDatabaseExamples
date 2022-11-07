package com.teksystems.schooldatabase.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import com.teksystems.schooldatabase.entity.Faculty;
import com.teksystems.schooldatabase.utilities.DAO;

public class FacultyDAO extends DAO{
	public List<Faculty> findFaculty() {
		init();
		
		String hql = "FROM Faculty";
		TypedQuery<Faculty> query = session.createQuery(hql, Faculty.class);
		List<Faculty> results = query.getResultList();
		
		close();
		
		return results;
	}
	
	public Faculty findFacultyById(Integer id) {
		init();
		
		String hql = "SELECT c FROM Faculty c WHERE id = :id";
		TypedQuery<Faculty> query = session.createQuery(hql, Faculty.class);
		query.setParameter("id", id);
		Faculty c = query.getSingleResult();
		
		close();
		
		return c;
	}
	
	public void update(Faculty faculty) {
		init();
		
		session.merge(faculty);
		
		close();
	}
	
	public void insert(Faculty faculty) {
		init();
		
		session.save(faculty);
		
		close();
	}
}
