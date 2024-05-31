package tech.SimpleNews.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
    servers = {
        @Server(url = "/", description = "Default Server URL")
    },
    info = @Info(title = "CareZoom API 명세서",
        description = "uri에 버전은 기제하지 않음",
        version = "v1"))
@Configuration
@RequiredArgsConstructor
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi chatOpenApi() {
        // "/v1/**" 경로에 매칭되는 API를 그룹화하여 문서화한다.
        String[] paths = {"/api/**"};

        return GroupedOpenApi.builder()
            .group("CareZoom API v1")  // 그룹 이름을 설정한다.
            .pathsToMatch(paths)     // 그룹에 속하는 경로 패턴을 지정한다.
            .build();
    }
}