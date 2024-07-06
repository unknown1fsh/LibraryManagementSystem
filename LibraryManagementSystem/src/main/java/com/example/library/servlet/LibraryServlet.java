package com.example.library.servlet;

import com.example.library.model.Book;
import com.example.library.model.Loan;
import com.example.library.model.Member;
import com.example.library.service.BookService;
import com.example.library.service.LoanService;
import com.example.library.service.MemberService;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class LibraryServlet extends HttpServlet {

    private final BookService bookService;
    private final LoanService loanService;
    private final MemberService memberService;
    private final Gson gson;

    public LibraryServlet(BookService bookService, LoanService loanService, MemberService memberService) {
        this.bookService = bookService;
        this.loanService = loanService;
        this.memberService = memberService;
        this.gson = new Gson();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();
        resp.setContentType("application/json");
        switch (path) {
            case "/books":
                List<Book> books = bookService.getAllBooks();
                resp.getWriter().write(gson.toJson(books));
                break;
            case "/loans":
                List<Loan> loans = loanService.getAllLoans();
                resp.getWriter().write(gson.toJson(loans));
                break;
            case "/members":
                List<Member> members = memberService.getAllMembers();
                resp.getWriter().write(gson.toJson(members));
                break;
            default:
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                resp.getWriter().write("{\"error\":\"Not Found\"}");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();
        resp.setContentType("application/json");
        switch (path) {
            case "/books":
                Book book = gson.fromJson(req.getReader(), Book.class);
                bookService.addBook(book);
                resp.setStatus(HttpServletResponse.SC_CREATED);
                resp.getWriter().write(gson.toJson(book));
                break;
            case "/loans":
                Loan loan = gson.fromJson(req.getReader(), Loan.class);
                try {
                    loanService.addLoan(loan);
                    resp.setStatus(HttpServletResponse.SC_CREATED);
                    resp.getWriter().write(gson.toJson(loan));
                } catch (SQLException e) {
                    resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                    resp.getWriter().write("{\"error\":\"Failed to add loan\"}");
                }
                break;
            case "/members":
                Member member = gson.fromJson(req.getReader(), Member.class);
                memberService.addMember(member);
                resp.setStatus(HttpServletResponse.SC_CREATED);
                resp.getWriter().write(gson.toJson(member));
                break;
            default:
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                resp.getWriter().write("{\"error\":\"Not Found\"}");
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();
        resp.setContentType("application/json");
        switch (path) {
            case "/books":
                Book book = gson.fromJson(req.getReader(), Book.class);
                boolean bookUpdated = bookService.updateBook(book);
                if (bookUpdated) {
                    resp.getWriter().write(gson.toJson(book));
                } else {
                    resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    resp.getWriter().write("{\"error\":\"Book not found\"}");
                }
                break;
            case "/loans":
                Loan loan = gson.fromJson(req.getReader(), Loan.class);
                try {
                    boolean loanUpdated = loanService.updateLoan(loan);
                    if (loanUpdated) {
                        resp.getWriter().write(gson.toJson(loan));
                    } else {
                        resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                        resp.getWriter().write("{\"error\":\"Loan not found\"}");
                    }
                } catch (SQLException e) {
                    resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                    resp.getWriter().write("{\"error\":\"Failed to update loan\"}");
                }
                break;
            case "/members":
                Member member = gson.fromJson(req.getReader(), Member.class);
                boolean memberUpdated = memberService.updateMember(member);
                if (memberUpdated) {
                    resp.getWriter().write(gson.toJson(member));
                } else {
                    resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    resp.getWriter().write("{\"error\":\"Member not found\"}");
                }
                break;
            default:
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                resp.getWriter().write("{\"error\":\"Not Found\"}");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();
        resp.setContentType("application/json");
        switch (path) {
            case "/books":
                int bookId = Integer.parseInt(req.getParameter("id"));
                boolean bookDeleted = bookService.deleteBook(bookId);
                if (bookDeleted) {
                    resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
                } else {
                    resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    resp.getWriter().write("{\"error\":\"Book not found\"}");
                }
                break;
            case "/loans":
                int loanId = Integer.parseInt(req.getParameter("id"));
                try {
                    boolean loanDeleted = loanService.deleteLoan(loanId);
                    if (loanDeleted) {
                        resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
                    } else {
                        resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                        resp.getWriter().write("{\"error\":\"Loan not found\"}");
                    }
                } catch (SQLException e) {
                    resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                    resp.getWriter().write("{\"error\":\"Failed to delete loan\"}");
                }
                break;
            case "/members":
                int memberId = Integer.parseInt(req.getParameter("id"));
                boolean memberDeleted = memberService.deleteMember(memberId);
                if (memberDeleted) {
                    resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
                } else {
                    resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    resp.getWriter().write("{\"error\":\"Member not found\"}");
                }
                break;
            default:
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                resp.getWriter().write("{\"error\":\"Not Found\"}");
        }
    }
}
