package com.campuslab.platform.u20241f109.shared.infrastructure.documentation;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean
    public OpenAPI campusLabOpenApi() {
        return new OpenAPI().info(new Info()
                .title("CampusLab Equipment Reservations API")
                .version("1.0.0")
                .description("Create equipment reservations for university laboratory activities."));
    }
}