package com.build.source.orderitem.dao;

import java.util.Date;

import org.apache.ibatis.session.ResultHandler;

import com.build.analytics.event.order.OrderItemDataEvent;

public interface OrderItemDataAccess {

	long getOrderItemRecordCount(Date startDate, Date endDate);	
	void selectOrderItems(Date startDate, Date endDate, ResultHandler<OrderItemDataEvent> resultHandler);
}
