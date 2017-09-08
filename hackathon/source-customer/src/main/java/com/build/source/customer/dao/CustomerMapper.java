package com.build.source.customer.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.ResultHandler;

import com.build.analytics.event.customer.CustomerDataEvent;

@Mapper
public interface CustomerMapper {

	void selectCustomers(@Param("startDate") Date startDate, @Param("endDate") Date endDate, ResultHandler<CustomerDataEvent> resultHandler);
	
	long getCustomerRecordCount(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

}
