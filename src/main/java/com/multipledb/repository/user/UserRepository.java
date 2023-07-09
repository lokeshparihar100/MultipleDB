package com.multipledb.repository.user;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.multipledb.model.user.User;

/*
* UserRepository interface using JpaRepository<Entity, TypeOf @Id> & CustomUserRepository
*/

public interface UserRepository extends JpaRepository<User, Integer>, CustomUserRepository {

	User findFirstByOrderByIdAsc();				// This will sort by ID in Assending order and extract 1st record

    User findTopByOrderByIdAsc();				// This will sort by ID in Assending order and extract 1st record

    List<User> findByOrderByIdAsc();				// This will sort by ID in Assending order and extract 1st record

    List<User> findByUserNameIgnoreCase(String userName);	// This will extract the record for given userName

    List<User> findByUserNameOrderByIdAsc(String userName);	// This will extract the record for given userName. If more than 1 record with same userName then sort by ID in Assending order	
}
