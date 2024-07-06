package com.example.library.service;

import com.example.library.model.Book;
import java.util.List;

public interface BookService {
    void addBook(Book book);
    Book getBookById(int id);
    List<Book> getAllBooks();
    boolean updateBook(Book book);
    boolean deleteBook(int id);
}
