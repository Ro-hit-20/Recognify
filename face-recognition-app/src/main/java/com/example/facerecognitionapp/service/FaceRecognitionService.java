package com.example.facerecognitionapp.service;

import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.services.rekognition.RekognitionClient;
import software.amazon.awssdk.services.rekognition.model.*;
import org.springframework.stereotype.Service;

import java.nio.ByteBuffer;
import java.util.List;

@Service
public class FaceRecognitionService {

    private final RekognitionClient rekognitionClient;

    public FaceRecognitionService(RekognitionClient rekognitionClient) {
        this.rekognitionClient = rekognitionClient;
    }

    public String compareFaces(ByteBuffer sourceImage, ByteBuffer targetImage) {
        try {
            // ✅ Convert ByteBuffer to SdkBytes
            SdkBytes sourceBytes = SdkBytes.fromByteBuffer(sourceImage);
            SdkBytes targetBytes = SdkBytes.fromByteBuffer(targetImage);

            // ✅ Create Image objects
            Image sourceImg = Image.builder().bytes(sourceBytes).build();
            Image targetImg = Image.builder().bytes(targetBytes).build();

            // ✅ Configure CompareFacesRequest
            CompareFacesRequest request = CompareFacesRequest.builder()
                    .sourceImage(sourceImg)
                    .targetImage(targetImg)
                    .similarityThreshold(80F)  // Set confidence threshold
                    .build();

            // ✅ Send request to AWS Rekognition
            CompareFacesResponse response = rekognitionClient.compareFaces(request);
            List<CompareFacesMatch> faceMatches = response.faceMatches();

            // ✅ Check results
            if (!faceMatches.isEmpty()) {
                float confidence = faceMatches.get(0).similarity();
                return "Faces match with " + confidence + "% confidence.";
            } else {
                return "No matching faces found.";
            }

        } catch (RekognitionException e) {
            return "Error processing face recognition: " + e.getMessage();
        }
    }
}
