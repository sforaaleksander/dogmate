package com.codecool.dogmate.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SwaggerConfiguration {

    // documentation available at http://localhost:8080/swagger-ui/
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/api/v1/**"))
                .build()
                .apiInfo(apiDetails());
    }

    private ApiInfo apiDetails() {
        return new ApiInfo(
                "DogMate API",
                "API for DogMate application",
                "1.0",
                null,
                new Contact("uber-dream-team", "https://github.com/sforaaleksander/dogmate", "jira@uber-dream-team.atlassian.net"),
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0.html",
                Collections.emptyList()
        );
    }
}
