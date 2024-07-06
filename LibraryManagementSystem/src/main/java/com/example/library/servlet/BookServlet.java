package com.example.library.servlet;

import com.example.library.model.Book;
import com.example.library.service.BookService;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BookServlet extends HttpServlet {

    private final BookService bookService;
    private final Gson gson;

    public BookServlet(BookService bookService) {
        this.bookService = bookService;
        this.gson = new Gson();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();
        resp.setContentType("application/json");
        if (path == null || path.equals("/")) {
            List<Book> books = bookService.getAllBooks();
            resp.getWriter().write(gson.toJson(books));
        } else {
            try {
                int id = Integer.parseInt(path.substring(1));
                Book book = bookService.getBookById(id);
                if (book != null) {
                    resp.getWriter().write(gson.toJson(book));
                } else {
                    resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    resp.getWriter().write("{\"error\":\"Book not found\"}");
                }
            } catch (NumberFormatException e) {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                resp.getWriter().write("{\"error\":\"Invalid book ID\"}");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = gson.fromJson(req.getReader(), Book.class);
        bookService.addBook(book);
        resp.setStatus(HttpServletResponse.SC_CREATED);
        resp.getWriter().write(gson.toJson(book));
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = gson.fromJson(req.getReader(), Book.class);
        boolean updated = bookService.updateBook(book);
        if (updated) {
            resp.getWriter().write(gson.toJson(book));
        } else {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            resp.getWriter().write("{\"error\":\"Book not found\"}");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();
        if (path == null || path.equals("/")) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("{\"error\":\"Book ID is required\"}");
            return;
        }

        try {
            int id = Integer.parseInt(path.substring(1));
            boolean deleted = bookService.deleteBook(id);
            if (deleted) {
                resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
            } else {
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                resp.getWriter().write("{\"error\":\"Book not found\"}");
            }
        } catch (NumberFormatException e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("{\"error\":\"Invalid book ID\"}");
        }
    }
}
