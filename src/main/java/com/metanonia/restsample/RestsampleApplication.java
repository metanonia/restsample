package com.metanonia.restsample;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RestsampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestsampleApplication.class, args);
    }

    // http://host:port/
    @Bean
    public OpenAPI customOpenAPI(@Value("${springdoc.version}") String appVersion) {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("Sample Rest").version(appVersion)
                        .license(new License().name("Apache 2.0").url("https://metanonia.com")));
    }
}
