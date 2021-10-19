package com.example.template.service;

import com.example.template.model.Book;
import com.example.template.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> get() {
        return bookRepository.findAll();
    }

    @Override
    public Book save(Book book) {
        if (book == null) return null;
        return bookRepository.save(book);
    }

    @Override
    public Book update(Book book) {
        if (book == null) return null;
        Book updated = bookRepository.getById(book.getId());
        if (updated == null) return null;
        updated.setTitle(book.getTitle());
        updated.setSummary(book.getSummary());
        updated.setAuthor(book.getAuthor());
        updated.setISBN(book.getISBN());
        return bookRepository.save(updated);
    }

    @Override
    public void delete(Book book) {
        if (book == null) return;
        Book deleted = bookRepository.getById(book.getId());
        if (deleted == null) return;
        bookRepository.delete(book);
    }
}
