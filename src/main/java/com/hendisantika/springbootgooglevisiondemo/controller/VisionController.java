package com.hendisantika.springbootgooglevisiondemo.controller;

import com.hendisantika.springbootgooglevisiondemo.service.VisionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

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
public class VisionController {

    private final VisionService visionService;

}
