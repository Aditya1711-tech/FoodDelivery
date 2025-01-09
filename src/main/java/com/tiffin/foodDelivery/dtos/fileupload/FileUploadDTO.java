package com.tiffin.foodDelivery.dtos.fileupload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
public class FileUploadDTO {
    private MultipartFile file;
    private String folder;

    public FileUploadDTO(MultipartFile file) {
        this.file = file;
    }
}
