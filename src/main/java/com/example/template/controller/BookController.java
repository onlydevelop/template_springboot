package com.example.template.controller;

import com.example.template.model.Book;
import com.example.template.service.BookService;
import io.micrometer.core.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping(path = "/books")
    @Timed(value = "books.time.get", description = "Time taken to return GET books request")
    public List<Book> getBooks() {
        return bookService.get();
    }

    @PostMapping(path = "/books")
    public Book addBook(@RequestBody Book book) {
        return bookService.save(book);
    }

    @PutMapping(path = "/books")
    public Book updateBook(@RequestBody Book book) {
        return bookService.update(book);
    }

    @DeleteMapping(path = "/books")
    public void deleteBook(@RequestBody Book book) {
        bookService.delete(book);
    }
}
