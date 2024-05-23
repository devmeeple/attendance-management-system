package com.example.attendancemanagementsystem.service;

import com.example.attendancemanagementsystem.domain.Team;
import com.example.attendancemanagementsystem.domain.TeamRepository;
import com.example.attendancemanagementsystem.web.dto.response.TeamResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest
class TeamServiceTest {

    @Autowired
    private TeamService teamService;

    @Autowired
    private TeamRepository teamRepository;

    @Test
    void registerTeam() {
    }

    @DisplayName("팀 전체 조회")
    @Test
    void findAllTeam() {
        // given
        Team team1 = Team.builder()
                .name("팀1")
                .build();
        teamRepository.save(team1);

        Team team2 = Team.builder()
                .name("팀2")
                .build();
        teamRepository.save(team2);

        // when
        List<TeamResponse> response = teamService.findAllTeam();

        // then
        assertThat(response.size()).isEqualTo(2);
    }
}
