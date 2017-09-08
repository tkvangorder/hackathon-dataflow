package com.build.source.customer.dao;

import java.util.Date;

import org.apache.ibatis.session.ResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.build.analytics.event.customer.CustomerDataEvent;

@Component
public class CustomerDataAccessImpl implements CustomerDataAccess {

	@Autowired
	private CustomerMapper customerMapper;

	@Override
	public void selectCustomers(Date startDate, Date endDate, ResultHandler<CustomerDataEvent> resultHandler) {
		customerMapper.selectCustomers(startDate, endDate, resultHandler);
	}

	@Override
	public long getCustomerRecordCount(Date startDate, Date endDate) {
		return customerMapper.getCustomerRecordCount(startDate, endDate);
	}

}
