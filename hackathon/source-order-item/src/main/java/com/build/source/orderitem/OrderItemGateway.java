package com.build.source.orderitem;

import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

import com.build.analytics.event.order.OrderItemDataEvent;

@MessagingGateway
public interface OrderItemGateway {
	
	@Gateway(requestChannel=Source.OUTPUT)
	void sendOrderItemDataEvent(OrderItemDataEvent order);

}
