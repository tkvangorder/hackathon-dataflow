package com.build.source.order.dao;

import java.util.Date;

import org.apache.ibatis.session.ResultHandler;

import com.build.analytics.event.order.OrderDataEvent;

public interface OrderDataAccess {

	long getOrderRecordCount(Date startDate, Date endDate);	
	void selectOrders(Date startDate, Date endDate, ResultHandler<OrderDataEvent> resultHandler);
}
