package com.multipledb.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.multipledb.model.book.Book;
import com.multipledb.model.user.User;
import com.multipledb.repository.book.BookRepository;
import com.multipledb.repository.user.UserRepository;

/*
* WebController for all requests with RestController
*/

@RestController
public class WebController {

	@Autowired
	private BookRepository bookRepository;				// Create BookRepository Class Instance with Autowired

	@Autowired
	private UserRepository userRepository;				// Create UserRepository Class Instance with Autowired

	// PostConstruct is use to run just after Tomcat server start
	@PostConstruct
	public void addData2DB() {
	// Save the data into MySQL datasource1 schema if table not exist then it will create automatically by 'hibernate.hbm2ddl.auto' property 'update'
		userRepository.saveAll(Stream.of(new User(101, "John"), new User(102, "Pitter"), new User(103, "Harry"), new User(104, "Kim"),
			new User(105, "Tom"), new User(106, "Ana"), new User(107, "Hema"), new User(108, "Tiger"), 
			new User(109, "Angela"), new User(110, "Hero"), new User(111, "Mac"), new User(112, "Zen")
						).collect(Collectors.toList()));
		bookRepository.saveAll(
				Stream.of(new Book(111, "Core Java"), new Book(222, "Spring Boot")).collect(Collectors.toList()));
	}
	// URL: http://localhost:8080/getAllUsers
	@GetMapping("/getAllUsers")
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	// URL: http://localhost:8080/getAllBooks
	@GetMapping("/getAllBooks")
	public List<Book> getBooks() {
		return bookRepository.findAll();
	}

	// URL: http://localhost:8080/getFirstUser
	@GetMapping("getFirstUser")
	public User findFirstByOrderByIdAsc() {
		return userRepository.findFirstByOrderByIdAsc();
	}

	// URL: http://localhost:8080/getFirstUserAlternate
	@GetMapping("getFirstUserAlternate")
	public User findTopByOrderByIdAsc() {
		return userRepository.findTopByOrderByIdAsc();
	}

	// URL: http://localhost:8080/getUsersById
	@GetMapping("getUsersById")
	public List<User> findByOrderByIdAsc() {
		return userRepository.findByOrderByIdAsc();
	}

	// URL: http://localhost:8080/getUsers/101
	@GetMapping("getUsers/{id}")
	public Optional<User> getUserById(@PathVariable Integer id){
		return userRepository.findById(id);
	}

	// URL: http://localhost:8080/getUserIgnoreCase/John
	@GetMapping("getUserIgnoreCase/{name}")
	public List<User> findByUserNameIgnoreCase(@PathVariable String name) {
		return userRepository.findByUserNameIgnoreCase(name);
	}

	// URL: http://localhost:8080/getUserByName/John
	@GetMapping("getUserByName/{name}")
	public List<User> findByUserNameOrderByIdAsc(@PathVariable String name) {
		return userRepository.findByUserNameOrderByIdAsc(name);
	}

	// URL: http://localhost:8080/getUserOrder/John
	@GetMapping("getUserOrder/{name}")
	public List<User> findByUserName(@PathVariable String name) {
		Sort sortBy = Sort.by(new Sort.Order(Sort.Direction.ASC, "id"));
		return userRepository.findByUserName(name, sortBy);
	}

	// URL: http://localhost:8080/getUserLimit/5
	@GetMapping("getUserLimit/{num}")
	public List<User> findOrderedByIdLimitedTo(@PathVariable Integer num) {
		return userRepository.findOrderedByIdLimitedTo(num);
	}
	
	
	
}
