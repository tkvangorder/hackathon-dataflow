package com.build.source.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableBinding(Source.class)
@EnableScheduling
public class OrderSourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderSourceApplication.class, args);
	}
	
}
