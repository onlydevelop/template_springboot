package com.example.template.service;

import com.example.template.model.Book;

import java.util.List;

public interface BookService {
    public List<Book> get();
    public Book save(Book book);
    public Book update(Book book);
    public void delete(Book book);
}
