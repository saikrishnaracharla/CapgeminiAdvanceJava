package com.cg.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.cg.services.FileStorageService;

@RestController
@RequestMapping("/files")
public class FileController {

    @Autowired
    FileStorageService fileService;

    @PostMapping(value = "/upload", consumes = "multipart/form-data")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        return fileService.uploadFile(file);
    }
    @GetMapping("/download/{filename}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String filename) {
        Resource resource = fileService.downloadFile(filename);
        return ResponseEntity.ok()
                .header("Content-Disposition",
                        "attachment; filename=\"" + resource.getFilename() + "\"")
                .header("Content-Type", "application/octet-stream")
                .body(resource);
    }
    
}
