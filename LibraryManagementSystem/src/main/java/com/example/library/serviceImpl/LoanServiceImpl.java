package com.example.library.serviceImpl;

import com.example.library.model.Loan;
import com.example.library.repository.LoanRepository;
import com.example.library.service.LoanService;

import java.sql.SQLException;
import java.util.List;

public class LoanServiceImpl implements LoanService {
    private final LoanRepository loanRepository;

    public LoanServiceImpl(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Override
    public void addLoan(Loan loan) throws SQLException {
        loanRepository.save(loan);
    }

    @Override
    public Loan getLoanById(int id) {
        return loanRepository.findById(id);
    }

    @Override
    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    @Override
    public boolean updateLoan(Loan loan) throws SQLException {
        return loanRepository.update(loan);
    }

    @Override
    public boolean deleteLoan(int id) throws SQLException {
        return loanRepository.delete(id);
    }
}
