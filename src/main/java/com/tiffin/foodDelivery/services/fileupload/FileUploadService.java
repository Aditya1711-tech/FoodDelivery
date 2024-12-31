package com.tiffin.foodDelivery.services.fileupload;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.tiffin.foodDelivery.dtos.fileupload.FileUploadDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class FileUploadService {

    private final Cloudinary cloudinary;

    private Map uploadParams = ObjectUtils.asMap(
            "use_filename", true,
            "unique_filename", true,
//            "filename", "thisIsName",
            "folder", "general-files"
    );

    @Autowired
    public FileUploadService(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    public String uploadFile(FileUploadDTO fileUploadDTO) throws IOException {
        MultipartFile file = fileUploadDTO.getFile();
        if(file != null){
            uploadParams.put("filename",  file.getOriginalFilename());
            if(fileUploadDTO.getFolder() != null) uploadParams.put("folder", fileUploadDTO.getFolder());
            Map<String, Object> uploadResult = cloudinary.uploader().upload(file.getBytes(), uploadParams);
            return (String) uploadResult.get("secure_url"); // Returns the uploaded file's secure URL
        }
        return "";
    }
}
