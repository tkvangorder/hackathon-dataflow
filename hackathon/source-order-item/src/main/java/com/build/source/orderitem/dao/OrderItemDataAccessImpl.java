package com.build.source.orderitem.dao;

import java.util.Date;

import org.apache.ibatis.session.ResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.build.analytics.event.order.OrderItemDataEvent;

@Component
public class OrderItemDataAccessImpl implements OrderItemDataAccess {

	@Autowired
	private OrderItemMapper orderItemMapper;

	@Override
	public long getOrderItemRecordCount(Date startDate, Date endDate) {
		return orderItemMapper.getOrderItemRecordCount(startDate, endDate);
	}

	@Override
	public void selectOrderItems(Date startDate, Date endDate, ResultHandler<OrderItemDataEvent> resultHandler) {
		orderItemMapper.selectOrderItems(startDate, endDate, resultHandler);
	}

	

}
