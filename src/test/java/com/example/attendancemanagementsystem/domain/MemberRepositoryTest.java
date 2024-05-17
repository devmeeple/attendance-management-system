package com.example.attendancemanagementsystem.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    TeamRepository TeamRepository;
    @Autowired
    private TeamRepository teamRepository;

    @DisplayName("직원을 등록한다")
    @Test
    void saveMember() {
        // given
        Team arsenal = Team.builder()
                .name("Arsenal")
                .build();

        teamRepository.save(arsenal);

        Member member = Member.builder()
                .name("Kendelle")
                .team(arsenal)
                .role(MemberRole.MEMBER)
                .birthday(LocalDate.of(1970, 1, 1))
                .workStartDate(LocalDate.now())
                .build();

        // when
        Member savedMember = memberRepository.save(member);

        // then
        assertThat(savedMember.getName()).isEqualTo("Kendelle");
        assertThat(savedMember.getTeam().getName()).isEqualTo("Arsenal");
        assertThat(savedMember.getRole()).isEqualTo(MemberRole.MEMBER);
        assertThat(savedMember.getBirthday()).isEqualTo(LocalDate.of(1970, 1, 1));
        assertThat(savedMember.getWorkStartDate()).isEqualTo(LocalDate.now());
    }

    @DisplayName("직원 전체를 조회한다")
    @Test
    void findAllMember() {
        // given
        Member member1 = Member.builder()
                .name("Elisabet")
                .role(MemberRole.MEMBER)
                .birthday(LocalDate.of(1970, 1, 1))
                .workStartDate(LocalDate.now())
                .build();
        Member member2 = Member.builder()
                .name("Jorrell")
                .role(MemberRole.MEMBER)
                .birthday(LocalDate.of(1963, 3, 23))
                .workStartDate(LocalDate.now())
                .build();

        memberRepository.save(member1);
        memberRepository.save(member2);

        // when
        List<Member> all = memberRepository.findAll();

        // then
        assertThat(all).hasSize(2);
        assertThat(all.get(0).getName()).isEqualTo("Elisabet");
        assertThat(all.get(0).getBirthday()).isEqualTo(LocalDate.of(1970, 1, 1));
    }
}
