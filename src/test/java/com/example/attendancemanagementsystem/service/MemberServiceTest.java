package com.example.attendancemanagementsystem.service;

import com.example.attendancemanagementsystem.domain.Member;
import com.example.attendancemanagementsystem.domain.MemberRepository;
import com.example.attendancemanagementsystem.domain.MemberRole;
import com.example.attendancemanagementsystem.web.dto.request.MemberJoinRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@Transactional
@SpringBootTest
class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void joinMember() {
        // given
        MemberJoinRequest request = MemberJoinRequest.builder()
                .name("홍길동")
                .role(MemberRole.MEMBER)
                .birthday(LocalDate.of(1990, 1, 1))
                .workStartDate(LocalDate.of(2024, 1, 1))
                .build();

        // when
        memberService.joinMember(request);

        // then
        List<Member> all = memberRepository.findAll();

        assertThat(all).hasSize(1);
        assertThat(all.get(0).getName()).isEqualTo("홍길동");
    }
}
