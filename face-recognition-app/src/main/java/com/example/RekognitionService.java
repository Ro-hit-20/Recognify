package com.example;

import org.springframework.stereotype.Service;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.rekognition.RekognitionClient;
import software.amazon.awssdk.services.rekognition.model.ListFacesRequest;
import software.amazon.awssdk.services.rekognition.model.ListFacesResponse;
import software.amazon.awssdk.services.rekognition.model.RekognitionException;

import java.util.List;
import java.util.stream.Collectors;

@Service  // Spring Service annotation
public class RekognitionService {
    private final RekognitionClient rekognitionClient;

    public RekognitionService() {
        this.rekognitionClient = RekognitionClient.builder()
                .region(Region.US_EAST_1) // Change to your AWS region
                .credentialsProvider(DefaultCredentialsProvider.create())
                .build();
    }

    public List<String> listFaces(String collectionId) {
        try {
            ListFacesRequest request = ListFacesRequest.builder()
                    .collectionId(collectionId)
                    .build();

            ListFacesResponse response = rekognitionClient.listFaces(request);

            // Convert the response to a list of face IDs
            return response.faces().stream()
                    .map(face -> face.faceId())
                    .collect(Collectors.toList());

        } catch (RekognitionException e) {
            throw new RuntimeException("Error listing faces: " + e.awsErrorDetails().errorMessage());
        }
    }
}
