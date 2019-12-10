package com.project.projectBus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 * @author adhameldda
 */

@Configuration
@EnableSwagger2
@SpringBootApplication
public class ProjectBusApplication {

	public static void main(String[] args) {



		SpringApplication.run(ProjectBusApplication.class, args);




	}

}



