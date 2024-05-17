package com.example.attendancemanagementsystem.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TeamTest {

    @DisplayName("팀을 등록한다")
    @Test
    void saveTeam() {
        // given
        Team team = Team.builder()
                .name("Arsenal")
                .build();

        // when + then
        assertThat(team.getName()).isEqualTo("Arsenal");
    }
}
