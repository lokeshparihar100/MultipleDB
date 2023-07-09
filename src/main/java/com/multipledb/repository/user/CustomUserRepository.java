package com.multipledb.repository.user;

import java.util.List;

import com.multipledb.model.user.User;

/*
* CustomUserRepository interface for Limit query
*/

public interface CustomUserRepository {

	List<User> findOrderedByIdLimitedTo(int limit);	   // It will extract the number of Users which is given in Limit
}
