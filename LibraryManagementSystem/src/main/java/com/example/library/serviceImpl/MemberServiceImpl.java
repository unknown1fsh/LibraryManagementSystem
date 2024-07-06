package com.example.library.serviceImpl;

import com.example.library.model.Member;
import com.example.library.repository.MemberRepository;
import com.example.library.service.MemberService;

import java.util.List;

public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void addMember(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member getMemberById(int id) {
        return memberRepository.findById(id);
    }

    @Override
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public boolean updateMember(Member member) {
        return memberRepository.update(member);
    }

    @Override
    public boolean deleteMember(int id) {
        return memberRepository.delete(id);
    }
}
