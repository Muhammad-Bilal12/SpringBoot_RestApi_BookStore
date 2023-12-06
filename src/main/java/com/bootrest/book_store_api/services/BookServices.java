package com.bootrest.book_store_api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bootrest.book_store_api.dao.BookRepository;
import com.bootrest.book_store_api.model.Book;

@Component
public class BookServices {

    @Autowired
    private BookRepository bookRepo;

    // private static List<Book> books = new ArrayList<>();

    // static {
    // books.add(new Book(141, "Java Head First", "XYZ"));
    // books.add(new Book(142, "Think in Java", "LMN"));
    // books.add(new Book(131, "First Java", "ABC"));
    // }

    public List<Book> getAllBooks() {
        List<Book> books = (List<Book>) this.bookRepo.findAll();
        return books;
    }

    public Book getBookById(int id) {
        Book book = null;

        try {
            book = this.bookRepo.findBookById(id);
            // book = books.stream().filter(e -> e.getId() == id).findFirst().get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }

    public Book addbook(Book book) {
        // books.add(book);
        this.bookRepo.save(book);
        return book;
    }

    public void deleteBook(int id) {
        // books = books.stream().filter(book -> {
        // if (book.getId() != id) {
        // return true;
        // } else {
        // return false;
        // }
        // }).collect(Collectors.toList());

        // books = books.stream().filter(book -> book.getId() !=
        // id).collect(Collectors.toList());
        this.bookRepo.deleteById(id);
    }

    public void updateBook(Book book, int id) {
        // books = books.stream().map(b -> {
        // if (b.getId() == id) {
        // b.setTitle(book.getTitle());
        // b.setAuthor(book.getAuthor());
        // }

        // return b;
        // }).collect(Collectors.toList());

        book.setId(id);
        bookRepo.save(book);

    }

}
