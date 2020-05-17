package com.piyush.contact;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.piyush.contact.repository")
public class ContactInformationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactInformationApplication.class, args);
	}

}
