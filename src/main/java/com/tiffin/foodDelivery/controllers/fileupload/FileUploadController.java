package com.tiffin.foodDelivery.controllers.fileupload;

import com.tiffin.foodDelivery.dtos.fileupload.FileUploadDTO;
import com.tiffin.foodDelivery.services.fileupload.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/files")
public class FileUploadController {

    private final FileUploadService cloudinaryService;

    @Autowired
    public FileUploadController(FileUploadService cloudinaryService) {
        this.cloudinaryService = cloudinaryService;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@ModelAttribute FileUploadDTO fileUploadDTO) {
        try {
            String url = cloudinaryService.uploadFile(fileUploadDTO);
            return ResponseEntity.ok(url);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File upload failed: " + e.getMessage());
        }
    }
}

