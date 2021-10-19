package com.example.template.controller;

import com.example.template.model.Book;
import com.example.template.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@SpringBootTest
public class BookControllerTest {
    @InjectMocks
    private BookController bookController;

    @Mock
    private BookService bookService;

    private Book book;
    private List<Book> books;

    @BeforeEach
    public void setup() {
        init();
        when(bookService.get()).thenReturn(books);
        when(bookService.save(book)).thenReturn(book);
        when(bookService.update(book)).thenReturn(book);
    }

    @Test
    public void testBookControllerGet() {
        assertEquals("Test Failed: ", books, bookController.getBooks());
    }

    @Test
    public void testBookControllerPost() {
        assertEquals("Test Failed: ", book, bookController.addBook(book));
    }

    @Test
    public void testBookControllerPut() {
        assertEquals("Test Failed: ", book, bookController.updateBook(book));
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
