package com.example.facerecognitionapp.model;

public class FaceMatchResult {
    private float similarity;
    private boolean match;

    public FaceMatchResult(float similarity, boolean match) {
        this.similarity = similarity;
        this.match = match;
    }

    public float getSimilarity() {
        return similarity;
    }

    public boolean isMatch() {
        return match;
    }
}
