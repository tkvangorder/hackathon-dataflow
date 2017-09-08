package com.build.source.payment.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.ResultHandler;

import com.build.analytics.event.order.PaymentDataEvent;

@Mapper
public interface PaymentMapper {

	void selectPayments(@Param("startDate") Date startDate, @Param("endDate") Date endDate, ResultHandler<PaymentDataEvent> resultHandler);
	
	@Select("select count(*) from omc.dbo.payments payment where payment.DateRequested >= #{startDate} and payment.DateRequested <= #{endDate}")
	long getPaymentRecordCount(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

}
