package com.tiffin.foodDelivery.configs;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Component;

@Component
public class EnvironmentConfig {

    private final Dotenv dotenv;

    public EnvironmentConfig() {
        dotenv = Dotenv.load(); // Loads the .env file automatically
    }

    public String getEnvVariable(String key) {
        return dotenv.get(key);
    }
}
