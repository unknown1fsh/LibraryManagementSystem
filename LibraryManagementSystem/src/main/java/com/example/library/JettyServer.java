package com.example.library;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;

public class JettyServer {
    private static final Logger logger = LoggerFactory.getLogger(JettyServer.class);

    public static void main(String[] args) throws Exception {
        BookService bookService = new BookServiceImpl(new BookRepositoryImpl());
        LoanService loanService = new LoanServiceImpl(new LoanRepositoryImpl());
        MemberService memberService = new MemberServiceImpl(new MemberRepositoryImpl());

        Server server = new Server(8086);

        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        handler.setContextPath("/");
        
        // Set resource base for static files
        URL webappUrl = JettyServer.class.getClassLoader().getResource("webapp");
        if (webappUrl != null) {
            handler.setResourceBase(webappUrl.toExternalForm());
        } else {
            // Fallback: try to find webapp directory
            String webappPath = "src/main/webapp";
            handler.setResourceBase(webappPath);
        }
        
        server.setHandler(handler);

        // Add servlets
        handler.addServlet(new ServletHolder(new BookServlet(bookService)), "/books/*");
        handler.addServlet(new ServletHolder(new LoanServlet(loanService)), "/loans/*");
        handler.addServlet(new ServletHolder(new MemberServlet(memberService)), "/members/*");
        
        // Add default servlet for static files
        ServletHolder defaultServlet = new ServletHolder("default", DefaultServlet.class);
        defaultServlet.setInitParameter("dirAllowed", "false");
        handler.addServlet(defaultServlet, "/");

        logger.info("Starting Library Management System server on port 8086...");
        logger.info("Access the application at: http://localhost:8086/index.html");
        
        server.start();
        server.join();
    }
}
