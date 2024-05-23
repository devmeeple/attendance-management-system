package com.example.attendancemanagementsystem.service;

import com.example.attendancemanagementsystem.domain.TeamRepository;
import com.example.attendancemanagementsystem.web.dto.request.TeamRegisterRequest;
import com.example.attendancemanagementsystem.web.dto.response.TeamResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TeamService {

    private final TeamRepository teamRepository;

    @Transactional
    public void registerTeam(TeamRegisterRequest request) {
        teamRepository.save(request.toEntity());
    }

    @Transactional
    public List<TeamResponse> findAllTeam() {
        return teamRepository.findAll().stream()
                .map(TeamResponse::from)
                .toList();
    }
}
