package com.build.source.order;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.build.source.order.dao.OrderDataAccess;
import com.build.utilities.DateUtils;

@Component
public class OrderRetrieval {

	private static final Logger logger = LoggerFactory.getLogger(OrderRetrieval.class);
	
	@Value("#{${source.startDate:null}!=null?new java.text.SimpleDateFormat('yyyy-MM-dd').parse('${source.startDate:}'):null}")
	Date startDate;

	@Value("#{${source.endDate:null}!=null?new java.text.SimpleDateFormat('yyyy-MM-dd').parse('${source.endDate:}'):null}")
	Date endDate;
	
	Date dateIndex;
	
	@Autowired
	OrderDataAccess orderDataAccess;

	@Autowired
	OrderGateway orderGateway;

	@PostConstruct
	public void init() throws Exception {
		if (startDate != null) {
			startDate = DateUtils.truncateDate(startDate);
		}
		if (endDate != null) {
			endDate = DateUtils.truncateDate(endDate);
		}
		
		if (startDate == null && endDate != null) {
			startDate = endDate;
		} else if (endDate == null && startDate != null) {
			endDate = startDate;
		} else if (startDate == null) {
			startDate = DateUtils.today();
			endDate = startDate;
		}
		endDate = DateUtils.addDaysToDate(endDate, 1);

		dateIndex = startDate;
		
		logger.info("Checking for orders between {} and {}.", DateUtils.dateToIsoString(startDate), DateUtils.dateToIsoString(endDate)); 	
	}
	
    @Scheduled(fixedRate = 5000)	
	public void retrieve() {
		Date begin = null;
		synchronized (this) {
	    		if (dateIndex.compareTo(endDate) >= 0) {
	    			logger.info("No more charges will be sent.");
	    			return;    		
	    		}

			 begin = dateIndex;
			 dateIndex = DateUtils.addDaysToDate(dateIndex,1);
		}
		Date end = DateUtils.addDaysToDate(begin, 1);

		logger.info("Retrieving for orders on {}.", DateUtils.dateToIsoString(begin)); 
		long orderCount = orderDataAccess.getOrderRecordCount(begin, end);
		
		logger.info("Order Count is {}", orderCount);
		
		orderDataAccess.selectOrders(begin, end,
			resultContext -> orderGateway.sendOrderDataEvent(resultContext.getResultObject())
		);
	}

}
