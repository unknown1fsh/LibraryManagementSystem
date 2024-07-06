package com.example.library.service;

import com.example.library.model.Member;
import java.util.List;

public interface MemberService {
    void addMember(Member member);
    Member getMemberById(int id);
    List<Member> getAllMembers();
    boolean updateMember(Member member);
    boolean deleteMember(int id);
}
