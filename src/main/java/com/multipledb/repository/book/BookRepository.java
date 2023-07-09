package com.multipledb.repository.book;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multipledb.model.book.Book;

/*
* BookRepository interface using JpaRepository<Entity, TypeOf @Id>
*/

public interface BookRepository extends JpaRepository<Book, Integer>{

}
