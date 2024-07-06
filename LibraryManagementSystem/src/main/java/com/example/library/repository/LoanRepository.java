package com.example.library.repository;

import com.example.library.model.Loan;
import java.util.List;

public interface LoanRepository {
    void save(Loan loan);
    Loan findById(int id);
    List<Loan> findAll();
    boolean update(Loan loan);
    boolean delete(int id);
}
