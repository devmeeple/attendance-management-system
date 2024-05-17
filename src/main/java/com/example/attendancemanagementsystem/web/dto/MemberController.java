package com.example.attendancemanagementsystem.web.dto;

import com.example.attendancemanagementsystem.service.MemberService;
import com.example.attendancemanagementsystem.web.dto.response.MemberResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/member")
    public void joinMember(@RequestBody MemberJoinRequest request) {
        log.debug("request = {}", request);
        memberService.joinMember(request);
    }

    // 응답객체 분리 필요한 정보만 반환하기
    @GetMapping("/member")
    public List<MemberResponse> findAllMember() {
        return memberService.findAllMember();
    }
}
