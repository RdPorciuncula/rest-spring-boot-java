package br.com.java.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

    @Bean
    OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("Java API Spring Boot 3")
						.version("v1")
						.description("Java API Spring Boot 3")
						.termsOfService("")
						.license(
							new License()
								.name("Apache 2.0")
								.url("")
							)
						);
	}
}
