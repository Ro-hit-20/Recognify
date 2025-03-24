package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
public class RekognitionController {
    private final RekognitionService rekognitionService;

    @Autowired
    public RekognitionController(RekognitionService rekognitionService) {
        this.rekognitionService = rekognitionService;
    }

    @GetMapping("/list-faces")
    public List<String> listFaces(@RequestParam String collectionId) {
        return rekognitionService.listFaces(collectionId);
    }
}
