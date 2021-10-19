package com.example.template.model;

import static org.springframework.test.util.AssertionErrors.assertEquals;

import org.junit.jupiter.api.Test;

public class BookTest {
    final String TITLE = "title";
    final String SUMMARY = "summary";
    final String AUTHOR = "author";
    final String ISBN = "isbn";

    @Test
    public void testBookEntity() {
        Book book = new Book();
        book.setTitle(TITLE);
        book.setSummary(SUMMARY);
        book.setAuthor(AUTHOR);
        book.setISBN(ISBN);
        assertEquals("Test Failed:", TITLE, book.getTitle());
        assertEquals("Test Failed:", SUMMARY, book.getSummary());
        assertEquals("Test Failed:", AUTHOR, book.getAuthor());
        assertEquals("Test Failed:", ISBN, book.getISBN());
    }
}
