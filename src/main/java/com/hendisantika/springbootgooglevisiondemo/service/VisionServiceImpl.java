package com.hendisantika.springbootgooglevisiondemo.service;

import com.google.cloud.spring.vision.CloudVisionTemplate;
import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.Feature;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-google-vision-demo
 * User: hendi
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Link : s.id/hendisantika
 * Date: 9/20/2023
 * Time: 6:01 AM
 * To change this template use File | Settings | File Templates.
 */

@Service
@RequiredArgsConstructor
@Slf4j
public class VisionServiceImpl implements VisionService {

    private final CloudVisionTemplate cloudVisionTemplate;

    private final ResourceLoader resourceLoader;

    @Override
    public String extractTextFromImage(MultipartFile file) {
        return cloudVisionTemplate.
                extractTextFromImage(file.getResource());
    }

    @Override
    public String getLandmarkFromImage(MultipartFile file) {
        AnnotateImageResponse response = cloudVisionTemplate.analyzeImage(file.getResource(),
                Feature.Type.LANDMARK_DETECTION);
        return response.getLandmarkAnnotationsList().toString();
    }

    @Override
    public String detectLabelFromImage(MultipartFile file) {
        AnnotateImageResponse response = cloudVisionTemplate.analyzeImage(
                file.getResource(), Feature.Type.LABEL_DETECTION);
        return response.getLabelAnnotationsList().toString();
    }

}
