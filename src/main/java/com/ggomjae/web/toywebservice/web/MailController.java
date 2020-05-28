package com.ggomjae.web.toywebservice.web;


import com.ggomjae.web.toywebservice.service.MailService;
import com.ggomjae.web.toywebservice.web.dto.MailDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MailController {

    private final MailService mailService;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping("/api/mail")
    public void execMail(@RequestBody MailDto mailDto) {
        logger.info("mail test");
        mailService.mailSend(mailDto);
    }
}