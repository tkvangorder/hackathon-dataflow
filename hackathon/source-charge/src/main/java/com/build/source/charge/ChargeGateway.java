package com.build.source.charge;

import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

import com.build.analytics.event.order.ChargeDataEvent;

@MessagingGateway
public interface ChargeGateway {
	
	@Gateway(requestChannel=Source.OUTPUT)
	void sendChargeDataEvent(ChargeDataEvent order);

}
