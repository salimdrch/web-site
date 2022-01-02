package com.website.website;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class WebSiteApplication {
	public static void main(String[] args) {
		SpringApplication.run(WebSiteApplication.class, args);
	}
}
