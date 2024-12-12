package kr.sfox.alpha.configuration;

import kr.sfox.alpha.Service.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    private final CustomUserDetailsService customUserDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                // 다음과 같이 엔드포인트별 접근 제어 설정
                .authorizeHttpRequests(authorize -> authorize
                        // 회원가입 엔드포인트는 인증 없이 접근 가능
                        .requestMatchers("/members/register").permitAll()
                        // 나머지 요청은 인증 필요
                        .anyRequest().authenticated()
                )
                // HTTP Basic 인증 사용
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    /**
     * BCryptPasswordEncoder를 빈으로 등록
     * @return BCryptPasswordEncoder 인스턴스
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
