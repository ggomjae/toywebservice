package com.ggomjae.web.toywebservice.web;

import com.ggomjae.web.toywebservice.config.security.JwtTokenProvider;
import com.ggomjae.web.toywebservice.domain.user.User;
import com.ggomjae.web.toywebservice.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;

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

//    @PostMapping("/api/user")
//    public String information(HttpServletRequest request){
//
//        String token = jwtTokenProvider.resolveToken(request);
//        return jwtTokenProvider.getUserPk(token);
//    }

    @PostMapping("/api/user")
    public String information(@RequestBody String token){

        return jwtTokenProvider.getUserPk(token);
    }

    @PostMapping("/api/test")
    public String testMethod(){
        return "testOK";
    }
}
