package com.cg.services;


import java.io.IOException;
import java.nio.file.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class FileStorageService {

    @Value("${file.upload-dir}")
    private String uploadDir;

    public String uploadFile(MultipartFile file) {

        try {
            Path path = Paths.get(uploadDir);

            if(!Files.exists(path)) {
                Files.createDirectories(path);
            }

            Path filePath = path.resolve(file.getOriginalFilename());

            Files.copy(file.getInputStream(), filePath);

            return "File uploaded successfully";

        } catch(IOException e) {
            throw new RuntimeException("File upload failed");
        }
    }

    public Resource downloadFile(String filename) {

        try {
            Path filePath = Paths.get(uploadDir).resolve(filename);

            return new UrlResource(filePath.toUri());

        } catch(Exception e) {
            throw new RuntimeException("File not found");
        }
    }
}
