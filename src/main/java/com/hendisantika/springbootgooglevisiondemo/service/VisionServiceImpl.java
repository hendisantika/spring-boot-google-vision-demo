package com.hendisantika.springbootgooglevisiondemo.service;

import com.google.cloud.spring.vision.CloudVisionTemplate;
import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.FaceAnnotation;
import com.google.cloud.vision.v1.Feature;
import com.google.cloud.vision.v1.Vertex;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

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

    @Override
    public List<String> extractTextFromPdf(MultipartFile file) {
        return cloudVisionTemplate.extractTextFromPdf(file.getResource());
    }

    @Override
    public byte[] detectFaceFromImage(MultipartFile file) throws IOException {
        AnnotateImageResponse response = cloudVisionTemplate.analyzeImage(
                file.getResource(), Feature.Type.FACE_DETECTION);
        Resource outputImageResource = resourceLoader.
                getResource("file:src/main/resources/output.jpg");

        return writeWithFaces(file,
                outputImageResource.getFile().toPath(),
                response.getFaceAnnotationsList());
    }

    private static byte[] writeWithFaces(MultipartFile file, Path outputPath, List<FaceAnnotation> faces)
            throws IOException {

        BufferedImage img = ImageIO.read(file.getInputStream());
        annotateWithFaces(img, faces);

        //Write file to resource folder, check resources folder
        ImageIO.write(img, "jpg", outputPath.toFile());

        //And
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(img, "jpg", baos);

        //BufferedImage to byte array
        return baos.toByteArray();
    }

    public static void annotateWithFaces(BufferedImage img, List<FaceAnnotation> faces) {
        for (FaceAnnotation face : faces) {
            annotateWithFace(img, face);
        }
    }

    private static void annotateWithFace(BufferedImage img, FaceAnnotation face) {
        Graphics2D gfx = img.createGraphics();
        Polygon poly = new Polygon();
        for (Vertex vertex : face.getFdBoundingPoly().getVerticesList()) {
            poly.addPoint(vertex.getX(), vertex.getY());
        }
        gfx.setStroke(new BasicStroke(5));
        gfx.setColor(new Color(0xFFFF00));
        gfx.draw(poly);
    }

}
