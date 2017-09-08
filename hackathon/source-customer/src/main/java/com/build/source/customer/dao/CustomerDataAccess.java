package com.build.source.customer.dao;

import java.util.Date;

import org.apache.ibatis.session.ResultHandler;

import com.build.analytics.event.customer.CustomerDataEvent;

public interface CustomerDataAccess {

	long getCustomerRecordCount(Date startDate, Date endDate);	
	void selectCustomers(Date startDate, Date endDate, ResultHandler<CustomerDataEvent> resultHandler);
}
