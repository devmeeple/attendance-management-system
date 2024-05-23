package com.example.attendancemanagementsystem.web.dto.response;

import com.example.attendancemanagementsystem.domain.Team;
import lombok.Builder;

@Builder
public record TeamResponse(String name, String manager, int memberCount) {
    public static TeamResponse from(Team team) {
        return TeamResponse.builder()
                .name(team.getName())
                .manager(team.getManager())
                .memberCount(team.getMemberCount())
                .build();
    }
}
