package com.example.library;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import com.example.library.servlet.BookServlet;
import com.example.library.servlet.LoanServlet;
import com.example.library.servlet.MemberServlet;
import com.example.library.service.BookService;
import com.example.library.service.LoanService;
import com.example.library.service.MemberService;
import com.example.library.serviceImpl.BookServiceImpl;
import com.example.library.serviceImpl.LoanServiceImpl;
import com.example.library.serviceImpl.MemberServiceImpl;
import com.example.library.repositoryImpl.BookRepositoryImpl;
import com.example.library.repositoryImpl.LoanRepositoryImpl;
import com.example.library.repositoryImpl.MemberRepositoryImpl;

public class JettyServer {

    public static void main(String[] args) throws Exception {
        BookService bookService = new BookServiceImpl(new BookRepositoryImpl());
        LoanService loanService = new LoanServiceImpl(new LoanRepositoryImpl());
        MemberService memberService = new MemberServiceImpl(new MemberRepositoryImpl());

        Server server = new Server(8086);

        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        handler.setContextPath("/");
        server.setHandler(handler);

        handler.addServlet(new ServletHolder(new BookServlet(bookService)), "/books/*");
        handler.addServlet(new ServletHolder(new LoanServlet(loanService)), "/loans/*");
        handler.addServlet(new ServletHolder(new MemberServlet(memberService)), "/members/*");

        server.start();
        server.join();
    }
}
