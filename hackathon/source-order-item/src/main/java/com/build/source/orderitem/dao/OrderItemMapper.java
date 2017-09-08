package com.build.source.orderitem.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.ResultHandler;

import com.build.analytics.event.order.OrderItemDataEvent;

@Mapper
public interface OrderItemMapper {

	void selectOrderItems(@Param("startDate") Date startDate, @Param("endDate") Date endDate, ResultHandler<OrderItemDataEvent> resultHandler);
	
	@Select("select count(*) from omc.dbo.cart cart with (nolock)"  +
			" inner join omc.dbo.orders orders with (nolock) on cart.cart_orderNumber = orders.ordernumber" + 
			" where orders.OrderDate >= #{startDate} and orders.OrderDate <= #{endDate}")
	long getOrderItemRecordCount(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

}
