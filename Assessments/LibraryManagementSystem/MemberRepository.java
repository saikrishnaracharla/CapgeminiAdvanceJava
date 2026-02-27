package com.library;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemberRepository {

    private List<Member> members = new ArrayList<>();

    public void save(Member member) {
        members.add(member);
    }

    public Member findById(Long id) {
        return members.stream().filter(m -> m.getId().equals(id)).findFirst().orElse(null);
    }
}
