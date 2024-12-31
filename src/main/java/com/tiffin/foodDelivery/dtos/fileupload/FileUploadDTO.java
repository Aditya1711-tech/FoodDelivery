package com.tiffin.foodDelivery.dtos.fileupload;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class FileUploadDTO {
    private MultipartFile file;
    private String folder;
}
