package com.build.analytics.event;

import java.util.Date;

public interface StreamingEvent {
	String getPartitionId();
	Date getTimestampEventCreated();
}
