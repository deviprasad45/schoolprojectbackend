package com.student.management;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ConditionalOnExpression(value = "${useSwagger:false}")
public class SwaggerConfig {
	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api").apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.student.management.web.rest")).paths(postPaths())
				.build();
	}

	/**
	 * Post paths.
	 *
	 * @return the predicate
	 */
	private Predicate<String> postPaths() {
		return or(regex("/*.*"), regex("/api/student.*"));
	}

	/**
	 * Api info.
	 *
	 * @return the api info
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Student Management API")
				.description("Student Management API reference for developers")
				.termsOfServiceUrl("http://studentmanagement.com/").contact("info@studentmanagement.com")
				.license("Student Management License").licenseUrl("http://studentmanagement.com/").version("1.0")
				.build();
	}

}
