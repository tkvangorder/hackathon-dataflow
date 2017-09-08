package com.build.source.charge.dao;

import java.util.Date;

import org.apache.ibatis.session.ResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.build.analytics.event.order.ChargeDataEvent;

@Component
public class ChargeDataAccessImpl implements ChargeDataAccess {

	@Autowired
	private ChargeMapper chargeMapper;

	@Override
	public void selectCharges(Date startDate, Date endDate, ResultHandler<ChargeDataEvent> resultHandler) {
		chargeMapper.selectCharges(startDate, endDate, resultHandler);
	}

	@Override
	public long getChargesRecordCount(Date startDate, Date endDate) {
		return chargeMapper.getChargeRecordCount(startDate, endDate);
	}

}
