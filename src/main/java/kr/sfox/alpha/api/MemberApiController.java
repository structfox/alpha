package kr.sfox.alpha.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.sfox.alpha.Service.MemberService;
import kr.sfox.alpha.api.memberDto.MemberDeleteResponse;
import kr.sfox.alpha.api.memberDto.MemberInfoResponse;
import kr.sfox.alpha.api.memberDto.request.JoinMemberRequest;
import kr.sfox.alpha.api.memberDto.response.JoinMemberResponse;
import kr.sfox.alpha.domain.Member;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberApiController {

    private final MemberService memberService;

    @PostMapping("/register")
    public JoinMemberResponse join(@RequestBody JoinMemberRequest member) {
        Member newMember = new Member();
        newMember.setUserId(member.getUserId());
        newMember.setPassword(member.getPassword());

        Long resultId = memberService.join(newMember);

        return new JoinMemberResponse(resultId);
    }

    @GetMapping("/info/{id}")
    public MemberInfoResponse info(@PathVariable Long id) {
        Member member = memberService.findById(id);

        MemberInfoResponse response = new MemberInfoResponse();
        response.setId(member.getId());
        response.setUserId(member.getUserId());

        return response;
    }

    @DeleteMapping("/{userId}")
    public MemberDeleteResponse remove(@PathVariable String userId) {
        boolean result = memberService.removeMember(userId);
        return new MemberDeleteResponse(result);
    }
}
