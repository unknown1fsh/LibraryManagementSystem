package com.example.library.repositoryImpl;

import com.example.library.model.Book;
import com.example.library.repository.BookRepository;
import com.example.library.util.DatabaseConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookRepositoryImpl implements BookRepository {
    private static final Logger logger = LoggerFactory.getLogger(BookRepositoryImpl.class);

    @Override
    public void save(Book book) {
        String sql = "INSERT INTO books (title, author, isbn) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, book.getTitle());
            pstmt.setString(2, book.getAuthor());
            pstmt.setString(3, book.getIsbn());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error saving book: {}", e.getMessage(), e);
        }
    }

    @Override
    public Book findById(int id) {
        String sql = "SELECT * FROM books WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("isbn")
                );
            }
        } catch (SQLException e) {
            logger.error("Error saving book: {}", e.getMessage(), e);
        }
        return null;
    }

    @Override
    public List<Book> findAll() {
        String sql = "SELECT * FROM books";
        List<Book> books = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                books.add(new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("isbn")
                ));
            }
        } catch (SQLException e) {
            logger.error("Error saving book: {}", e.getMessage(), e);
        }
        return books;
    }

    @Override
    public boolean update(Book book) {
        String sql = "UPDATE books SET title = ?, author = ?, isbn = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, book.getTitle());
            pstmt.setString(2, book.getAuthor());
            pstmt.setString(3, book.getIsbn());
            pstmt.setInt(4, book.getId());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            logger.error("Error saving book: {}", e.getMessage(), e);
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM books WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            logger.error("Error saving book: {}", e.getMessage(), e);
        }
        return false;
    }
}
