package com.unir.store_core;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEncryptableProperties
public class StoreCoreApplication {
	@Bean
	public RestTemplate restTemplate() { return new RestTemplate(); }

	public static void main(String[] args) {
		SpringApplication.run(StoreCoreApplication.class, args);
	}

}
