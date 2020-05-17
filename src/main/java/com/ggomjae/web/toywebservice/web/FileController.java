package com.ggomjae.web.toywebservice.web;

import com.ggomjae.web.toywebservice.service.S3Service;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
public class FileController {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    private final S3Service s3Service;

    @PostMapping("/api/fileupload")
    public String execWrite(@RequestParam("file") MultipartFile multipartFile)throws IOException {

        logger.info("--------------------");
        logger.info(String.valueOf(multipartFile));
        logger.info("---------------------");

        return s3Service.upload(multipartFile);
    }

}
