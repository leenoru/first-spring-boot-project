package com.playdata.springbootprojectre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringBootProjectReApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProjectReApplication.class, args);
	}

}
