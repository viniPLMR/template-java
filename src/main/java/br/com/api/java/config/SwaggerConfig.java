package br.com.api.java.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Value("${api.version}")
	private String version;
	
	private List<ResponseMessage> defaultReturns = new ArrayList<>();;
	
	@Bean
	public Docket api() {
		ResponseMessage response500 = new ResponseMessage(500, "Internal server error", null, new HashMap<>(), new ArrayList<>());
		ResponseMessage response400 = new ResponseMessage(400, "Bad request", null, new HashMap<>(), new ArrayList<>());
		defaultReturns.add(response500);
		defaultReturns.add(response400);
		
		return new Docket(DocumentationType.SWAGGER_2)
				.useDefaultResponseMessages(false)
				.globalResponseMessage(RequestMethod.GET, defaultReturns)
				.globalResponseMessage(RequestMethod.POST, defaultReturns)
				.globalResponseMessage(RequestMethod.DELETE, defaultReturns)
				.globalResponseMessage(RequestMethod.PUT, defaultReturns)
				.select()
				.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(metaData());
	}

	private ApiInfo metaData() {
		return new ApiInfoBuilder().title("IT2-JAVA-API")
				.description("Exemplo de arquitetura em java").version(version)
				.build();
	}

}
