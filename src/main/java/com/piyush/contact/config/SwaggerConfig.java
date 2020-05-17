package com.piyush.contact.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger configuration
 * 
 * @author PIYUSH ANJIKAR
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.piyush.contact.controller"))
				.paths(PathSelectors.regex("/contact.*")).build().apiInfo(metaData());
	}

	/**
	 * Meta data information
	 * 
	 * @return ApiInfo
	 */
	private ApiInfo metaData() {
		ApiInfo apiInfo = new ApiInfo("Spring Boot REST API", "Spring Boot REST API for Contact Information", "1.0",
				"Terms of service", new Contact("Piyush Anjikar", "", "piyush.anjikar@gmail.com"), "", "");
		return apiInfo;
	}
}
