package com.example.TodoRestApi.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.util.Arrays;


@RestController
@RequestMapping("/file")
public class fileController {
    Logger logger = LoggerFactory.getLogger(fileController.class);

    @PostMapping("/single")
    public String uploadSingle(@RequestParam("image") MultipartFile file){
        logger.info("Name {}",file.getName());
        logger.info("Content {}",file.getContentType());
        logger.info("File size {}",file.getSize());

        return "File Test";
    }

    @PostMapping("/multiple/upload")
    public String uploadMultiple(@RequestParam("Files") MultipartFile[] files ){

        Arrays.stream(files).forEach(file -> {
            logger.info("File Name {}",file.getOriginalFilename());
        });
        return "Multiple files handled";
    }

    @GetMapping("/serve-image")
    public void serveImageHandler(HttpServletResponse response){
        try{
            FileInputStream fileInputStream = new FileInputStream("images/time.png");
            response.setContentType(MediaType.IMAGE_PNG_VALUE);
            StreamUtils.copy(fileInputStream,response.getOutputStream());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
