package com.example.attendancemanagementsystem.service;

import com.example.attendancemanagementsystem.domain.MemberRepository;
import com.example.attendancemanagementsystem.web.dto.request.MemberJoinRequest;
import com.example.attendancemanagementsystem.web.dto.response.MemberResponse;
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
    public List<MemberResponse> findAllMember() {
        return memberRepository.findAll().stream()
                .map(MemberResponse::from)
                .toList();
    }
}
