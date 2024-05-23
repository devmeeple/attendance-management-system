package com.example.attendancemanagementsystem.web.dto;

import com.example.attendancemanagementsystem.domain.MemberRole;
import com.example.attendancemanagementsystem.web.dto.request.MemberJoinRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class MemberJoinRequestTest {

    @DisplayName("직원이 입사한다")
    @Test
    void joinMember() {
        // given
        MemberJoinRequest request = MemberJoinRequest.builder()
                .name("홍길동")
                .role(MemberRole.MEMBER)
                .birthday(LocalDate.of(1990, 1, 1))
                .workStartDate(LocalDate.of(2024, 1, 1))
                .build();

        // when + then
        assertThat(request.name()).isEqualTo("홍길동");
        assertThat(request.role()).isEqualTo(MemberRole.MEMBER);
        assertThat(request.birthday()).isEqualTo(LocalDate.of(1990, 1, 1));
        assertThat(request.workStartDate()).isEqualTo(LocalDate.of(2024, 1, 1));
    }
}
