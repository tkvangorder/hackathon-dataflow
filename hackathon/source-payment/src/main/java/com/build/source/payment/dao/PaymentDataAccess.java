package com.build.source.payment.dao;

import java.util.Date;

import org.apache.ibatis.session.ResultHandler;

import com.build.analytics.event.order.PaymentDataEvent;

public interface PaymentDataAccess {

	long getPaymentRecordCount(Date startDate, Date endDate);	
	void selectPayments(Date startDate, Date endDate, ResultHandler<PaymentDataEvent> resultHandler);
}
