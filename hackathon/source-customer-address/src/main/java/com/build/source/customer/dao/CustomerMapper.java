package com.build.source.customer.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.ResultHandler;

import com.build.analytics.event.customer.CustomerAddressDataEvent;

@Mapper
public interface CustomerMapper {

	void selectCustomerAddresses(@Param("startDate") Date startDate, @Param("endDate") Date endDate, ResultHandler<CustomerAddressDataEvent> resultHandler);
	
	long getCustomerAddressRecordCount(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

}
