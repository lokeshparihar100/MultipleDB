package com.multipledb.repository.user;

import java.util.List;

import com.multipledb.model.user.User;

public interface CustomUserRepository {

	List<User> findOrderedByIdLimitedTo(int limit);
}
