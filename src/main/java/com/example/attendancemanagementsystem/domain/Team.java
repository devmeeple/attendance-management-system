package com.example.attendancemanagementsystem.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    private String manager;

    // 팀이있다 -> null을 가지지 못한다 -> 원시형
    private int memberCount;

    // 팀은 여러 명의 직원을 가질 수 있다.
    @OneToMany(mappedBy = "team")
    private List<Member> memberList = new ArrayList<>();

    @Builder
    public Team(String name) {
        this.name = name;
    }
}
