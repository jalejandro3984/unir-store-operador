package com.unir.store_core.config;

import org.jasypt.util.password.BasicPasswordEncryptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public BasicPasswordEncryptor passwordEncryptor() {
        return new BasicPasswordEncryptor();
    }
}
