package com.hendisantika.springbootgooglevisiondemo.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-google-vision-demo
 * User: hendi
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Link : s.id/hendisantika
 * Date: 9/20/2023
 * Time: 6:00 AM
 * To change this template use File | Settings | File Templates.
 */
public interface VisionService {
    String extractTextFromImage(MultipartFile file);

    String getLandmarkFromImage(MultipartFile file);

    String detectLabelFromImage(MultipartFile file);

    List<String> extractTextFromPdf(MultipartFile file);

    byte[] detectFaceFromImage(MultipartFile file) throws IOException;
}
