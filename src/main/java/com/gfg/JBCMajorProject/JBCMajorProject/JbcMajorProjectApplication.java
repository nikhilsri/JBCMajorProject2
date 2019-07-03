package com.gfg.JBCMajorProject.JBCMajorProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class JbcMajorProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(JbcMajorProjectApplication.class, args);
	}

}
