package kr.sfox.alpha.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kr.sfox.alpha.repository.MemberRepository;
import kr.sfox.alpha.domain.Member;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        Member member = memberRepository.findByUserId(userId);

        // UserDetails 객체 생성
        return User.builder()
            .username(member.getUserId())
            .password(member.getPassword())
            .accountExpired(false)
            .accountLocked(false)
            .credentialsExpired(false)
            .disabled(member.isEnabled() == false)
            .build();
    }
}
