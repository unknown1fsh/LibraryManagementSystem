package com.example.library.service;

import com.example.library.model.Loan;
import java.sql.SQLException;
import java.util.List;

public interface LoanService {
    void addLoan(Loan loan) throws SQLException;
    Loan getLoanById(int id);
    List<Loan> getAllLoans();
    boolean updateLoan(Loan loan) throws SQLException;
    boolean deleteLoan(int id) throws SQLException;
}
