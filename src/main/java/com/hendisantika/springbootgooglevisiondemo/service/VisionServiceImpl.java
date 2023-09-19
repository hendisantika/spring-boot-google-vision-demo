package com.hendisantika.springbootgooglevisiondemo.service;

import com.google.cloud.spring.vision.CloudVisionTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

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

}
