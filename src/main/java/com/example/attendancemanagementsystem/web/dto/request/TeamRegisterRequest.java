package com.example.attendancemanagementsystem.web.dto.request;

import com.example.attendancemanagementsystem.domain.Team;
import lombok.Builder;

@Builder
public record TeamRegisterRequest(String name) {
    public Team toEntity() {
        return Team.builder()
                .name(name)
                .build();
    }
}
