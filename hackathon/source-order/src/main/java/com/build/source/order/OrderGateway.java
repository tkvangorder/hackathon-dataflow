package com.build.source.order;

import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

import com.build.analytics.event.order.OrderDataEvent;

@MessagingGateway
public interface OrderGateway {
	
	@Gateway(requestChannel=Source.OUTPUT)
	void sendOrderDataEvent(OrderDataEvent order);

}
