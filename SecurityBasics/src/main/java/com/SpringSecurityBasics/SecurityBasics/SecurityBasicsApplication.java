package com.SpringSecurityBasics.SecurityBasics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication()
@EntityScan("models")
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@ComponentScan(basePackages = {"util","filters"})
public class SecurityBasicsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityBasicsApplication.class, args);
	}

}
