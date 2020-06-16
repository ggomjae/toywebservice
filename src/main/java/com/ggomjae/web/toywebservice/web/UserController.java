package com.ggomjae.web.toywebservice.web;

import com.ggomjae.web.toywebservice.config.security.JwtTokenProvider;
import com.ggomjae.web.toywebservice.domain.user.User;
import com.ggomjae.web.toywebservice.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping("/api/join")
    public Long join(@RequestBody Map<String, String> user) {
        return userRepository.save(User.builder()
                .email(user.get("email"))
                .password(passwordEncoder.encode(user.get("password")))
                .roles(Collections.singletonList("ROLE_USER"))
                .build()).getUserid();
    }

    @PostMapping("/api/login")
    public String login(@RequestBody Map<String, String> user) {
        User member = userRepository.findByEmail(user.get("email"))
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 E-MAIL 입니다."));
        if (!passwordEncoder.matches(user.get("password"), member.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }
        return jwtTokenProvider.createToken(member.getUsername(), member.getRoles());
    }


    @PostMapping("/api/user")
    public String information(@RequestBody String token){

        return jwtTokenProvider.getUserPk(token);
    }

    @PostMapping("/api/validate")
    public boolean checkToken(@RequestBody String token){

        return jwtTokenProvider.validateToken(token); // true면 만료x , false 면 만료o
    }

    @PostMapping("/api/test")
    public Authentication testMethod(@RequestBody String token){

        return jwtTokenProvider.getAuthentication(token);
    }
}
