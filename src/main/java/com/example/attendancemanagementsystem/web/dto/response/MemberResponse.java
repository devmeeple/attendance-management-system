package com.example.attendancemanagementsystem.web.dto.response;

import com.example.attendancemanagementsystem.domain.Member;
import com.example.attendancemanagementsystem.domain.Team;
import lombok.Builder;

import java.util.Optional;

/**
 * 서비스 정책에 맞는 응답 클래스
 */
@Builder
public record MemberResponse(String name, String teamName, String role, String birthday, String workStartDate) {
    public static MemberResponse from(Member member) {
        return MemberResponse.builder()
                .name(member.getName())
                .teamName(Optional.ofNullable(member.getTeam()).map(Team::getName).orElse("FA"))
                .role(member.getRole().name())
                .birthday(member.getBirthday().toString())
                .workStartDate(member.getWorkStartDate().toString())
                .build();
    }
}
