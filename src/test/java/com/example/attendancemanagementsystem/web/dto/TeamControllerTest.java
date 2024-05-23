package com.example.attendancemanagementsystem.web.dto;

import com.example.attendancemanagementsystem.domain.Team;
import com.example.attendancemanagementsystem.domain.TeamRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class TeamControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private TeamRepository teamRepository;

    @AfterEach
    void tearDown() {
        teamRepository.deleteAll();
    }

    @DisplayName("팀 전체조회")
    @Test
    void findAllTeam() throws Exception {
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
        mockMvc.perform(get("/team")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("팀1"))
                .andDo(print());

        // then
    }
}
