package kr.sfox.alpha.api;

import kr.sfox.alpha.Service.MemberService;
import kr.sfox.alpha.api.memberDto.request.JoinMemberRequest;
import kr.sfox.alpha.api.memberDto.response.JoinMemberResponse;
import kr.sfox.alpha.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberApiController {
    private final MemberService memberService;

    @PostMapping
    public JoinMemberResponse join(@RequestBody JoinMemberRequest member) {
        Member newMember = new Member();
        newMember.setUserId(member.getUserId());
        newMember.setPassword(member.getPassword());

        Long resultId = memberService.join(newMember);

        return new JoinMemberResponse(resultId);
    }
}
