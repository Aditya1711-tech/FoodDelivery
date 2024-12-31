package com.tiffin.foodDelivery.configs;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {

    private final String cloudinaryName;
    private final String cloudinaryAPIKey;
    private final String cloudinaryAPISecret;

    public CloudinaryConfig(EnvironmentConfig environmentConfig) {
        this.cloudinaryName = environmentConfig.getEnvVariable("CLOUDINARY_KEY_NAME");
        this.cloudinaryAPIKey = environmentConfig.getEnvVariable("CLOUDINARY_API_KEY");
        this.cloudinaryAPISecret = environmentConfig.getEnvVariable("CLOUDINARY_API_SECRET");
    }

    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", cloudinaryName,
                "api_key", cloudinaryAPIKey,
                "api_secret", cloudinaryAPISecret
        ));
    }
}

