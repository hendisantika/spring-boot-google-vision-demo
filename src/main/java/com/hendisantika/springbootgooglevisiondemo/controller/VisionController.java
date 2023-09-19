package com.hendisantika.springbootgooglevisiondemo.controller;

import com.hendisantika.springbootgooglevisiondemo.service.VisionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-google-vision-demo
 * User: hendi
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Link : s.id/hendisantika
 * Date: 9/20/2023
 * Time: 6:07 AM
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequiredArgsConstructor
@Slf4j
public class VisionController {

    private final VisionService visionService;

    //Extract the text in an image
    @PostMapping("/extractTextFromImage")
    public String extractTextFromImage(@RequestParam MultipartFile file) {
        log.info("Extract Text From Image ... ");
        return visionService.extractTextFromImage(file);
    }

    //Get landmark from Image
    @PostMapping("/getLandmarkFromImage")
    public String getLandmarkFromImage(@RequestParam MultipartFile file) {
        return visionService.getLandmarkFromImage(file);
    }

    //Detect label from image
    @PostMapping("/detectLabelFromImage")
    public String detectLabelFromImage(@RequestParam MultipartFile file) {
        return visionService.detectLabelFromImage(file);
    }

}
