package com.example.library.repositoryImpl;

import com.example.library.model.Loan;
import com.example.library.repository.LoanRepository;
import com.example.library.util.DatabaseConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoanRepositoryImpl implements LoanRepository {
    private static final Logger logger = LoggerFactory.getLogger(LoanRepositoryImpl.class);

    @Override
    public void save(Loan loan) {
        String sql = "INSERT INTO loans (book_id, member_id, loan_date, return_date) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, loan.getBookId());
            pstmt.setInt(2, loan.getMemberId());
            pstmt.setDate(3, new Date(loan.getLoanDate().getTime()));
            if (loan.getReturnDate() != null) {
                pstmt.setDate(4, new Date(loan.getReturnDate().getTime()));
            } else {
                pstmt.setNull(4, Types.DATE);
            }
            pstmt.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error in loan operation: {}", e.getMessage(), e);
        }
    }

    @Override
    public Loan findById(int id) {
        String sql = "SELECT * FROM loans WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Loan(
                        rs.getInt("id"),
                        rs.getInt("book_id"),
                        rs.getInt("member_id"),
                        rs.getDate("loan_date"),
                        rs.getDate("return_date")
                );
            }
        } catch (SQLException e) {
            logger.error("Error in loan operation: {}", e.getMessage(), e);
        }
        return null;
    }

    @Override
    public List<Loan> findAll() {
        String sql = "SELECT * FROM loans";
        List<Loan> loans = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                loans.add(new Loan(
                        rs.getInt("id"),
                        rs.getInt("book_id"),
                        rs.getInt("member_id"),
                        rs.getDate("loan_date"),
                        rs.getDate("return_date")
                ));
            }
        } catch (SQLException e) {
            logger.error("Error in loan operation: {}", e.getMessage(), e);
        }
        return loans;
    }

    @Override
    public boolean update(Loan loan) {
        String sql = "UPDATE loans SET book_id = ?, member_id = ?, loan_date = ?, return_date = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, loan.getBookId());
            pstmt.setInt(2, loan.getMemberId());
            pstmt.setDate(3, new Date(loan.getLoanDate().getTime()));
            if (loan.getReturnDate() != null) {
                pstmt.setDate(4, new Date(loan.getReturnDate().getTime()));
            } else {
                pstmt.setNull(4, Types.DATE);
            }
            pstmt.setInt(5, loan.getId());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            logger.error("Error in loan operation: {}", e.getMessage(), e);
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM loans WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            logger.error("Error in loan operation: {}", e.getMessage(), e);
        }
        return false;
    }
}
