package com.example.facerecognitionapp.controller;

import com.example.facerecognitionapp.service.FaceRecognitionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.ByteBuffer;

@RestController
@RequestMapping("/api/face")
public class FaceRecognitionController {

    private final FaceRecognitionService faceRecognitionService;

    public FaceRecognitionController(FaceRecognitionService faceRecognitionService) {
        this.faceRecognitionService = faceRecognitionService;
    }

    @PostMapping("/compare")
    public ResponseEntity<String> compareFaces(
            @RequestParam("sourceImage") MultipartFile sourceImage,
            @RequestParam("targetImage") MultipartFile targetImage) {
        try {
            // ✅ Convert MultipartFile to ByteBuffer
            ByteBuffer sourceBuffer = ByteBuffer.wrap(sourceImage.getBytes());
            ByteBuffer targetBuffer = ByteBuffer.wrap(targetImage.getBytes());

            // ✅ Call the correct method
            String result = faceRecognitionService.compareFaces(sourceBuffer, targetBuffer);
            return ResponseEntity.ok(result);

        } catch (IOException e) {
            return ResponseEntity.badRequest().body("Error reading images: " + e.getMessage());
        }
    }
}
