package dev.melik.bootcamp.week3.q2.controller.member;

import dev.melik.bootcamp.week3.q2.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/members")
    @ResponseStatus(HttpStatus.CREATED)
    public MemberCreateResponse createMember(@RequestBody @Valid MemberRequest memberRequest){
        return MemberCreateResponse.fromMember(memberService.createMember(memberRequest.toMember()));
    }
}
