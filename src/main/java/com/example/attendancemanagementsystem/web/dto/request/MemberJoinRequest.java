package com.example.attendancemanagementsystem.web.dto.request;

import com.example.attendancemanagementsystem.domain.Member;
import com.example.attendancemanagementsystem.domain.MemberRole;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record MemberJoinRequest(String name, MemberRole role, LocalDate birthday, LocalDate workStartDate) {

    public Member toEntity() {
        return Member.builder()
                .name(name)
                .role(role)
                .birthday(birthday)
                .workStartDate(workStartDate)
                .build();
    }
}
