package com.build;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class HackConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(HackConfigApplication.class, args);
	}
}
