package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/faces")
public class FaceController {

    @Autowired
    private FaceService faceService;

    @GetMapping
    public List<Face> getAllFaces() {
        return faceService.getAllFaces();
    }

    @PostMapping
    public Face saveFace(@RequestBody Face face) {
        return faceService.saveFace(face);
    }
}