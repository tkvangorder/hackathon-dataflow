package com.build.source.orderitem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableBinding(Source.class)
@EnableScheduling
public class OrderItemSourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderItemSourceApplication.class, args);
	}
	
}
