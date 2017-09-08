package com.build.source.customer.dao;

import java.util.Date;

import org.apache.ibatis.session.ResultHandler;

import com.build.analytics.event.customer.CustomerAddressDataEvent;

public interface CustomerDataAccess {

	long getCustomerAddressRecordCount(Date startDate, Date endDate);	
	void selectCustomerAddresses(Date startDate, Date endDate, ResultHandler<CustomerAddressDataEvent> resultHandler);
}
