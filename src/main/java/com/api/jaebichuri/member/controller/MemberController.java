package com.api.jaebichuri.member.controller;

import com.api.jaebichuri.member.dto.MemberInfoRequestDto;
import com.api.jaebichuri.member.entity.Member;
import com.api.jaebichuri.member.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
@Tag(name = "멤버 API")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/info")
    @Operation(summary = "사용자 추가 정보 입력 API")
    public ResponseEntity<String> saveMemberInfo(@AuthenticationPrincipal Member member,
        @Valid @RequestBody MemberInfoRequestDto requestDto) {
        memberService.saveMemberInfo(member, requestDto);
        return ResponseEntity.ok("사용자 정보 저장 완료");
    }
}