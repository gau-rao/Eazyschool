package com.easybytes.eazyschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableJpaRepositories("com.easybytes.eazyschool.repository")
@EntityScan("com.easybytes.eazyschool.model")
@SpringBootApplication
public class EazySchoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(EazySchoolApplication.class, args);
	}

}
