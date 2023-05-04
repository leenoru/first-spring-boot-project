package com.playdata.springbootprojectre.config.auth;

import com.playdata.springbootprojectre.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@EnableWebSecurity // Spring Security 설정을 활성화
@Configuration // Spring 설정 클래스
public class SecurityConfig {
    private final CustomOauth2UserService customOauth2UserService;

    @Bean
    public SecurityFilterChain FilterChain(HttpSecurity http) throws Exception {
        http
                //csrf() 메소드는 CSRF(Cross-Site Request Forgery) 공격에 대해 방지를 위한 설정
                // 위 기능을 사용하면 제약이 많아짐으로 disable이라는 메소드를 호출해서 비활성화
                .csrf().disable()
                //header() 메소드는 HTTP 응답 헤더
                //이 메소드의 frameOptions().disable() 메소드를 호출해서 X-Frame-Options(iframe) 헤더 설정 비성화
                .headers().frameOptions().disable()
                    .and()
                        // URL 별 권한 관리
                        .authorizeHttpRequests()
                        // 권한 관리 대상을 URL로 지정, 아래 패턴의 URL에 대해서 전체 접근하는 사용자에 대해 모두 허가
                        .requestMatchers("/", "/css/**", "/images/**", "/js/**", "/profile").permitAll()
                        // USER라고 하는 권한 가진 사람만 "/api/v1/**" 하위 URL에 대해서 허가
                        .requestMatchers("/api/v1/**").hasRole(Role.USER.name())
                        // 나머지 URL에 대해서 설정
                        .anyRequest().authenticated()
                .and()
                    // 로그아웃 기능에 대한 설정
                   .logout()
                        // 로그아웃 이후에 이동되는 URL
                        .logoutSuccessUrl("/")
                .and()
                    // OAuth2 로그인 기능에 대한 설정
                    .oauth2Login()
                        // OAuth2 로그인이 성공된 이후 사용자 정보를 가져올 때의 설정
                        .userInfoEndpoint()
                            // 소셜 로그인 성공 시 후속 처리에 대한 인터페이스 구현체를 등록
                           .userService(customOauth2UserService);
        return http.build();
    }
}
