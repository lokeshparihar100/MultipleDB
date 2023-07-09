package com.multipledb.repository.user;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.multipledb.model.user.User;

@Repository
public class CustomUserRepositoryImpl implements CustomUserRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<User> findOrderedByIdLimitedTo(int limit) {
		
		return entityManager.createQuery("SELECT u FROM User u ORDER BY u.id",
		          User.class).setMaxResults(limit).getResultList();
	}

}
