package com.nur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class ShopifyApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopifyApiApplication.class, args);
	}

}
