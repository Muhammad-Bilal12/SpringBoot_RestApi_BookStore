package com.bootrest.book_store_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bootrest.book_store_api.model.Book;
import com.bootrest.book_store_api.services.BookServices;

@RestController
public class BookController {

    // @GetMapping("/books")
    // public Book getBooks() {
    // Book book = new Book(121, "Java Head First", "ABCD");

    // return book;
    // }

    @Autowired
    BookServices bookServices;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> list = this.bookServices.getAllBooks();

        if (list.size() <= 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {

            return ResponseEntity.ok(list);
        }

        // return this.bookServices.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") int id) {
        Book book = this.bookServices.getBookById(id);

        if (book == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {

            return ResponseEntity.ok(book);
        }

    }

    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book b = null;
        try {
            b = this.bookServices.addbook(book);
            return ResponseEntity.status(HttpStatus.CREATED).body(b);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/books/{bid}")
    public ResponseEntity<Void> deleteBook(@PathVariable("bid") int id) {
        try {
            this.bookServices.deleteBook(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Void> updateBook(@RequestBody Book book, @PathVariable("id") int id) {
        try {
            this.bookServices.updateBook(book, id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
