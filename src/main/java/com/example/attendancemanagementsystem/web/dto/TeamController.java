package com.example.attendancemanagementsystem.web.dto;

import com.example.attendancemanagementsystem.service.TeamService;
import com.example.attendancemanagementsystem.web.dto.response.TeamResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class TeamController {

    private final TeamService teamService;

    @PostMapping("/team")
    public void registerTeam(@RequestBody TeamRegisterRequest request) {
        teamService.registerTeam(request);
    }

    @GetMapping("/team")
    public List<TeamResponse> findAllTeam() {
        return teamService.findAllTeam();
    }
}
