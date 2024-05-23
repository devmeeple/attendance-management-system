package com.example.attendancemanagementsystem.web.dto;

import com.example.attendancemanagementsystem.domain.Member;
import com.example.attendancemanagementsystem.domain.MemberRepository;
import com.example.attendancemanagementsystem.domain.MemberRole;
import com.example.attendancemanagementsystem.web.dto.request.MemberJoinRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class MemberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MemberRepository memberRepository;

    @AfterEach
    void tearDown() {
        memberRepository.deleteAll();
    }

    @DisplayName("직원이 입사한다")
    @Test
    void joinMember() throws Exception {
        // given
        MemberJoinRequest request = MemberJoinRequest.builder()
                .name("홍길동")
                .role(MemberRole.MEMBER)
                .birthday(LocalDate.of(1990, 1, 1))
                .workStartDate(LocalDate.of(2024, 1, 1))
                .build();

        String content = objectMapper.writeValueAsString(request);

        // when
        mockMvc.perform(post("/member")
                        .contentType(APPLICATION_JSON)
                        .content(content))
                .andExpect(status().isOk())
                .andDo(print());

        // then
        assertThat(memberRepository.findAll()).hasSize(1);
    }

    @DisplayName("전체직원을 조회한다")
    @Test
    void findAllMembers() throws Exception {
        // given
        Member member1 = Member.builder()
                .name("홍길동")
                .role(MemberRole.MEMBER)
                .birthday(LocalDate.of(1990, 1, 1))
                .workStartDate(LocalDate.of(2024, 1, 1))
                .build();

        Member member2 = Member.builder()
                .name("김철수")
                .role(MemberRole.MEMBER)
                .birthday(LocalDate.of(1990, 1, 1))
                .workStartDate(LocalDate.of(2024, 1, 1))
                .build();

        Member member3 = Member.builder()
                .name("유재석")
                .role(MemberRole.MEMBER)
                .birthday(LocalDate.of(1990, 1, 1))
                .workStartDate(LocalDate.of(2024, 1, 1))
                .build();

        memberRepository.save(member1);
        memberRepository.save(member2);
        memberRepository.save(member3);

        // when
        mockMvc.perform(get("/member")
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());

        // then
        assertThat(memberRepository.findAll()).hasSize(3);
    }
}
