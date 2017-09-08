package com.build.source.charge.dao;

import java.util.Date;

import org.apache.ibatis.session.ResultHandler;

import com.build.analytics.event.order.ChargeDataEvent;

public interface ChargeDataAccess {

	long getChargesRecordCount(Date startDate, Date endDate);	
	void selectCharges(Date startDate, Date endDate, ResultHandler<ChargeDataEvent> resultHandler);
}
