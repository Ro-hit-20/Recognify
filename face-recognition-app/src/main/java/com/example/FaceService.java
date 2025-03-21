package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FaceService {

    @Autowired
    private FaceRepository faceRepository;

    public List<Face> getAllFaces() {
        return faceRepository.findAll();
    }

    public Face saveFace(Face face) {
        return faceRepository.save(face);
    }
}