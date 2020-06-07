package com.ggomjae.web.toywebservice.web;

import com.ggomjae.web.toywebservice.service.FileService;
import com.ggomjae.web.toywebservice.service.S3Service;
import com.ggomjae.web.toywebservice.web.dto.PostsResponseDto;
import com.ggomjae.web.toywebservice.web.dto.PostsSaveRequestDto;
import com.ggomjae.web.toywebservice.web.dto.ProfileRequestDto;
import com.ggomjae.web.toywebservice.web.dto.ProfileResponseDto;
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

    private final FileService fileService;

    @PostMapping("/api/removeFile")
    public boolean removeFile(@RequestBody String filePath){

        String temp = filePath;

        int idx = filePath.lastIndexOf("/");
        temp = temp.substring(idx+1);
        idx = temp.indexOf('"');
        String realPath = temp.substring(0,idx);


        if(s3Service.delete(realPath)) {
            fileService.deleteProfile((long)1);
            return true;
        }

        return false;
    }

    @PostMapping("/api/fileupload")
    public String execWrite(@RequestParam("file") MultipartFile multipartFile)throws IOException {

        return s3Service.upload(multipartFile);
    }

    @PostMapping("/api/file")
    public Long save(@RequestBody ProfileRequestDto profileRequestDto){

        return fileService.save(profileRequestDto);
    }

    @GetMapping("/api/file/{id}")
    public ProfileResponseDto findById(@PathVariable Long id){
        ProfileResponseDto profileResponseDto = fileService.findById(id);
        logger.info(profileResponseDto.toString());

        return profileResponseDto;
    }
}
