package com.tiffin.foodDelivery.utils.functions;

import org.springframework.web.multipart.MultipartFile;

public class FileUtils {
    public static String getFileExtension(MultipartFile file){
        String filename = file.getOriginalFilename();

        if (filename != null && !filename.isEmpty()) {
            // Get the file extension by splitting the filename at the dot '.'
            int dotIndex = filename.lastIndexOf(".");
            if (dotIndex != -1) {
                return filename.substring(dotIndex + 1);
            }
        }
        return "";
    }
}
