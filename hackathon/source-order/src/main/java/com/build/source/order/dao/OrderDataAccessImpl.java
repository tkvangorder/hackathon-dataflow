package com.build.source.order.dao;

import java.util.Date;

import org.apache.ibatis.session.ResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.build.analytics.event.order.OrderDataEvent;

@Component
public class OrderDataAccessImpl implements OrderDataAccess {

	@Autowired
	private OrderMapper orderMapper;

	@Override
	public long getOrderRecordCount(Date startDate, Date endDate) {
		return orderMapper.getOrderRecordCount(startDate, endDate);
	}

	@Override
	public void selectOrders(Date startDate, Date endDate, ResultHandler<OrderDataEvent> resultHandler) {
		orderMapper.selectOrders(startDate, endDate, resultHandler);
	}

	

}
