package com.multipledb.repository.user;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.multipledb.model.user.User;

public interface UserRepository extends JpaRepository<User, Integer>, CustomUserRepository {

	User findFirstByOrderByIdAsc();

    User findTopByOrderByIdAsc();

    List<User> findByOrderByIdAsc();

    List<User> findByUserNameIgnoreCase(String userName);

    List<User> findByUserNameOrderByIdAsc(String userName);

    List<User> findByUserName(String userName, Sort sort);

}
