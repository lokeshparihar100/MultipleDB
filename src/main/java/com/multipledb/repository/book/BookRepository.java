package com.multipledb.repository.book;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multipledb.model.book.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

}
