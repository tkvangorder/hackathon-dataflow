package com.build.source.customer;

import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

import com.build.analytics.event.customer.CustomerAddressDataEvent;

@MessagingGateway
public interface CustomerAddressGateway {
	
	@Gateway(requestChannel=Source.OUTPUT)
	void sendCustomerAddressDataEvent(CustomerAddressDataEvent address);

}
