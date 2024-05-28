package com.wl.spring.repositories.impl;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wl.spring.models.User;
import com.wl.spring.repositories.UserRepository;

@Repository
@Primary
@Transactional
public class UserRepositoryImp implements UserRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean add(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(user);
		return true;

	}

	@Override
	public List<User> getUsers(String username) {
		Session session = sessionFactory.getCurrentSession();

		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<User> query = builder.createQuery(User.class);
		Root<User> root = query.from(User.class);

		// Thêm join để lấy thông tin từ bảng roles
		root.join("listRoles", JoinType.INNER);

		query = query.select(root).distinct(true);

		if (!username.isEmpty()) {
			Predicate p = builder.equal(root.get("username").as(String.class), username);
			query = query.where(p);
		}

		Query q = session.createQuery(query);
		List<User> users = q.getResultList();
		System.out.println(users.get(0).toString());
		return users;

	}

}
