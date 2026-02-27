package com.library;

import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void registerMember(Long id, String name, String email) {
        memberRepository.save(new Member(id, name, email));
        System.out.println("Member Registered Successfully");
    }

    public Member getMember(Long id) {
        return memberRepository.findById(id);
    }
}
