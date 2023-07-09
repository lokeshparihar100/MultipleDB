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

@RestController
public class WebController {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private UserRepository userRepository;

	@PostConstruct
	public void addData2DB() {
		userRepository.saveAll(Stream.of(new User(744, "John"), new User(455, "Pitter")).collect(Collectors.toList()));
		bookRepository.saveAll(
				Stream.of(new Book(111, "Core Java"), new Book(222, "Spring Boot")).collect(Collectors.toList()));
	}

	@GetMapping("/getUsers")
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/getBooks")
	public List<Book> getBooks() {
		return bookRepository.findAll();
	}
	
	@GetMapping("getUsers/{id}")
	public Optional<User> getUserById(@PathVariable Integer id){
		return userRepository.findById(id);
	}
	
	@GetMapping("getFirstUser")
	public User findFirstByOrderByIdAsc() {
		return userRepository.findFirstByOrderByIdAsc();
	}
	
	@GetMapping("getTopUser")
	public User findTopByOrderByIdAsc() {
		return userRepository.findTopByOrderByIdAsc();
	}
	
	@GetMapping("getUsersbyId")
	public List<User> findByOrderByIdAsc() {
		return userRepository.findByOrderByIdAsc();
	}
	
	@GetMapping("getUserss/{name}")
	public List<User> findByUserNameIgnoreCase(@PathVariable String name) {
		return userRepository.findByUserNameIgnoreCase(name);
	}
	
	@GetMapping("getUser/{name}")
	public List<User> findByUserNameOrderByIdAsc(@PathVariable String name) {
		return userRepository.findByUserNameOrderByIdAsc(name);
	}
	
	@GetMapping("getUserOrder/{name}")
	public List<User> findByUserName(@PathVariable String name) {
		Sort sortBy = Sort.by(new Sort.Order(Sort.Direction.ASC, "id"));
		return userRepository.findByUserName(name, sortBy);
	}
	
	@GetMapping("getUserLimit/{num}")
	public List<User> findOrderedByIdLimitedTo(@PathVariable Integer num) {
		return userRepository.findOrderedByIdLimitedTo(num);
	}
	
	
	
}
