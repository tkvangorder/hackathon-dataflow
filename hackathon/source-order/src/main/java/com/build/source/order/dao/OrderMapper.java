package com.build.source.order.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.ResultHandler;

import com.build.analytics.event.order.OrderDataEvent;

@Mapper
public interface OrderMapper {

	void selectOrders(@Param("startDate") Date startDate, @Param("endDate") Date endDate, ResultHandler<OrderDataEvent> resultHandler);
	
	@Select("select count(*) from omc.dbo.orders orders with (nolock) where orders.OrderDate >= #{startDate} and orders.OrderDate <= #{endDate}")
	long getOrderRecordCount(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
