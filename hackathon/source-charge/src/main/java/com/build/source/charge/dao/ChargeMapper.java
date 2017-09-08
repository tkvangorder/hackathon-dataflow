package com.build.source.charge.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.ResultHandler;

import com.build.analytics.event.order.ChargeDataEvent;

@Mapper
public interface ChargeMapper {

	void selectCharges(@Param("startDate") Date startDate, @Param("endDate") Date endDate, ResultHandler<ChargeDataEvent> resultHandler);
	
	@Select("select count(*) from omc.dbo.charges charge with (nolock) where charge.daterequested >= #{startDate} and charge.daterequested <= #{endDate}")
	long getChargeRecordCount(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

}
