package com.example.swagger3knife4j.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.parameters.Parameter;
import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.customizers.OperationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.example.swagger3knife4j.constants.PathConstants.PRIVATE_PATH;
import static com.example.swagger3knife4j.constants.PathConstants.PUBLIC_PATH;

/**
 * @Author Wang Junwei
 * @Date 2022/7/1 11:24
 * @Description open api配置
 */

@Configuration
public class OpenApiConfig {


    @Bean
    public OpenAPI api() {
        return new OpenAPI().info(new Info().title("文档标题")
                .description("文档描述")
                .version("v1.0.0"));
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("公共接口")
                .pathsToMatch(PUBLIC_PATH + "/**")
                .build();
    }

    @Bean
    public GroupedOpenApi tokenApi(OperationCustomizer operationCustomizer) {
        return GroupedOpenApi.builder()
                .group("鉴权")
                .pathsToMatch(PRIVATE_PATH + "/**")
                .addOperationCustomizer(operationCustomizer)
                .build();
    }

    @Bean
    public OperationCustomizer operationCustomizer() {
        return (operation, handlerMethod) -> operation.addParametersItem(
                new Parameter()
                        .in("header")
                        .required(true)
                        .description("token 验证")
                        .name("token"));
    }

}
