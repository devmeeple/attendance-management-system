package com.example.attendancemanagementsystem.service;

import com.example.attendancemanagementsystem.domain.Member;
import com.example.attendancemanagementsystem.domain.MemberRepository;
import com.example.attendancemanagementsystem.web.dto.MemberJoinRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public void joinMember(MemberJoinRequest request) {
        memberRepository.save(request.toEntity());
    }

    @Transactional
    public List<Member> findAllMember() {
        return memberRepository.findAll();
    }
}
