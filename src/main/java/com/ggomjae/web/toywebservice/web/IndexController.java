package com.ggomjae.web.toywebservice.web;

import com.ggomjae.web.toywebservice.config.auth.dto.SessionUser;
import com.ggomjae.web.toywebservice.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@RequiredArgsConstructor
@RestController
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/login")
    public boolean index(){

        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        log.println(1111);

        if(user != null)
            return true;
        return false;
    }
}
