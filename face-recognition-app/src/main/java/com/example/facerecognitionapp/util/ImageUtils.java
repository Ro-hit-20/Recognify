package com.example.facerecognitionapp.util;

import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.ByteBuffer;

public class ImageUtils {
    public static ByteBuffer convertToByteBuffer(MultipartFile file) throws IOException {
        return ByteBuffer.wrap(file.getBytes());
    }
}
