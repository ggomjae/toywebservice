package com.ggomjae.web.toywebservice.web;

import com.ggomjae.web.toywebservice.service.S3Service;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
public class FileController {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    private final S3Service s3Service;

    @PostMapping("/api/removeFile")
    public boolean removeFile(@RequestBody String filePath){

        String temp = filePath;

        int idx = filePath.lastIndexOf("/");
        temp = temp.substring(idx+1);
        idx = temp.indexOf('"');
        String realPath = temp.substring(0,idx);
        logger.info(realPath);

        if(s3Service.delete(realPath))
            return true;

        return false;
    }

    @PostMapping("/api/fileupload")
    public String execWrite(@RequestParam("file") MultipartFile multipartFile)throws IOException {

        logger.info("--------------------");
        logger.info(String.valueOf(multipartFile));
        logger.info("---------------------");

        return s3Service.upload(multipartFile);
    }

}
