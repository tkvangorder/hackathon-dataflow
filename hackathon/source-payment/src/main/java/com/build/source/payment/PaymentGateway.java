package com.build.source.payment;

import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

import com.build.analytics.event.order.PaymentDataEvent;

@MessagingGateway
public interface PaymentGateway {
	
	@Gateway(requestChannel=Source.OUTPUT)
	void sendPaymentDataEvent(PaymentDataEvent order);

}
