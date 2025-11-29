package com.example.library.repositoryImpl;

import com.example.library.model.Member;
import com.example.library.repository.MemberRepository;
import com.example.library.util.DatabaseConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberRepositoryImpl implements MemberRepository {
    private static final Logger logger = LoggerFactory.getLogger(MemberRepositoryImpl.class);

    @Override
    public void save(Member member) {
        String sql = "INSERT INTO members (name, email) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, member.getName());
            pstmt.setString(2, member.getEmail());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error in member operation: {}", e.getMessage(), e);
        }
    }

    @Override
    public Member findById(int id) {
        String sql = "SELECT * FROM members WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Member(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email")
                );
            }
        } catch (SQLException e) {
            logger.error("Error in member operation: {}", e.getMessage(), e);
        }
        return null;
    }

    @Override
    public List<Member> findAll() {
        String sql = "SELECT * FROM members";
        List<Member> members = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                members.add(new Member(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email")
                ));
            }
        } catch (SQLException e) {
            logger.error("Error in member operation: {}", e.getMessage(), e);
        }
        return members;
    }

    @Override
    public boolean update(Member member) {
        String sql = "UPDATE members SET name = ?, email = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, member.getName());
            pstmt.setString(2, member.getEmail());
            pstmt.setInt(3, member.getId());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            logger.error("Error in member operation: {}", e.getMessage(), e);
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM members WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            logger.error("Error in member operation: {}", e.getMessage(), e);
        }
        return false;
    }
}
