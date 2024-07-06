package com.example.library.repository;

import com.example.library.model.Member;
import java.util.List;

public interface MemberRepository {
    void save(Member member);
    Member findById(int id);
    List<Member> findAll();
    boolean update(Member member);
    boolean delete(int id);
}
