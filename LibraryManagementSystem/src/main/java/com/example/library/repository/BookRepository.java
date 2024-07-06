package com.example.library.repository;

import com.example.library.model.Book;
import java.util.List;

public interface BookRepository {
    void save(Book book);
    Book findById(int id);
    List<Book> findAll();
    boolean update(Book book);
    boolean delete(int id);
}
