package kr.sfox.alpha.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.sfox.alpha.repository.MemberRepository;
import kr.sfox.alpha.domain.Member;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Long join(Member member) {
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        memberRepository.save(member);
        return member.getId();
    }

    @Transactional
    public Member findById(Long id) {
        return memberRepository.findById(id);
    }

    @Transactional
    public boolean removeMember(String userId) {
        Member member = memberRepository.findByUserId(userId);
        memberRepository.removeMember(member);
        Member newMember = memberRepository.findById(member.getId());
        return member != newMember;
    }
}
