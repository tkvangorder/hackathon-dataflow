package com.build.source.customer.dao;

import java.util.Date;

import org.apache.ibatis.session.ResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.build.analytics.event.customer.CustomerAddressDataEvent;

@Component
public class CustomerDataAccessImpl implements CustomerDataAccess {

	@Autowired
	private CustomerMapper customerMapper;

	@Override
	public void selectCustomerAddresses(Date startDate, Date endDate, ResultHandler<CustomerAddressDataEvent> resultHandler) {
		customerMapper.selectCustomerAddresses(startDate, endDate, resultHandler);
	}

	@Override
	public long getCustomerAddressRecordCount(Date startDate, Date endDate) {
		return customerMapper.getCustomerAddressRecordCount(startDate, endDate);
	}

}
