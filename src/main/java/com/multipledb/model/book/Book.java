package com.multipledb.model.book;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
* Book entity for Book_TB table in PostgreSQL
* Labok will provide Getter, Setter, toString, Constructor, etc
*/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="BOOK_TB")
public class Book {

	@Id
	private int id;
	private String name;
}
