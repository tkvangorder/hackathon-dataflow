package com.build.source.customer;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.build.source.customer.dao.CustomerDataAccess;
import com.build.utilities.DateUtils;

@Component
public class CustomerAddressRetrieval {

	private static final Logger logger = LoggerFactory.getLogger(CustomerAddressRetrieval.class);
	
	@Value("#{${source.startDate:null}!=null?new java.text.SimpleDateFormat('yyyy-MM-dd').parse('${source.startDate:}'):null}")
	Date startDate;

	@Value("#{${source.endDate:null}!=null?new java.text.SimpleDateFormat('yyyy-MM-dd').parse('${source.endDate:}'):null}")
	Date endDate;
	
	Date dateIndex;
	
	@Autowired
	CustomerDataAccess customerDataAccess;

	@Autowired
	CustomerAddressGateway customerAddressGateway;

	@PostConstruct
	public void init() {
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
		
		logger.info("Checking for customer addresses between {} and {}.", DateUtils.dateToIsoString(startDate), DateUtils.dateToIsoString(endDate)); 	
	}
	
    @Scheduled(fixedRate = 5000)	
	public void retrieve() {
	
    		Date begin = null;
    		synchronized (this) {
        		if (dateIndex.compareTo(endDate) >= 0) {
        			logger.info("No more customer addresses will be sent.");
        			return;    		
        		}

    			 begin = dateIndex;
    			 dateIndex = DateUtils.addDaysToDate(dateIndex,1);
    		}
    		Date end = DateUtils.addDaysToDate(begin, 1);
    		    		
		long count = customerDataAccess.getCustomerAddressRecordCount(begin, end);

		logger.info("Retrieving for customer addresses changed on {}, Customer Address Count is {}.", DateUtils.dateToIsoString(begin), count); 
		
		customerDataAccess.selectCustomerAddresses(begin, end,
			resultContext -> customerAddressGateway.sendCustomerAddressDataEvent(resultContext.getResultObject())
		);
	}

}
