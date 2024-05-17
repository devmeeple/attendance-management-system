package com.example.attendancemanagementsystem.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class TeamRepositoryTest {

    @Autowired
    private TeamRepository teamRepository;

    @DisplayName("팀을 등록한다")
    @Test
    void saveTeam() {
        // given
        Team team = Team.builder()
                .name("Arsenal")
                .build();

        // when
        Team savedTeam = teamRepository.save(team);

        // then
        assertThat(savedTeam.getName()).isEqualTo("Arsenal");
    }

    @DisplayName("전체 팀을 조회한다")
    @Test
    void findAll() {
        // given
        Team team1 = Team.builder()
                .name("Arsenal")
                .build();
        Team team2 = Team.builder()
                .name("Chelsea")
                .build();

        teamRepository.save(team1);
        teamRepository.save(team2);

        // when
        List<Team> teams = teamRepository.findAll();

        // then
        assertThat(teams).hasSize(2);

        assertThat(teams.get(0).getName()).isEqualTo("Arsenal");
        assertThat(teams.get(0).getManager()).isNull();
        assertThat(teams.get(0).getMemberCount()).isEqualTo(0);
    }
}
