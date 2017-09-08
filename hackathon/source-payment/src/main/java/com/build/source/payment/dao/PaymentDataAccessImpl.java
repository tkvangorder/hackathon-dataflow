package com.build.source.payment.dao;

import java.util.Date;

import org.apache.ibatis.session.ResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.build.analytics.event.order.PaymentDataEvent;

@Component
public class PaymentDataAccessImpl implements PaymentDataAccess {

	@Autowired
	private PaymentMapper paymentMapper;

	@Override
	public long getPaymentRecordCount(Date startDate, Date endDate) {
		return paymentMapper.getPaymentRecordCount(startDate, endDate);
	}

	@Override
	public void selectPayments(Date startDate, Date endDate, ResultHandler<PaymentDataEvent> resultHandler) {
		paymentMapper.selectPayments(startDate, endDate, resultHandler);
	}

	

}
