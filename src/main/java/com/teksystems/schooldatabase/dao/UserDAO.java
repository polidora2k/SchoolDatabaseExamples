package com.teksystems.schooldatabase.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.apache.commons.lang3.tuple.Pair;

import com.teksystems.schooldatabase.entity.User;
import com.teksystems.schooldatabase.utilities.DAO;

public class UserDAO extends DAO {
	public Pair<String, String> findLoginInfoById(Integer id) {
		init();

		String hql = "SELECT u FROM User u WHERE id = :id";
		TypedQuery<User> query = session.createQuery(hql, User.class);
		query.setParameter("id", id);
		User u = query.getSingleResult();

		close();

		return Pair.of(u.getEmail(), u.getPassword());
	}

	public User findUserByEmail(String email) {
		init();

		String hql = "SELECT u FROM User u WHERE email = :email";
		TypedQuery<User> query = session.createQuery(hql, User.class);
		query.setParameter("email", email);
		User u = query.getSingleResult();

		close();

		return u;
	}
	
	public List<User> findUsersByState(String state){
		init();

		String hql = "SELECT u FROM User u WHERE state = :state";
		TypedQuery<User> query = session.createQuery(hql, User.class);
		query.setParameter("state", state);
		List<User> u = query.getResultList();

		close();

		return u;
	}
	
	public List<User> findUsersByZipcode(String zipcode){
		init();

		String hql = "SELECT u FROM User u WHERE zipcode = :zipcode";
		TypedQuery<User> query = session.createQuery(hql, User.class);
		query.setParameter("zipcode", zipcode);
		List<User> u = query.getResultList();

		close();

		return u;
	}

	public void update(User user) {
		init();

		session.merge(user);

		close();
	}

	public void insert(User user) {
		init();

		session.save(user);

		close();
	}
}
