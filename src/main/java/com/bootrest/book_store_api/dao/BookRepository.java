package com.bootrest.book_store_api.dao;

import org.springframework.data.repository.CrudRepository;

import com.bootrest.book_store_api.model.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {

    public Book findBookById(int id);

}
