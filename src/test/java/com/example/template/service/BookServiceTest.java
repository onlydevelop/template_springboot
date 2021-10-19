package com.example.template.service;

import com.example.template.model.Book;
import com.example.template.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@SpringBootTest
public class BookServiceTest {
    @InjectMocks
    private BookServiceImpl bookService;

    @Mock
    private BookRepository bookRepository;

    private Book book;
    private List<Book> books;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        init();
        when(bookRepository.getById(1L)).thenReturn(book);
        when(bookRepository.findAll()).thenReturn(books);
        when(bookRepository.save(book)).thenReturn(book);
    }

    @Test
    public void testBookServiceGet() {
        assertEquals("Test Failed: ", books, bookService.get());
    }

    @Test
    public void testBookServiceSave() {
        assertEquals("Test Failed: ", book, bookService.save(book));
    }

    @Test
    public void testBookServiceUpdate() {
        assertEquals("Test Failed: ", book, bookService.update(book));
    }

    private void init() {
        book = new Book();
        book.setTitle("Title");
        book.setSummary("Summary");
        book.setAuthor("Author");
        book.setISBN("ISBN");
        book.setId(1);
        books = new ArrayList<Book>(Arrays.asList(book));
    }
}
